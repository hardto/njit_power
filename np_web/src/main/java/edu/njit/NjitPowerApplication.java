package edu.njit;

import edu.njit.mapper.UserMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@MapperScan("edu")
@SpringBootApplication
public class NjitPowerApplication {
    public static void main(String[] args) {
        SpringApplication.run(NjitPowerApplication.class, args);
    }
}
