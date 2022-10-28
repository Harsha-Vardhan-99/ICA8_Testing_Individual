package org.example;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class Urinals {
    public static void main(String[] args) throws FileNotFoundException {
        try {
            int inputChoice;
            Scanner scn = new Scanner(System.in);
            System.out.println("Press 1 to enter input string through keyboard or 2 to read input from file");
            inputChoice = scn.nextInt();
            if (inputChoice == 1) {
                Scanner scn2 = new Scanner(System.in);
                System.out.println("Enter your strings:");
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
                String[] fileNames = new String[100];
                for(int i=0;i<100;i++){
                    if(i==0){
                        fileNames[0] = "rule.txt";
                    }
                    else{
                        fileNames[i] = "rule"+ i +".txt";
                    }
                }
                File inputFile = new File("src/main/java/org/example/urinal.dat");
                FileReader inputDetails = new FileReader(inputFile);
                BufferedReader inputBuffer = new BufferedReader(inputDetails);
                String currentLine;
                boolean flag = false;
                String path  = "src/main/java/org/example/";
                for(int i=0;i<100;i++){
                    File f = new File(path+fileNames[i]);
                    if(f.exists() && !f.isDirectory()) {
                        continue;
                    }
                    else{
                        path = path + fileNames[i];
                        break;
                    }
                }
                File myObj = new File(path);
                myObj.createNewFile();
                while((currentLine = inputBuffer.readLine())!=null){
                    String output = "";
                    if(isValidString(currentLine)){
                        output = String.valueOf(getUrinals(currentLine));
                        Files.write(Paths.get(path), (output + "\n").getBytes(), StandardOpenOption.APPEND);
                    }
                    else{
                        output = "-1";
                        Files.write(Paths.get(path), (output + "\n").getBytes(), StandardOpenOption.APPEND);
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