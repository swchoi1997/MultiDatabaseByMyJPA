package com.example.doubledatabasetest;

import com.example.doubledatabasetest.test1.domain.Test1;
import com.example.doubledatabasetest.test1.repository.Test1Repository;
import com.example.doubledatabasetest.test2.domain.Test2;
import com.example.doubledatabasetest.test2.repository.Test2Repository;
import javax.persistence.EntityManager;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class MultiDataBaseTest {

    @Autowired
    private Test1Repository test1Repository;
    @Autowired
    private Test2Repository test2Repository;

    @Autowired
    EntityManager entityManager;

    @AfterEach
    public void after(){
        test1Repository.deleteAll();
        test2Repository.deleteAll();

    }

    @Test
    public void test1Test() throws InterruptedException {
        Test1 test1 = Test1.builder().test1("test1").build();

        test1Repository.saveAndFlush(test1);

        Thread.sleep(1000);

        Test1 out = test1Repository.findByTest1("test1");
        Assertions.assertThat(out.getTest1()).isEqualTo(test1.getTest1());
    }

    @Test
    public void test2Test() throws InterruptedException {
        Test2 test2 = Test2.builder().test2("test2").build();

        test2Repository.saveAndFlush(test2);

        Thread.sleep(1000);

        Test2 out = test2Repository.findByTest2("test2");
        Assertions.assertThat(out.getTest2()).isEqualTo(test2.getTest2());
    }


}
