package com.example.doubledatabasetest.test1.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
public class Test1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String test1;

    public Test1() {

    }

    public Test1(Long id, String test1) {
        this.id = id;
        this.test1 = test1;
    }
}
