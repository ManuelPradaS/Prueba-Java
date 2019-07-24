package services;

public class NumberInspector {

    public boolean isPrime(long number) {
        if (number == 2 | number == 3) return true;
        if (number % 2 == 0 || number % 3 == 0) return false;
        if (number < 2) return false;
        long sqrtNumber = (long) Math.sqrt(number) + 1;

        for (long i = 6L; i <= sqrtNumber; i += 6) {
            if (number % (i - 1) == 0 || number % (i + 1) == 0) return false;
        }
        return true;
    }

}
