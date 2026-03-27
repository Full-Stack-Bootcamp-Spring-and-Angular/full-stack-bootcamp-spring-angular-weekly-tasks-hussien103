package com.Example.Models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Setter
@Getter
public class Plane implements Vehicle {
    private int id;
    private String model;
    private Type type;
}
