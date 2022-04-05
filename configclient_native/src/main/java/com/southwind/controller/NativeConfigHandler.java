package com.southwind.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/native")
public class NativeConfigHandler {
    @Value("${server.port}")
    private String port;
    @Value("${foo}")
    private String foo;

    @RequestMapping("/index")
    public String index() {
        return this.port + "-------------------------" + this.foo;
    }
}
