package com.javaminds.spring.batch.config;

import com.javaminds.spring.batch.entity.Customer;
import com.javaminds.spring.batch.partition.ColumnRangePartitioner;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.partition.PartitionHandler;
import org.springframework.batch.core.partition.support.TaskExecutorPartitionHandler;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.PartitionStepBuilder;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@RequiredArgsConstructor
public class SpringBatchConfig {

    private final CustomerWriter customerWriter;

    // READER
    @Bean
    public FlatFileItemReader<Customer> reader() {
        FlatFileItemReader<Customer> itemReader = new FlatFileItemReader<>();
        itemReader.setResource(new FileSystemResource("src/main/resources/customers.csv"));
        itemReader.setName("csvReader");
        itemReader.setLinesToSkip(1);
        itemReader.setLineMapper(lineMapper());
        return itemReader;
    }

    private LineMapper<Customer> lineMapper() {
        DefaultLineMapper<Customer> lineMapper = new DefaultLineMapper<>();
        DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
        tokenizer.setDelimiter(",");
        tokenizer.setStrict(false);
        tokenizer.setNames("id", "firstName", "lastName", "email", "gender", "contactNo", "country", "dob");

        BeanWrapperFieldSetMapper<Customer> mapper = new BeanWrapperFieldSetMapper<>();
        mapper.setTargetType(Customer.class);

        lineMapper.setLineTokenizer(tokenizer);
        lineMapper.setFieldSetMapper(mapper);
        return lineMapper;
    }

    // PROCESSOR
    @Bean
    public CustomerProcessor processor() {
        return new CustomerProcessor();
    }

    // PARTITIONER
    @Bean
    public ColumnRangePartitioner partitioner() {
        return new ColumnRangePartitioner();
    }

    // SLAVE STEP
    @Bean
    public Step slaveStep(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder("slaveStep", jobRepository)
                .<Customer, Customer>chunk(250, transactionManager)
                .reader(reader())
                .processor(processor())
                .writer(customerWriter)
                .build();
    }

    // PARTITION HANDLER
    @Bean
    public PartitionHandler partitionHandler(Step slaveStep) {
        TaskExecutorPartitionHandler handler = new TaskExecutorPartitionHandler();
        handler.setGridSize(4);
        handler.setTaskExecutor(taskExecutor());
        handler.setStep(slaveStep);
        return handler;
    }

    // MASTER STEP
    @Bean
    public Step masterStep(JobRepository jobRepository,
                           PlatformTransactionManager transactionManager,
                           Step slaveStep) {
        return new PartitionStepBuilder(new StepBuilder("masterStep", jobRepository))
                .partitioner("slaveStep", partitioner())
                .partitionHandler(partitionHandler(slaveStep))
                .step(slaveStep)
                .build();
    }

    // JOB
    @Bean
    public Job runJob(JobRepository jobRepository, Step masterStep) {
        return new JobBuilder("importCustomers", jobRepository)
                .start(masterStep)
                .build();
    }

    // TASK EXECUTOR
    @Bean
    public TaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(4);
        executor.setMaxPoolSize(4);
        executor.setQueueCapacity(4);
        executor.initialize(); // Required in Spring Batch 5
        return executor;
    }
}


