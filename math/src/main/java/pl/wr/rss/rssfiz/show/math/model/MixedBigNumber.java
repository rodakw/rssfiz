package pl.wr.rss.rssfiz.show.math.model;

import java.math.BigInteger;

/**
 * @author Wieslaw
 *
 */
public class MixedBigNumber {

	BigInteger total1;
	BigInteger total2;
	BigInteger numerator1;
	BigInteger numerator2;
	BigInteger denominator1;
	BigInteger denominator2;
	Integer decimalPower1;
	Integer decimalPower2;
	String operation;
	
    public BigInteger getTotal1() {
        return total1;
    }
    public void setTotal1(BigInteger total1) {
        this.total1 = total1;
    }
    public BigInteger getTotal2() {
        return total2;
    }
    public void setTotal2(BigInteger total2) {
        this.total2 = total2;
    }
    public BigInteger getNumerator1() {
        return numerator1;
    }
    public void setNumerator1(BigInteger numerator1) {
        this.numerator1 = numerator1;
    }
    public BigInteger getNumerator2() {
        return numerator2;
    }
    public void setNumerator2(BigInteger numerator2) {
        this.numerator2 = numerator2;
    }
    public BigInteger getDenominator1() {
        return denominator1;
    }
    public void setDenominator1(BigInteger denominator1) {
        this.denominator1 = denominator1;
    }
    public BigInteger getDenominator2() {
        return denominator2;
    }
    public void setDenominator2(BigInteger denominator2) {
        this.denominator2 = denominator2;
    }
    public Integer getDecimalPower1() {
        return decimalPower1;
    }
    public void setDecimalPower1(Integer decimalPower1) {
        this.decimalPower1 = decimalPower1;
    }
    public Integer getDecimalPower2() {
        return decimalPower2;
    }
    public void setDecimalPower2(Integer decimalPower2) {
        this.decimalPower2 = decimalPower2;
    }
    public String getOperation() {
        return operation;
    }
    public void setOperation(String operation) {
        this.operation = operation;
    }

}
