package services.impl;

import services.api.ConsoleReaderInterface;

import java.io.BufferedReader;
import java.io.IOException;

public class ConsoleReaderImpl implements ConsoleReaderInterface {

    private BufferedReader reader;

    public ConsoleReaderImpl(BufferedReader reader) {
        this.reader = reader;
    }

    @Override
    public String binarySelection(String optionA, String optionB, String message) throws IOException {
        System.out.println(message);
        String selection = reader.readLine();
        while (!(selection.equals(optionA) || selection.equals(optionB))) {
            System.out.println("Selección invalida");
            System.out.println(message);
            selection = reader.readLine();
        }
        return selection;
    }

    @Override
    public long readPositiveLong() throws IOException {
        System.out.println("Diga cual es la cantidad de números a ingresar:");
        long number = -1;
        while (number < 1) {
            try {
                System.out.println("Ingrese n>0:");
                number = Long.parseLong(reader.readLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada invalida");
            }
        }
        return number;
    }

    @Override
    public short readOneDigit() throws IOException {
        short number = -1;
        while (number < 1 || number > 9) {
            try {
                System.out.println("Ingrese un digito:");
                number = Short.parseShort(reader.readLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada invalida");
            }
        }
        return number;
    }

    @Override
    public double readDouble() throws IOException {
        boolean correctInput = false;
        double number = 0;
        do {
            try {
                System.out.println("Ingrese un número:");
                number = Double.parseDouble(reader.readLine());
                correctInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Entrada invalida");
            }
        } while (!correctInput);

        return number;
    }


}
