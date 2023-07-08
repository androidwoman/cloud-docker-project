package com.springboot.docker.models;



import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "example")
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    @Column(name = "property_one", nullable = false)
    private String propertyOne;

    @NotNull
    @Column(name = "property_two", nullable = false)
    private String propertyTwo;


    @Override
    public String toString()
    {
        return "ExampleEntity{" +
                "id=" + id +
                ", propertyOne='" + propertyOne + '\'' +
                ", propertyTwo='" + propertyTwo + '\'' +
                '}';
    }
}
