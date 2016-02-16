package kr.jadekim.oj.mainserver.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import kr.jadekim.oj.mainserver.entity.User;
import kr.jadekim.oj.mainserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.ExecutionException;

/**
 * Created by ohyongtaek on 2016. 1. 22..
 */

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    private Gson gson = new GsonBuilder().create();



    @RequestMapping(value = "/api/v1/join",method = RequestMethod.POST)
    public @ResponseBody
    String joinUser(HttpServletRequest request) throws ExecutionException, InterruptedException {
        User user = userService.join(request.getParameter("login_id"),request.getParameter("login_pw"),request.getParameter("name"),request.getParameter("email")).get();
//        System.out.println(request);
        return gson.toJson(user);
    }

    @RequestMapping(value = "/api/v1/login",method = RequestMethod.POST)
    public @ResponseBody String loginUser(HttpServletRequest request) throws ExecutionException, InterruptedException {
        User user = userService.login(request.getParameter("login_id"),request.getParameter("login_pw")).get();
        if(user == null){
            User user1 = new User();
            user1.setId(-1);
            return gson.toJson(user1);
        }else{
            return gson.toJson(user);
        }
    }
}
