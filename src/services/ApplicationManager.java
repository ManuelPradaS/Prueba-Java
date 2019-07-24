package services;

import services.api.*;
import services.impl.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.TreeSet;

public class ApplicationManager {

    private static final String selectionLettersOrNumbersMessage = "Si desea ingresar letras introduzca: L, para numeros introduzca N";
    private static final String selectionOrderingMessage = "Si desea ordenamiento ascendente introduzca: A, para ordenamiento descendente introduzca: D";

    private BufferedReader bufferReader;
    private ConsoleReaderInterface consoleReaderImpl;
    private ResponseMakerInterface responseMakerImpl;
    private WordsInspectorInterface wordsInspectorImpl;
    private NumberInspectorInterface numberInspectorImpl;
    private FibonacciInterface fibonacciImpl;

    private ArrayList<Double> insertedNumbers = new ArrayList<>();
    private TreeSet<Double> allNumbersSet = new TreeSet<>();
    private TreeSet<Double> repeatedNumbersSet = new TreeSet<>();
    private TreeSet<Long> primeNumbersSet = new TreeSet<>();


    public ApplicationManager() {
        this.bufferReader = new BufferedReader(new InputStreamReader(System.in));
        this.consoleReaderImpl = new ConsoleReaderImpl(bufferReader);
        this.responseMakerImpl = new ResponseMakerImpl();
        this.wordsInspectorImpl = new WordsInspectorImpl();
        this.numberInspectorImpl = new NumberInspectorImpl();
        this.fibonacciImpl = new FibonacciImpl();
    }

    private void getNumberFromUser() throws IOException {
        System.out.println("Ahora se encontrarán los números repetidos y números primos, de una secuencia que ingrese.");
        long iterations = consoleReaderImpl.readPositiveLong();
        for (long index = 1; index <= iterations; index++) {

            double current = consoleReaderImpl.readDouble();
            if (allNumbersSet.contains(current)) {
                repeatedNumbersSet.add(current);
            } else {
                allNumbersSet.add(current);
                if (current % 1 == 0) {
                    long currentNumber = (long) current;
                    if (numberInspectorImpl.isPrime(currentNumber)) primeNumbersSet.add(currentNumber);
                }
            }
            insertedNumbers.add(current);
        }

    }

    private void makeFibonacciSecuence() throws IOException {
        System.out.println("Se calculara la serie fibonnaci para el digito que ingrese:");
        short digit = consoleReaderImpl.readOneDigit();
        fibonacciImpl.nFibonacciNumber(digit);
        System.out.println("La serie de fibonnacci de " + digit + " elemento(s) es:");
        System.out.println(fibonacciImpl.getFibonacciSequence());
    }

    private void makeAllNumberResponse() throws IOException {
        System.out.println("Se ingresaron " + insertedNumbers.size() + " números");
        String allNumbersOrdering = consoleReaderImpl.binarySelection("A", "D", selectionOrderingMessage);
        System.out.println(responseMakerImpl.makeStringFromSet(allNumbersSet, allNumbersOrdering));

    }

    private void makeRepeatedNumberResponse() throws IOException {
        System.out.println("De los números ingresados " + repeatedNumbersSet.size() + " estan repetidos");
        if (repeatedNumbersSet.size() > 0) {
            String repeatedNumbersOrdering = consoleReaderImpl.binarySelection("A", "D", selectionOrderingMessage);
            System.out.println(responseMakerImpl.makeStringFromSet(repeatedNumbersSet, repeatedNumbersOrdering));
        }
    }

    private void makePrimeNumberResponse() throws IOException {
        System.out.println("Se identificarón " + primeNumbersSet.size() + " números primos");
        if (primeNumbersSet.size() > 0) {
            String primeNumbersOrdering = consoleReaderImpl.binarySelection("A", "D", selectionOrderingMessage);
            System.out.println(responseMakerImpl.makeStringFromSet(primeNumbersSet, primeNumbersOrdering));
        }

    }

    private void checkLetters() throws IOException {
        System.out.println("Ingrese una palabra:");
        String word = bufferReader.readLine();
        System.out.println(responseMakerImpl.makeIsPalindromeMessage(wordsInspectorImpl.isPalindrome(word)));

    }

    public void run() throws IOException {

        System.out.println("Bienvenido");
        String selection = consoleReaderImpl.binarySelection("N", "L", selectionLettersOrNumbersMessage);
        if (selection.equals("N")) {
            makeFibonacciSecuence();
            getNumberFromUser();
            makeAllNumberResponse();
            makeRepeatedNumberResponse();
            makePrimeNumberResponse();

        } else {
            checkLetters();
        }


    }
}
