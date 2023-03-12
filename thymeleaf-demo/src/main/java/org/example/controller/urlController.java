package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @Author: Fang Jinxu
 * @Description:
 * @Date: 2023-03-12 10:53
 */
@Controller
public class urlController {

    @GetMapping("/index")
    public String getIndex(Model model) {
        model.addAttribute("name", "jxfang");
        return "index";
    }

    @PostMapping("/login")
    public String login(@RequestParam("userName") String userName,
                        @RequestParam("password") String password,
                        @RequestParam("verifyCode") String verifyCode,
                        HttpSession session) {
        session.setAttribute("userName", userName);
        session.setAttribute("password", password);
        return "redirect:/hello";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/hello")
    public String hello(HttpSession session, Model model) {
        model.addAttribute("name", session.getAttribute("userName"));
        return "hello";
    }

}