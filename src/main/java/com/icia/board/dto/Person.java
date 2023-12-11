package com.icia.board.dto;


import jakarta.persistence.*;
import jdk.jfr.DataAmount;
import lombok.*;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person {



    @Id
    private String id;


    @Column
    private String pw;

    @Column(length = 10)
    private String name;



}
