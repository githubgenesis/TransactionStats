package com.n26.transaction.controller;

import com.n26.transaction.domain.Transaction;
import com.n26.transaction.domain.TransactionStats;
import com.n26.transaction.service.TransactionReportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * This controller is used for handle all request
 *  @author dhiren
  * @since 19-05-2018
 * @see TransactionReportService
 */
@RestController
public class TransactionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionController.class);

    @Autowired
    private TransactionReportService transactionReportService;


    /**
     * This method handle request of add {@link Transaction}
     * @param transaction {@link Transaction}
     * @return ResponseEntity with status code
     */
    @PostMapping(value = "/transactions")
    ResponseEntity<Boolean> addTransaction(@RequestBody @Valid Transaction transaction) {
        LOGGER.info("Add transactions request");
        try {
                boolean isAdded = transactionReportService.addTransaction(transaction);
                if (!isAdded) {
                    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
                }
                return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            LOGGER.error("Error in add transactions", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * This method handle request of get {@link TransactionStats}
     * @return {@link TransactionStats} as Response
     */
    @GetMapping(value = "/statistics")
    ResponseEntity<TransactionStats> getStatistics() {
        LOGGER.info("Get current statistics");
        try {
                return ResponseEntity.ok(transactionReportService.getTransactionStats());
        } catch (Exception e) {
            LOGGER.error("Error in get current statistics", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
