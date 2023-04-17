package com.example.doubledatabasetest.test2.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
public class Test2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String test2;

    public Test2() {

    }

    public Test2(Long id, String test2) {
        this.id = id;
        this.test2 = test2;
    }
}
