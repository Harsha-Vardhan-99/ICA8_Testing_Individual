package org.example;
import java.io.*;
import java.util.*;

public class Urinals {
    public static void main(String[] args) throws FileNotFoundException {
        try {
            int inputChoice;
            Scanner scn = new Scanner(System.in);
            System.out.println("Press 1 to enter input string through keyboard or 2 to read input from file");
            inputChoice = scn.nextInt();
            System.out.println("Enter your strings:");
            if (inputChoice == 1) {
                Scanner scn2 = new Scanner(System.in);
                while (scn2.hasNext()) {
                    String inputString = scn2.nextLine();
                    if (!inputString.equals("-1")) {
                        if (isValidString(inputString)) {
                            System.out.println(getUrinals(inputString));
                        } else {
                            System.out.println("-1");
                        }
                    } else System.exit(2);
                }
            } else if (inputChoice == 2) {
                File inputFile = new File("src/main/java/org/example/urinal.dat");
                FileReader inputDetails = new FileReader(inputFile);
                BufferedReader inputBuffer = new BufferedReader(inputDetails);
                String currentLine;
                boolean flag = false;
                while((currentLine = inputBuffer.readLine())!=null){
                    if(isValidString(currentLine)){
                        System.out.println(getUrinals(currentLine));
                    }
                    else{
                        System.out.println("-1");
                    }
                };
            }
        }
		    catch(Exception e) {
                e.printStackTrace();
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