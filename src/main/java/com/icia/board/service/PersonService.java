package com.icia.board.service;

import com.icia.board.dto.Person;
import com.icia.board.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public void insert(Person person){

        personRepository.save(person);

    }

    public Optional<Person> find(Person person){

        Optional<Person> optional = personRepository.findById(person.getId());
        log.info("============{}",optional);

        if(optional.isPresent()){
            if(optional.get().getPw().equals(person.getPw())){
                log.info("===============아이디,비밀번호 같음");

                return optional;
            }
        }else{
            log.info("=============아이디없음");

            return null;
        }
        log.info("=============비밀번호다름");
        return null;


    }


}
