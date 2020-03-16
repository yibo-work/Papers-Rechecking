package com.rechecking.controller;

import com.rechecking.entity.User;
import com.rechecking.enums.ResultFailureEnum;
import com.rechecking.service.IUserService;
import com.rechecking.utils.AppMD5Util;
import com.rechecking.utils.ResultVOUtil;
import com.rechecking.vo.ResultVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {
    
    @Resource
    private IUserService userService;
    
    @PostMapping("/login")
    public ResultVO login(@RequestBody User loginUser, HttpSession session) {
        //MD5转码
        loginUser.setPassword(AppMD5Util.getMD5(loginUser.getPassword()));
        User user = userService.login(loginUser);
        if (user != null) {
            session.setAttribute("USER", user);
            return ResultVOUtil.success();
        } else {
            return ResultVOUtil.failure(ResultFailureEnum.LOGIN_ERROR);
        }
        
    }
    
    @PostMapping("/register")
    public ResultVO register(@RequestBody User registerUser, HttpSession session) {
        //MD5转码
        registerUser.setPassword(AppMD5Util.getMD5(registerUser.getPassword()));
        User user = userService.register(registerUser);
        session.setAttribute("USER", user);
        return ResultVOUtil.success();
    }
    
    
}
