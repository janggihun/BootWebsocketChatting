package com.icia.board.controller;


import com.icia.board.dto.Person;
import com.icia.board.service.PersonService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
@Slf4j
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping("/singup")
    public String singup(Person person){

       personService.insert(person);
        System.out.println("person = " + person);

        return "redirect:/mychatt";
    }

    @PostMapping("/find")
    public @ResponseBody Optional<Person> login(Person person, Model model, HttpSession session){

        log.info("=========={}",person);
      Optional<Person> result = personService.find(person);
      log.info("==============={}",result);
    if(result !=null){
        session.setAttribute("id" , person.getId());
    }
      return result;

    }


}
