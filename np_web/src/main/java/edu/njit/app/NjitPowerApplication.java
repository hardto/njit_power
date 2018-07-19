package edu.njit.app;

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

@MapperScan("edu.njit.mapper")
@SpringBootApplication
@Controller
public class NjitPowerApplication {

    private Logger logger = LoggerFactory.getLogger(NjitPowerApplication.class);

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/log")
    public String hello(Model model){
//        modelAndView.addObject("users",userMapper.getAll());
        logger.error("============由于表里是空的==================");
        logger.error(userMapper.getAll().size()+"\n");
        List<Map<String,String>> list = new ArrayList<Map<String,String>>(0) ;
        Map<String,String> map = new HashMap<>();
        map.put("text","lizhenyu");
        map.put("text","wangdong");
        list.add(map);
        model.addAttribute("users",list);
        logger.error("==============================");
//        modelAndView.setViewName("/sign/index");
        return "/sign/index";
    }
    public static void main(String[] args) {
        SpringApplication.run(NjitPowerApplication.class, args);
    }
}
