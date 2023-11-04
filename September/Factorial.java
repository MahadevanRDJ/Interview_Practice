package September;

import java.math.BigDecimal;

public class Factorial {
    public static void main(String[] args) {
        Factorial factorial = new Factorial();
        factorial.findByFactorial(125);
        factorial.find(125);
    }

    private void find(int n) {
        int count = 0;

        while((n /= 5) > 0) 
            count += n;
        
        System.out.println(count);
    }

    private void findByFactorial(int n) {
        BigDecimal fact = new BigDecimal(1);
        for (int i = 1; i <= n; i++) {
            fact = fact.multiply(new BigDecimal(i));
        }
        int count = 0;
        while((fact.divideAndRemainder(new BigDecimal(10))[1]).equals(new BigDecimal(0))) {
            count++;
            fact = fact.divide(new BigDecimal(10));
        }
        System.out.println(fact + " " + count);
    }

}
