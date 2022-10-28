package org.example;
import java.util.*;

public class Urinals {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String inputString = scn.nextLine();
        while(!inputString.equals("-1")){
            if(isValidString(inputString)){
                getUrinals(inputString);
            }
            else{
                System.out.println("Invalid String");
            }
        }
    }

    private static boolean isValidString(String inputString) {
        if(inputString.contains("11")){
            return false;
        }
        return true;
    }

    private static void getUrinals(String inputString) {
        char[] inputCharArr;
        inputCharArr = inputString.toCharArray();
        int urinalCount = 0;
        for (int i = 0; i < inputCharArr.length; i++) {
            if (i == 0 && inputCharArr[i] == '0' && inputCharArr[i + 1] == '0') {
                inputCharArr[i] = '1';
                urinalCount++;
            } else if (i == inputCharArr.length - 1 && inputCharArr[i] == '0' && inputCharArr[i - 1] == '0') {
                inputCharArr[i] = '1';
                urinalCount++;
            } else if (inputCharArr[i] == '0' && inputCharArr[i - 1] == '0' && inputCharArr[i + 1] == '0') {
                inputCharArr[i] = '1';
                urinalCount++;
            }

            System.out.println(urinalCount);
        }
    }
}