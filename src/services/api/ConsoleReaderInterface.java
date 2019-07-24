package services.api;

import java.io.IOException;

public interface ConsoleReaderInterface {
    String binarySelection(String optionA, String optionB, String message) throws IOException;

    long readPositiveLong() throws IOException;

    short readOneDigit() throws IOException;

    double readDouble() throws IOException;
}
