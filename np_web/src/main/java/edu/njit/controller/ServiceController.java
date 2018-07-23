package edu.njit.controller;

import edu.njit.Message.SimpleSystemMessage;
import edu.njit.annotation.Token;
import edu.njit.model.User;
import edu.njit.service.SystemService;
import edu.njit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin
@RequestMapping("/service")
public class ServiceController {
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/updateUser",method = RequestMethod.POST)
    public @ResponseBody
    SimpleSystemMessage updateUser(User user){
        return userService.updateUser(user);
    }

}
