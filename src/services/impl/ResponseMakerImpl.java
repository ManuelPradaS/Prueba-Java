package services.impl;

import java.util.TreeSet;

public class ResponseMakerImpl implements services.api.ResponseMakerInterface {

    @Override
    public String makeStringFromSet(TreeSet set, String ordering) {
        String response;
        if (ordering.equals("A")) {
            response = set.toString();
        } else {
            response = set.descendingSet().toString();
        }
        return response;
    }
    @Override
    public String makeIsPalindromeMessage(boolean isPalindrome){
        if (isPalindrome){return "La palabra ingresada es palíndroma";}
        else {return "La palabra ingresada no es palíndroma"; }
    }
}
