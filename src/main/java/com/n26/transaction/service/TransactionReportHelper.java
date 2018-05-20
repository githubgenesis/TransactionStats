package com.n26.transaction.service;

import com.n26.transaction.domain.Transaction;
import com.n26.transaction.domain.TransactionStats;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

/**
 * This is helper class for compute {@link TransactionStats} along with {@link Transaction}
 * @author dhiren
 * @since 19-05-2018
 */

@Component
public class TransactionReportHelper {

    private Long lastUpdatedTransactionTimeStamp;
    private static final List<Transaction> TRANSACTIONS = Collections.synchronizedList(new ArrayList<>());
    private static final Long SIXTY_SECOND_CONST = 60000L;
    private final TransactionStats UPDATED_TRANSACTION_STATS = new TransactionStats();

    /**
     * This method is used for add {@link Transaction} into {@link Transaction} list
     * @param transaction {@link Transaction}
     */
    void addTransaction(Transaction transaction) {
        TRANSACTIONS.add(transaction);
    }

    /**
     * This is schedule clear {@link Transaction} from list based on time frame condition (60 second) along with update latest statics
     */
    @Scheduled(fixedDelay = 1000)
    public void clearTransactionList() {
        if (!TRANSACTIONS.isEmpty()) {
            Long currentUtcMillSecond = Instant.now().toEpochMilli();
            TRANSACTIONS.removeIf(transaction -> currentUtcMillSecond - transaction.getTimestamp() > SIXTY_SECOND_CONST);
            computeTransactionStats();
        }
    }

    /**
     * This method is used compute {@link TransactionStats} in background
     */
    private void computeTransactionStats() {
        CompletableFuture.runAsync(() -> {
            Long currentUtcMillSecond = Instant.now().toEpochMilli();
            Supplier<Stream<Transaction>> transactionStream = () -> TRANSACTIONS.stream().filter(transactionStats ->
                    currentUtcMillSecond - transactionStats.getTimestamp() <= SIXTY_SECOND_CONST);
            Supplier<DoubleStream> amountDoubleStream = () -> transactionStream.get().mapToDouble(Transaction::getAmount);
            this.lastUpdatedTransactionTimeStamp = transactionStream.get().mapToLong(Transaction::getTimestamp).max().orElse(0L);
            UPDATED_TRANSACTION_STATS.setCount(transactionStream.get().count());
            UPDATED_TRANSACTION_STATS.setSum(amountDoubleStream.get().sum());
            UPDATED_TRANSACTION_STATS.setMax(amountDoubleStream.get().max().orElse(0D));
            UPDATED_TRANSACTION_STATS.setMin(amountDoubleStream.get().min().orElse(0D));
            UPDATED_TRANSACTION_STATS.setAvg(amountDoubleStream.get().average().orElse(0D));
        });
    }

    Long getLastUpdatedTransactionTimeStamp() {
        return lastUpdatedTransactionTimeStamp;
    }

    TransactionStats getUPDATED_TRANSACTION_STATS() {
        return UPDATED_TRANSACTION_STATS;
    }
}
