package org.satya.springbootcache.service;

import org.satya.springbootcache.modal.Department;
import org.satya.springbootcache.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository deptRepo;

    @Cacheable("all_depts")
    public List<Department> findAllDepts() {
        System.out.println("*** findAllDepts in Service");
        return deptRepo.findAll();
    }

    @Cacheable(value="application_cache",key="#id") // if the key is available in cache it will it will return the value from cache other wise will execute the method.
    public Department findDeptById(long id) {
        return deptRepo.findById(id).orElse(null);
    }

    @CachePut(value="application_cache",key="#id") // event the key is available in cache it will execute the method and put the new value in the cache
    public Department findDeptById2(long id) {
        return deptRepo.findById(id).orElse(null);
    }

    @CacheEvict(value = "application_cache",allEntries = true)
    public String clearAllCache() {
        System.out.println("All Cache was cleared!");
        return "All Cache was cleared!";
    }

    @CacheEvict(value = "application_cache",key="#id")
    public String clearCache(Long id) {
        System.out.println("Cache with key="+id+" was cleared!");
        return "Cache with key="+id+" was cleared!";
    }
}
