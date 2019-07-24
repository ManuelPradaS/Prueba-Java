package services;

public class WordsInspector {

    public boolean isPalindrome(String word) {
        String lowerCaseWord = word.toLowerCase();
        StringBuilder stringBuilder = new StringBuilder(lowerCaseWord);
        stringBuilder.reverse();
        String reverseWord = stringBuilder.toString();
        return lowerCaseWord.equals(reverseWord);
    }

}
