package io.lettercheck;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static PrintStream out = System.out;
    public static InputStream in = System.in;
    public static Scanner sc = new Scanner(in);
    public static String input;
    public static Scanner scan;
    public static ArrayList<String> whiteList = new ArrayList<>();

    static {
        try {
            scan = new Scanner(new FileReader("/media/crossvas/Data/Dev/Java/10 Steps/LetterCheck/src/io/lettercheck/index.txt"));
        } catch (FileNotFoundException e) {
            out.println("File not found!");
        }
        while (scan.hasNext())
            whiteList.add(scan.next());
    }

    public static void main(String[] args) {
        ArrayList<String> whitelistedFound = new ArrayList<>();
        int dup_index = 0;
        String status = "";
        boolean dup = false;
        out.println("Insert a sentence for analysis");
        input = sc.nextLine();
        String[] words = input.split("\\s");
        for (String s : words) {
            status = "Correct!";
            char[] inputChars = s.toCharArray();
            for (int i = 0; i < inputChars.length - 1; i++) {
                if (!whiteList.contains(s.toLowerCase())) {
                    if (inputChars[i] == inputChars[i + 1] && inputChars[i] != ' ') {
                        dup = true;
                        status = "Duplicate!";
                        dup_index++;
                        break;
                    }
                }
                if (whiteList.contains(s.toLowerCase())) {
                    whitelistedFound.add(s);
                    status = "Whitelisted - Correct!";
                    break;
                }
            }
            out.println(s + " : " + status);
        }
        if (dup) {
            out.println("Wrong double letter found in " + dup_index + " words!");
        }
        out.println("Whitelisted words found: " + whitelistedFound);
    }
}
