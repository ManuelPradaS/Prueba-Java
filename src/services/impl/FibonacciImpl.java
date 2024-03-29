package services.impl;

import java.util.ArrayList;
import java.util.List;

public class FibonacciImpl implements services.api.FibonacciInterface {

    private List<Integer> fibonacciSequence = new ArrayList<>();

    @Override
    public List<Integer> getFibonacciSequence() {
        return fibonacciSequence;
    }

    public FibonacciImpl() {
    }

    @Override
    public int nFibonacciNumber(int digit) {
        return fibonacciNumber(digit + 1, 0, 1);
    }

    private int fibonacciNumber(int number, int accumulator, int secondAccumulator) {
        if (number == 0) {
            return accumulator;
        }
        if (number == 1) {
            return secondAccumulator;
        }
        fibonacciSequence.add(secondAccumulator);
        return fibonacciNumber(number - 1, secondAccumulator, accumulator + secondAccumulator);
    }
}
