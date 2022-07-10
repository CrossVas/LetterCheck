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
        ArrayList<String> duplications = new ArrayList<>();
        ArrayList<String> whitelistedFound = new ArrayList<>();
        boolean dupFound = false;
        out.println("Insert a sentence for analysis");
        input = sc.nextLine();
        String[] words = input.split("\\s");
        for (String s : words) {
            char[] inputChars = s.toCharArray();
            for (int i = 0; i < inputChars.length - 1; i++) {
                if (inputChars[i] == inputChars[i + 1] && inputChars[i] != ' ') {
                    duplications.add(s);
                    dupFound = true;
                    break;
                }
            }
            if (whiteList.contains(s.toLowerCase())) {
                whitelistedFound.add(s);
                break;
            }
        }

        String whitelisted_string = whitelistedFound.size() > 0 ? whitelistedFound.toString() : "none";

        if (dupFound) {
            out.println(duplications + " were found with double letters while " + whitelisted_string + " are whitelisted!");
        } else {
            out.println("No duplications found!");
        }
    }
}
