package edu.njit.controller;

import edu.njit.Message.SimpleSystemMessage;
import edu.njit.annotation.Token;
import edu.njit.service.SystemService;
import edu.njit.service.UserService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin
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
    @RequestMapping(value = "/hasUser",method = RequestMethod.GET)
    @Token(save=true)
    public @ResponseBody SimpleSystemMessage hasUser(String account,String password,HttpServletRequest request){
        return userService.hasUser(account,password,request);
    }

}
