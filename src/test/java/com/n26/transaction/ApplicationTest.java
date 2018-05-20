package com.n26.transaction;

import com.n26.transaction.controller.TransactionController;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * This is test class for {@link Application} startup
 * @author dhiren
 * @since 19-05-2018
 * @see Application
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {

    @Autowired
    private TransactionController transactionController;

    @Test
    public void contextLoads() {
        Assertions.assertThat(transactionController).isNotNull();
    }
}