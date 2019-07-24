package services.api;

import java.util.TreeSet;

public interface ResponseMakerInterface {
    String makeStringFromSet(TreeSet set, String ordering);

    String makeIsPalindromeMessage(boolean isPalindrome);
}
