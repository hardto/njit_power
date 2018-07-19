package edu.njit.app;

import edu.njit.test.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class NjitPowerApplication {
    @Autowired
    private Test test;

    @RequestMapping("/")
    public String hello(){
        test.say("lizhenyu");
        return "index";
    }
    public static void main(String[] args) {
        SpringApplication.run(NjitPowerApplication.class, args);
    }
}
