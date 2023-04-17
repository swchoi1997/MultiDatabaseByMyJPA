package com.example.doubledatabasetest.test1.repository;

import com.example.doubledatabasetest.test1.domain.Test1;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Test1Repository extends JpaRepository<Test1, Long> {
    Test1 findByTest1(String test1);
}
