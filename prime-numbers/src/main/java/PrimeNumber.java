import java.math.BigInteger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Java Program to computer sum of prime number in a given range
 */
public class PrimeNumber {
    public static void main(String[] args) {
        int startRange = 1, endRange = 10;
        System.out.println(primeSum(startRange, endRange));

        System.out.println("\nTotal Prime Numbers : " + totalPrimeNumbers());
        System.out.println("\nSum Of Prime Numbers : " + sumPrimeNumbers());

        //testTwo();
    }

    private static long sumPrimeNumbers() {
        return Stream.iterate(0, t -> t + 1)
                .limit(10)
                .filter(PrimeNumber::isPrime)
                .mapToLong(Long::valueOf)
                .sum();
    }

    private static void testTwo() {
        Stream.iterate(BigInteger.valueOf(2), BigInteger::nextProbablePrime)
                .limit(10)
                .forEach(x -> System.out.format("%s\t", x));
    }

    private static long totalPrimeNumbers() {
        return Stream.iterate(0, t -> t + 1)
                .limit(10)
                .filter(PrimeNumber::isPrime)
                .peek(x -> System.out.format("%s\t", x))
                .count();
    }

    static boolean checkPrime(int numberToCheck) {
        if (numberToCheck == 1) {
            return false;
        }
        for (int i = 2; i * i <= numberToCheck; i++) {
            if (numberToCheck % i == 0) {
                return false;
            }
        }
        System.out.println(numberToCheck);
        return true;
    }

    // Method to iterate the loop from l to r
    // If prime number detects, sum the value
    static int primeSum(int l, int r) {
        int sum = 0;
        for (int i = r; i >= l; i--) {
            // Check for prime
            boolean isPrime = checkPrime(i);
            if (isPrime) {
                // Sum the prime number
                sum = sum + i;
            }
        }
        return sum;
    }

    public static boolean isPrime(int number) {
        if (number <= 1) return false; // 1 is not prime and also not composite
        return !IntStream.rangeClosed(2, number / 2).anyMatch(i -> number % i == 0);
    }
}
