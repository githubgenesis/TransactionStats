package com.n26.transaction.domain;

/**
 * This class is used for generate statics of transaction
 * @author dhiren
 * @since 19-05-2018
 */
public class TransactionStats {

    private Double sum;
    private Double avg;
    private Double max;
    private Double min;
    private Long count;

    public TransactionStats() {
        this.sum = 0D;
        this.avg = 0D;
        this.max = 0D;
        this.min = 0D;
        this.count = 0L;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public Double getAvg() {
        return avg;
    }

    public void setAvg(Double avg) {
        this.avg = avg;
    }

    public Double getMax() {
        return max;
    }

    public void setMax(Double max) {
        this.max = max;
    }

    public Double getMin() {
        return min;
    }

    public void setMin(Double min) {
        this.min = min;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
