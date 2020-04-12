package com.example.web;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.domain.User;
import com.example.service.UserService;

import java.util.Date;

@Controller
@RequestMapping(value = "/admin")
public class LoginController {

    private UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/login.html")
    public String loginPage() {
        //model을 어느 view랑 해서 고객단에 보여줄지 - 리턴 값은 p:suffix=".jsp" 앞에 붙음 : WEB-INF/jsp 아래있는 jsp 파일이름 적으면됨
        return "login";
    }

    @RequestMapping(value = "/loginCheck.html")
    public ModelAndView loginCheck(HttpServletRequest request, @Valid LoginInfo loginInfo, BindingResult result) {

        if(result.hasErrors()){
            return new ModelAndView("login", "error", result.getFieldError().getDefaultMessage());
        }else{
            boolean isValidUser =
                    userService.hasMatchUser(loginInfo.getUserName(),
                            loginInfo.getPassword());
            if (!isValidUser) {
                return new ModelAndView("login", "error", "用户名或密码错误。");
            } else {
                User user = userService.findUserByUserName(loginInfo
                        .getUserName());
                user.setLastIp(request.getLocalAddr());
                user.setLastVisit(new Date());
                userService.saveLog(user);
                request.getSession().setAttribute("user", user);
                return new ModelAndView("main");
            }
        }

    }
}
