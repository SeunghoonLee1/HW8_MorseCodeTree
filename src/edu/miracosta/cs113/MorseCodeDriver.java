package edu.miracosta.cs113;

/**
 * MorseCodeDriver.java : This is a driver menu program that builds the MorseCodeTree and asks the user if they want to
 * 1) test output for all morse code letters with their respective translated alphabet letters.
 * 2) enter an input textfile name with morse code to decode and output the translated text to the console.
 * 3) enter in a line of morse code through the console to decode morse code and output the translated text to the console.
 *
 * @author Danny Lee
 * @version 1.0
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MorseCodeDriver {
    /*
     *Algorithm
     *Create a Scanner object that will get user's menu input.
     *While the user does not types 4(exit button)
     *  Display 4 menu options and get user input.
     *  If the user types 1, Display the test output for all morse code letters with their respective translated alphabet letters.
     *  If the user types 2, get input of the text file address to decode.
     *  If the user types 3, ask user for the morse code input to decode.
     *  If the user types 4, exit the program.
     */
    public static void main(String[] args){

        MorseCodeTree treeBuilt = new MorseCodeTree();
        Scanner keyboard = new Scanner(System.in);
        Scanner scan = null;
        treeBuilt.buildMorseCodeTree();
        int menuInput = 0;
        String fileName = "";
        String nextLetter = "";
        String userInput = "";
        String[] splited = null;

        while(menuInput != 4){
            System.out.println("Menu options.");
            System.out.println("1) Test output for all morse code letters with their respective translated alphabet letters");
            System.out.println("2) Enter an input textfile name with morse code to decode and output the translated text to the console,");
            System.out.println("3) Enter in a line of morse code through the console to decode morse code and output the translated text to the console.");
            System.out.println("4) Exit program.");
            menuInput = keyboard.nextInt();
            if(menuInput == 1){
                System.out.println("*- : " + treeBuilt.readMorseCodeTree("*-"));
                System.out.println("-*** : " + treeBuilt.readMorseCodeTree("-***"));
                System.out.println("-*-* : " + treeBuilt.readMorseCodeTree("-*-*"));
                System.out.println("-** : " + treeBuilt.readMorseCodeTree("-**"));
                System.out.println("* : " + treeBuilt.readMorseCodeTree("*"));
                System.out.println("**-* : " + treeBuilt.readMorseCodeTree("**-*"));
                System.out.println("--* : " + treeBuilt.readMorseCodeTree("--*"));
                System.out.println("**** : " + treeBuilt.readMorseCodeTree("****"));
                System.out.println("** : " + treeBuilt.readMorseCodeTree("**"));
                System.out.println("*--- : " + treeBuilt.readMorseCodeTree("*---"));
                System.out.println("-*- : " + treeBuilt.readMorseCodeTree("-*-"));
                System.out.println("*-** : " + treeBuilt.readMorseCodeTree("*-**"));
                System.out.println("-- : " + treeBuilt.readMorseCodeTree("--"));
                System.out.println("-* : " + treeBuilt.readMorseCodeTree("-*"));
                System.out.println("--- : " + treeBuilt.readMorseCodeTree("---"));
                System.out.println("*--* : " + treeBuilt.readMorseCodeTree("*--*"));
                System.out.println("--*- : " + treeBuilt.readMorseCodeTree("--*-"));
                System.out.println("*-* : " + treeBuilt.readMorseCodeTree("*-*"));
                System.out.println("*** : " + treeBuilt.readMorseCodeTree("***"));
                System.out.println("- : " + treeBuilt.readMorseCodeTree("-"));
                System.out.println("**- : " + treeBuilt.readMorseCodeTree("**-"));
                System.out.println("***- : " + treeBuilt.readMorseCodeTree("***-"));
                System.out.println("*-- : " + treeBuilt.readMorseCodeTree("*--"));
                System.out.println("-**- : " + treeBuilt.readMorseCodeTree("-**-"));
                System.out.println("-*-- : " + treeBuilt.readMorseCodeTree("-*--"));
                System.out.println("--** : " + treeBuilt.readMorseCodeTree("--**"));

            }else if(menuInput == 2){
                StringBuilder output = new StringBuilder();
                keyboard.nextLine();
                System.out.println("Enter an input textfile directory with name with morse code to decode. (i.e :doc/fileName.txt) ");
                fileName = keyboard.nextLine();
                System.out.println("file name : " + fileName);
                File fileToDecode = new File(fileName);

                try{
                    //scan = new Scanner(new FileInputStream(fileToDecode));
                    scan = new Scanner(fileToDecode);
                }catch(FileNotFoundException e){
                    e.printStackTrace();
                    System.exit(0);
                }

                while(scan.hasNext()){
                    nextLetter = scan.next();
                    System.out.println("next morse code : " + nextLetter);
                    output.append(treeBuilt.readMorseCodeTree(nextLetter));
                }

                System.out.println("Decoded result : " + output.toString());
            }else if(menuInput == 3){
                StringBuilder output = new StringBuilder();
                keyboard.nextLine();
                System.out.println("Please type a line of morse code. (Put a space between each morse code!)");
                userInput = keyboard.nextLine();
                splited = userInput.split("\\s");

                for(String nextMorseCode : splited){
                    output.append(treeBuilt.readMorseCodeTree(nextMorseCode));
                }

                System.out.println("Decoded result : " + output.toString());


            }else if(menuInput == 4){
                System.out.println("Exit program.");
                System.exit(0);
            }
        }

    }


}