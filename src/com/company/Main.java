package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    private static ArrayList<Integer> mainArray = new ArrayList<>(Arrays.asList(1,5,6,4,7,8515,15,65,69,4,78,52,12,364,
            71,235,25,1,4,75,63,27,98,12,256,14,97,3,13,54,79,2,19,345,67,123,63,48,9521,325,127,369,145,23,21));

    private static ArrayList<Integer> array_X = new ArrayList<>();
    private static  ArrayList<Integer> array_S = new ArrayList<>();
    private static ArrayList<Integer> array_M = new ArrayList<>();

    private static ArrayList<Integer> mergedArray = new ArrayList<>();

    private static boolean anyMore;

    public static void main(String[] args) {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line = "";

        while (!line.equalsIgnoreCase("quit")) {
            try {
                line = in.readLine();

                switch (line) {
                    case ("init array"):
                        initArrays();
                        break;

                    case ("print"):
                        print();
                        break;

                    case ("print X"):
                        printType("X");
                        break;

                    case ("print S"):
                        printType("S");
                        break;

                    case ("print M"):
                        printType("M");
                        break;

                    case ("anyMore"):
                        System.out.println(anyMore);
                        break;

                    case ("clear X"):
                        clearType("X");
                        break;

                    case ("clear S"):
                        clearType("S");
                        break;

                    case ("clear M"):
                        clearType("M");
                        break;

                    case ("merge"):
                        merge();
                        break;

                    case ("help"):
                        printHelpCommand();
                        break;

                    default:
                        System.out.println("Неверно введеная команда - используйте \"help\" для вызова помощи по командам");
                        break;
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void printHelpCommand() {
        System.out.println("\"init array\" to init arrays \n" +
                "\"print\" to print all arrays \n" +
                "\"print X\" to print array X \n" +
                "\"print S\" to print array S \n" +
                "\"print M\" to print array M \n" +
                "\"anyMore\" to print values not included to any array \n" +
                "\"clear X\" to clear array X \n" +
                "\"clear S\" to clear array S \n" +
                "\"clear M\" to clear array M \n" +
                "\"merge\" to merge all arrays in one");
    }

    private static void merge() {
        mergedArray.addAll(array_X);
        mergedArray.addAll(array_M);
        mergedArray.addAll(array_S);
        Collections.sort(mergedArray);
        array_M.clear();
        array_S.clear();
        array_X.clear();
        System.out.println("Merged array: " + mergedArray);
    }

    private static void clearType(String type) {
        if (type.equals("X")) {
            array_X.clear();
            System.out.println("Array X has been cleaned");
        } else if (type.equals("S")) {
            array_S.clear();
            System.out.println("Array S has been cleaned");
        } else if (type.equals("M")) {
            array_M.clear();
            System.out.println("Array M has been cleaned");
        }
    }

    private static void printType(String type) {
        switch (type) {
            case "X":
                if (array_X.isEmpty()) {
                    System.out.println("Array X is empty");
                } else {
                    System.out.println("Array X is " + array_X);
                }
                break;
            case "S":
                if (array_S.isEmpty()) {
                    System.out.println("Array S is empty");
                } else {
                    System.out.println("Array S is " + array_S);
                }
                break;
            case "M":
                if (array_M.isEmpty()) {
                    System.out.println("Array M is empty");
                } else {
                    System.out.println("Array M is " + array_M);
                }
                break;
        }

    }

    private static void print() {
        if (array_X.isEmpty()) {
            System.out.println("Array X is empty");
        } else {
            System.out.println("Array X is " + array_X);
        }

        if (array_S.isEmpty()) {
            System.out.println("Array S is empty");
        } else {
            System.out.println("Array S is " + array_S);
        }

        if (array_M.isEmpty()) {
            System.out.println("Array M is empty");
        } else {
            System.out.println("Array M is " + array_M);
        }
    }

    private static void initArrays() {
        for (int tmp : mainArray) {
            if (tmp % 3 == 0) {
                array_X.add(tmp);
            }
            if (tmp % 7 == 0) {
                array_S.add(tmp);
            }
            if (tmp % 21 == 0) {
                array_M.add(tmp);
            }
            if (tmp % 3 != 0 && tmp % 7 != 0) {
                anyMore = true;
            }
        }
        System.out.println("Arrays has been initialized");

        sortArrays();
    }

    private static void sortArrays() {
        Collections.sort(array_X);
        Collections.sort(array_S);
        Collections.sort(array_M);
    }
}
