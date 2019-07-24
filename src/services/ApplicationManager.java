package services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.TreeSet;

public class ApplicationManager {

    private static final String selectionLettersOrNumbersMessage = "Si desea ingresar letras introduzca: L, para numeros introduzca N";
    private static final String selectionOrderingMessage = "Si desea ordenamiento ascendente introduzca: A, para ordenamiento descendente introduzca: D";

    private BufferedReader bufferReader;
    private ConsoleReader consoleReader;
    private ResponseMaker responseMaker;
    private WordsInspector wordsInspector;
    private NumberInspector numberInspector;
    private Fibonacci fibonacci;

    public ApplicationManager() {
        this.bufferReader = new BufferedReader(new InputStreamReader(System.in));
        this.consoleReader = new ConsoleReader(bufferReader);
        this.responseMaker = new ResponseMaker();
        this.wordsInspector = new WordsInspector();
        this.numberInspector = new NumberInspector();
        this.fibonacci = new Fibonacci();
    }

    public void run() throws IOException {


        System.out.println("Bienvenido");
        String selection = consoleReader.binarySelection("N", "L", selectionLettersOrNumbersMessage);
        if (selection.equals("N")) {
            System.out.println("Se calculara la serie fibonnaci para el digito que ingrese:");
            short digit = consoleReader.readOneDigit();
            fibonacci.nFibonacciNumber(digit);
            System.out.println("La serie de fibonnacci de " + digit + " elemento(s) es:");
            System.out.println(fibonacci.getFibonacciSequence());
            System.out.println("Ahora se encontrarán los números repetidos y números primos, de una secuencia que ingrese.");
            long iterations = consoleReader.readPositiveLong();
            ArrayList<Double> insertedNumbers = new ArrayList<>();
            TreeSet<Double> allNumbersSet = new TreeSet<>();
            TreeSet<Double> repeatedNumbersSet = new TreeSet<>();
            TreeSet<Long> primeNumbersSet = new TreeSet<>();

            for (long index = 1; index <= iterations; index++) {

                double current = consoleReader.readDouble();
                if (allNumbersSet.contains(current)) {
                    repeatedNumbersSet.add(current);
                } else {
                    allNumbersSet.add(current);
                    if (current % 1 == 0) {
                        long currentNumber = (long) current;
                        if (numberInspector.isPrime(currentNumber)) primeNumbersSet.add(currentNumber);
                    }
                }
                insertedNumbers.add(current);
            }
            System.out.println("Se ingresaron " + insertedNumbers.size() + " números");
            String allNumbersOrdering = consoleReader.binarySelection("A", "D", selectionOrderingMessage);
            System.out.println(responseMaker.makeStringFromSet(allNumbersSet, allNumbersOrdering));

            System.out.println("De los números ingresados " + repeatedNumbersSet.size() + " estan repetidos");
            if (repeatedNumbersSet.size() > 0) {
                String repeatedNumbersOrdering = consoleReader.binarySelection("A", "D", selectionOrderingMessage);
                System.out.println(responseMaker.makeStringFromSet(repeatedNumbersSet, repeatedNumbersOrdering));
            }

            System.out.println("Se identificarón " + primeNumbersSet.size() + " números primos");
            if (primeNumbersSet.size() > 0) {
                String primeNumbersOrdering = consoleReader.binarySelection("A", "D", selectionOrderingMessage);
                System.out.println(responseMaker.makeStringFromSet(primeNumbersSet, primeNumbersOrdering));
            }


        } else {
            System.out.println("Ingrese una palabra:");
            String word = bufferReader.readLine();
            System.out.println(responseMaker.makeIsPalindromeMessage(wordsInspector.isPalindrome(word)));
        }


    }
}
