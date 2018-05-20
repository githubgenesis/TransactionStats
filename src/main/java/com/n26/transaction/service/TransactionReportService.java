package com.n26.transaction.service;

import com.n26.transaction.domain.Transaction;
import com.n26.transaction.domain.TransactionStats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Objects;

/**
 * This is service class for add {@link Transaction}
 * @author dhiren
 * @since 19-05-2018
 * @see TransactionReportHelper
 */
@Service
public class TransactionReportService {
    private static final Long SIXTY_SECOND_CONST = 60000L;

    @Autowired
    private TransactionReportHelper transactionReportHelper;

    /**
     * This method is used add {@link Transaction} with timestamp check
     * @param transaction {@link Transaction}
     * @return boolean flag
     */
    public boolean addTransaction(Transaction transaction) {
        if (Instant.now().toEpochMilli() - transaction.getTimestamp() > SIXTY_SECOND_CONST) {
            return false;
        }
        transactionReportHelper.addTransaction(transaction);
        return true;
    }

    /**
     * This method return Current {@link TransactionStats} with time filter
     * @return {@link TransactionStats}
     */
    public TransactionStats getTransactionStats() {
        return Objects.isNull(transactionReportHelper.getLastUpdatedTransactionTimeStamp()) ||
                transactionReportHelper.getLastUpdatedTransactionTimeStamp() == 0 || (Instant.now().toEpochMilli() -
                transactionReportHelper.getLastUpdatedTransactionTimeStamp() > SIXTY_SECOND_CONST) ?
                new TransactionStats() : transactionReportHelper.getUPDATED_TRANSACTION_STATS();
    }
}
