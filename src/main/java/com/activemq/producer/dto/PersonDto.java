package com.activemq.producer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonDto implements Serializable {

    private static final long serialVersionUID = 1L;
    private String id;
    private String lastName;
    private String firstName;
    private int age;
    private String email;
}