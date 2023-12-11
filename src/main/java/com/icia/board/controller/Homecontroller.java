package com.icia.board.controller;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class Homecontroller {
    HttpSession session;
    @GetMapping("/join")
    public String join(){

        return "join";
    }

    @GetMapping("/")
    public String home(){

        return "redirect:/mychatt";
    }


    @GetMapping("/login")
    public  String login(){
        return "login";

    }
    @GetMapping("/logout")
    public  String logout(){

    return "redirect:/";
    }
}
