package edu.njit.controller;

import edu.njit.Message.SimpleSystemMessage;
import edu.njit.Message.SystemMessage;
import edu.njit.NjitPowerApplication;
import edu.njit.WebUtils.ObectUtils;
import edu.njit.mapper.BasicUserMapper;
import edu.njit.mapper.UserMapper;
import edu.njit.model.User;
import edu.njit.service.SystemService;
import edu.njit.service.UserService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    private SystemService systemService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/sendMail",method = RequestMethod.POST)
    public @ResponseBody SimpleSystemMessage sendMail(String email, HttpServletRequest request){
        return systemService.sendEmail(request,email);
    }

    @RequestMapping(value = "/validMailCode",method = RequestMethod.POST)
    public @ResponseBody SimpleSystemMessage validMailCode(String code, HttpServletRequest request){
        return systemService.validMailCode(request,code);
    }
    @RequestMapping(value = "/hasUser",method = RequestMethod.POST)
    public @ResponseBody SimpleSystemMessage hasUser(String account,String password,HttpServletRequest request){
        return userService.hasUser(account,password,request);
    }

    @RequestMapping(value = "/updateUser",method = RequestMethod.POST)
    public @ResponseBody SimpleSystemMessage updateUser(User user){
        return userService.updateUser(user);
    }



}
