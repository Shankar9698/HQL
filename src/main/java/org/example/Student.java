package org.example;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
@Data
@Entity
public class Student {
    @Id
    private int id;
    private String name;
    private String city;
    private String state;
}
