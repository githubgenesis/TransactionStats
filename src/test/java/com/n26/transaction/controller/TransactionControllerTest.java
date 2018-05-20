package com.n26.transaction.controller;

import com.n26.transaction.domain.Transaction;
import com.n26.transaction.domain.TransactionStats;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Instant;

/**
 * This is test class for {@link TransactionController}
 * @author dhiren
 * @since 19-05-2018
 * @see TransactionController
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TransactionControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    private final long SIXTY_SECOND_IN_MILI = 60000;

    /**
     * This method initialize memory store
     */
    @Before
    public void initializeStore() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        Transaction transaction = new Transaction();
        Long currentUTCTimeMili = Instant.now().toEpochMilli();
        transaction.setAmount(10D);
        transaction.setTimestamp(currentUTCTimeMili);
        HttpEntity<Transaction> httpEntity = new HttpEntity<>(transaction, httpHeaders);
        Assertions.assertThat(this.testRestTemplate.exchange(String.format("http://localhost:%d/transactions", port),
                HttpMethod.POST, httpEntity, Boolean.class).getStatusCode()).isEqualTo(HttpStatus.CREATED);
        transaction.setAmount(20D);
        transaction.setTimestamp(currentUTCTimeMili);
        httpEntity = new HttpEntity<>(transaction, httpHeaders);
        Assertions.assertThat(this.testRestTemplate.exchange(String.format("http://localhost:%d/transactions", port),
                HttpMethod.POST, httpEntity, Boolean.class).getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }

    /**
     * This method perform integration test for add transaction request end point with all use case
     */
    @Test
    public void addTransaction() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        Transaction transaction = new Transaction();
        Long currentUTCTimeMili = Instant.now().toEpochMilli();
        transaction.setAmount(10D);
        transaction.setTimestamp(currentUTCTimeMili);
        HttpEntity<Transaction> httpEntity = new HttpEntity<>(transaction, httpHeaders);
        // Check for transaction is successfully added
        Assertions.assertThat(this.testRestTemplate.exchange(String.format("http://localhost:%d/transactions", port),
                HttpMethod.POST, httpEntity, Boolean.class).getStatusCode()).isEqualTo(HttpStatus.CREATED);
        transaction.setAmount(20D);
        //Check for transaction is rejected by controller
        transaction.setTimestamp(currentUTCTimeMili - SIXTY_SECOND_IN_MILI);
        httpEntity = new HttpEntity<>(transaction, httpHeaders);
        Assertions.assertThat(this.testRestTemplate.exchange(String.format("http://localhost:%d/transactions", port),
                HttpMethod.POST, httpEntity, Boolean.class).getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
    }

    /**
     * This method perform integration test for get statistics request end point with all use case
     * @throws InterruptedException
     */
    @Test
    public void getStatistics() throws InterruptedException {
        ResponseEntity<TransactionStats> transactionStatsResponseEntity = this.testRestTemplate.getForEntity(
                String.format("http://localhost:%d/statistics", port), TransactionStats.class);
        Assertions.assertThat(transactionStatsResponseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        TransactionStats transactionStats = transactionStatsResponseEntity.getBody();
        //Check for transaction statics getting data
        Assertions.assertThat(transactionStats.getCount()).isGreaterThan(0L);
        Assertions.assertThat(transactionStats.getSum()).isGreaterThan(0L);
        // Simulating SIXTY_SECOND_IN_MILI and again request for statics
        Thread.sleep(SIXTY_SECOND_IN_MILI);
        transactionStatsResponseEntity = this.testRestTemplate.getForEntity(String.format("http://localhost:%d/statistics", port), TransactionStats.class);
        Assertions.assertThat(transactionStatsResponseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        transactionStats = transactionStatsResponseEntity.getBody();
        Assertions.assertThat(transactionStats.getCount()).isEqualTo(0);
    }
}