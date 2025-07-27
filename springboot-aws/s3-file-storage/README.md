# s3-file-storage-example

<img width="940" height="518" alt="image" src="https://github.com/user-attachments/assets/3083e347-7328-49f4-a5eb-c24de1dc2fd1" />
<img width="940" height="488" alt="image" src="https://github.com/user-attachments/assets/458a351b-c6cb-49fd-bd4b-11b34899c9cf" />
<img width="940" height="452" alt="image" src="https://github.com/user-attachments/assets/78f72de0-fe0c-409d-83d8-1a81ac4ac953" />

we can either use “aws-java-sdk” from maven

<!-- https://mvnrepository.com/artifact/com.amazonaws/aws-java-sdk -->
```
<dependency>
    <groupId>com.amazonaws</groupId>
    <artifactId>aws-java-sdk</artifactId>
    <version>1.11.486</version>
</dependency>
```

or we could use spring-cloud-starter-aws.

```
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-aws</artifactId>
</dependency>
```
since I’m using spring cloud I have used the “spring-cloud-starter-aws” for this sample app.
