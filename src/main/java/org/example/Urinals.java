package org.example;
import java.util.*;

public class Urinals {
    public static void main(String[] args) {
        System.out.println("Enter your strings:");
        Scanner scn = new Scanner(System.in);
        while(scn.hasNext()){
            String inputString = scn.nextLine();
            if(!inputString.equals("-1")) {
                if (isValidString(inputString)) {
                    System.out.println(getUrinals(inputString));
                } else {
                    System.out.println("-1");
                }
            }
            else System.exit(2);
            }
        }

    public static boolean isValidString(String inputString) {
        if(inputString.contains("11")){
            return false;
        }
        return true;
    }

    public static int getUrinals(String inputString) {
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
        }
        return urinalCount;
    }
}