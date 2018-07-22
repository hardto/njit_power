package edu.njit.controller;

import edu.njit.Message.SimpleSystemMessage;
import edu.njit.NjitPowerApplication;
import edu.njit.mapper.BasicUserMapper;
import edu.njit.mapper.UserMapper;
import edu.njit.service.SystemService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class LoginController {
    private Logger logger = LoggerFactory.getLogger(NjitPowerApplication.class);

//    @Autowired
//    private BasicUserMapper basicUserMapper;

    @Autowired
    private SystemService systemService;

    @RequestMapping("/log")
    public String hello(Model model){
        logger.error("============查出表中数据开始==================");
//        logger.error(basicUserMapper.isStuWithFlag("1")+"\n");
//        List<Map<String,String>> list = new ArrayList<Map<String,String>>(0) ;
//        Map<String,String> map = new HashMap<>();
//        map.put("text","lizhenyu");
//        map.put("text","wangdong");
//        list.add(map);
//        model.addAttribute("users",list);
        logger.error("============查出表中数据结束==================");
        return "/sign/index";
    }

    @RequestMapping("/sendMail")
    public @ResponseBody SimpleSystemMessage sendMail(String email, HttpServletRequest request){
        return systemService.sendEmail(request,email);
    }
}
