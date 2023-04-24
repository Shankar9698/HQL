package org.example;

import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;
@Cacheable
@Cache(usage= CacheConcurrencyStrategy.READ_ONLY)
@Data
@Entity
public class Student {
    @Id
    private int id;
    private String name;
    private int sal;
    private String city;
    private String state;
    private String country;
}
