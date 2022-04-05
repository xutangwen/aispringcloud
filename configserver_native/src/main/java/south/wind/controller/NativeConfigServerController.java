package south.wind.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/native")
public class NativeConfigServerController {
    @RequestMapping("/index")
    public String index() {
        return "Hello world";
    }
}
