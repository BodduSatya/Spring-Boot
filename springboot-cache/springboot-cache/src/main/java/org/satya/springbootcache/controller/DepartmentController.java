package org.satya.springbootcache.controller;

import org.satya.springbootcache.modal.Department;
import org.satya.springbootcache.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService deptService;

    @GetMapping("/dept/findAll")
    public List<Department> findAllDepts(){
        System.out.println("findAllDepts");
        return deptService.findAllDepts();
    }

    @GetMapping("/dept/{id}")
    public Department findDeptById(@PathVariable long id){
        return deptService.findDeptById(id);
    }

    @GetMapping("/dept_v2/{id}")
    public Department findDeptById_v2(@PathVariable long id){
        return deptService.findDeptById2(id);
    }

    @GetMapping("/dept/clearAllCache")
    public String clearAllCache(){
        return deptService.clearAllCache();
    }

    @GetMapping("/dept/clearCache/{id}")
    public String clearCache(@PathVariable Long id){
        return deptService.clearCache(id);
    }

}
