package com.springboot.docker.dto;

import org.springframework.context.annotation.Description;

import java.io.Serializable;


public class StudentDTO implements Serializable {

    private static final Long serialVersionUID = 1L;

    private String propOne;
    private String propTwo;

    public StudentDTO() { }

    public StudentDTO(String propOne, String propTwo)
    {
        this.propOne = propOne;
        this.propTwo = propTwo;
    }

    public String getPropOne() {
        return propOne;
    }

    public void setPropOne(String propOne) {
        this.propOne = propOne;
    }

    public String getPropTwo() {
        return propTwo;
    }

    public void setPropTwo(String propTwo) {
        this.propTwo = propTwo;
    }

    @Override
    public String toString()
    {
        return "StudentDTO{" +
                "propOne='" + propOne + '\'' +
                ", propTwo='" + propTwo + '\'' +
                '}';
    }
}
