package com.berkansahan.weather.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author berkansahan
 */
@RestController
@RequestMapping("test")
public class TestController {

    @GetMapping
    public String test(){
        return "selam";
    }
}
