package com.activemq.producer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarDto implements Serializable {

    private static final long serialVersionUID = 1L;
    private String id;
    private String mark;
    private String model;
    private int year;
    private String color;
}
