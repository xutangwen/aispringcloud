package com.southwind.controller;

import com.southwind.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

@RestController
@RequestMapping("/ribbon")
public class RibbonHandler {
    @Autowired
    private RestTemplate restTemplate;


    @RequestMapping("/findAll")
    public Collection<Student> findAll() {
        return restTemplate.getForObject("http://provider/student/findAll", Collection.class);
        //这里使用provider  是因为provider已经作为服务注册到服务中心了
    }

    @RequestMapping("/index")
    public String index() {
        return restTemplate.getForObject("http://provider/student/index", String.class);
    }
}
