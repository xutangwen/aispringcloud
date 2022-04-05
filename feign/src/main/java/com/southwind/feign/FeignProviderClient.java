package com.southwind.feign;

import com.southwind.entity.Student;
import com.southwind.feign.impl.FeignError;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@FeignClient(value = "provider",fallback = FeignError.class)//这个provider是注册中心里面服务的名称    fallback代表降级处理，出现错误后跳转到FeignError中
public interface FeignProviderClient {
    @GetMapping("/student/findAll")
    public Collection<Student> findAll();

    @GetMapping("/student/index")
    public String index();
}
