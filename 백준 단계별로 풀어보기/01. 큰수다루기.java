import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

class Main {
    public static void main(String[] args) throws IOException{
        BigInteger bigNum1 = new BigInteger("0");
        BigInteger bigNum2 = new BigInteger("1");

        BigInteger zero = BigInteger.ZERO;
        BigInteger one = BigInteger.ONE;
        BigInteger ten = BigInteger.TEN;

        BigInteger sum = bigNum1.add(bigNum2);
        BigInteger sub = bigNum1.subtract(bigNum2);
        BigInteger mul = bigNum1.multiply(bigNum2);
        BigInteger div = bigNum1.divide(bigNum2);
        BigInteger mod = bigNum1.remainder(bigNum2);

        int intVal = bigNum1.intValue();
        long longVal = bigNum1.longValue();
        String strVal = bigNum1.toString();

        if(bigNum1.compareTo(bigNum2)<0)
            System.out.printf("%s가 %s보다 큼\n", bigNum1.toString(), bigNum2.toString());

        System.out.printf("%,d, %5.3f\n", 100000000, 28.2939);

        BigDecimal bigDec = new BigDecimal("123456789.1234567890");
        System.out.printf("실수 큰수: %.7f\n", bigDec);

    }
}