package com.example.doubledatabasetest.test2.repository;

import com.example.doubledatabasetest.test2.domain.Test2;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Test2Repository extends JpaRepository<Test2, Long> {
    Test2 findByTest2(String test2);
}
