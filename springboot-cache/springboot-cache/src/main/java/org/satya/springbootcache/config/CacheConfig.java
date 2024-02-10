package org.satya.springbootcache.config;

import jakarta.annotation.PostConstruct;
import org.satya.springbootcache.modal.Department;
import org.satya.springbootcache.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.CacheManagerCustomizer;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;

@EnableCaching
@Configuration
@EnableScheduling
public class CacheConfig {
//    @Autowired
//    private CacheManager cacheManager;

//    @Autowired
//    private DepartmentService departmentService;

    // After server startup we can keep depts data in cache.
    /*@PostConstruct
    public void preLoadCache(){
        Cache cache = cacheManager.getCache("application_cache");

        System.out.println("*********** Initializing Cache in CacheConfig *****************");
        List<Department> departments = departmentService.findAllDepts();

        departments.forEach(x-> {
            assert cache != null;
            cache.put(x.getId(),x);
        });
    }*/

    // By using Scheduling we can clear the cache after perticular duration.
   /* @Scheduled(fixedRate = 150000, initialDelay = 15000)
    public void clearCache(){
        System.out.println("************ Clear Cache in Cacheconfig *******************");
        cacheManager.getCacheNames().parallelStream().forEach(name->
                cacheManager.getCache(name).clear()
        );
    }*/


    @Bean
    CacheManagerCustomizer<ConcurrentMapCacheManager> customizer(){
        return new ConcurrentCustomizer();
    }

    class ConcurrentCustomizer implements CacheManagerCustomizer<ConcurrentMapCacheManager>{

        @Override
        public void customize(ConcurrentMapCacheManager cacheManager) {
//            cacheManager.setAllowNullValues(false);
            //cacheManager.setStoreByValue(true);
            System.out.println("customizer invoked!!");
        }
    }
}
