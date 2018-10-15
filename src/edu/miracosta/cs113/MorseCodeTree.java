package edu.miracosta.cs113;
/**
 * MorseCodeTree.java : Morse code is a common code that is used to encode messages consisting of letters and digits (this project only handles letters).
 * Each letter consists of a series of dots (using asterisks for ease of us here) and dashes;
 * for example, the code for the letter a is *- and the code for the letter b is -***
 * This MorseCodeTree stores each letter of the alphabet in a node of a binary tree of height 5. The root node is at level 1 and stores no letter.
 * To build the tree described above, it reads a text file in which each line consists of a letter followed by its code (i.e., b -***)
 * and add the node appropriately to the tree    using the morse code. The letters should be ordered by tree level, from left-to-right
 *
 * @author Danny Lee
 * @version 1.0
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class MorseCodeTree extends BinaryTree {

    File file = new File("doc/letters.txt");
    Scanner scan = null;
    BinaryTree<String> morseCodeTree = null;

    /**
     * This method creates a MorseCodeTree using the Node and BinaryTree class that the class extended.
     * @return BinaryTree that implements a MorseCodeTree
     */
    public BinaryTree<String> buildMorseCodeTree(){
        Node<String> rootNode = new Node<>("temp root data");
        morseCodeTree = new BinaryTree<String>(rootNode);
        String nextCode = "";
        String alphabetLetter = "";
        String morseCode = "";
        Node<String> nodeToAdd = null;
        Node<String> currentNode = null;

        try{
            scan = new Scanner(file);
        }catch(FileNotFoundException e){
            e.printStackTrace();
            System.exit(0);
        }

        while(scan.hasNextLine()){
            currentNode = morseCodeTree.root;
            nextCode = scan.nextLine();
            alphabetLetter = Character.toString(nextCode.charAt(0));
            morseCode = nextCode.substring(2);

            for(int i = 0; i < morseCode.length(); i++){

                if(i == morseCode.length() - 1){
                    nodeToAdd = new Node<>(alphabetLetter);
                    if(morseCode.charAt(i) == '*'){
                        currentNode.left = nodeToAdd;
                    }else if(morseCode.charAt(i) == '-'){
                        currentNode.right = nodeToAdd;
                    }
                }else{
                    if(morseCode.charAt(i) == '*'){
                        currentNode = currentNode.left;
                    }else if(morseCode.charAt(i) == '-'){
                        currentNode = currentNode.right;
                    }
                }
            }//end of for loop

        }
        return morseCodeTree;
    }

    /**
     * When given a specific morse code, it decodes and returns the matching alphabet character.
     * If it is not an alphabet letter, then it throws an IllegalArgumentException.
     * @param givenMorseCode the morse code to decode.
     * @return the decoded morse code. (alphabet character).
     */
    public String readMorseCodeTree(String givenMorseCode){
        Node<String> target = morseCodeTree.root;
        for(int i = 0; i < givenMorseCode.length(); i++){
            if(givenMorseCode.charAt(i) == '*'){
                if(target.left == null){
                    throw new IllegalArgumentException(givenMorseCode + " is invalid! It's non alphabet character.");
                }else{
                    target = target.left;
                }
            }else if(givenMorseCode.charAt(i) == '-'){
                if(target.right == null){
                    throw new IllegalArgumentException(givenMorseCode + " is invalid! It's non alphabet character.");
                }else{
                    target = target.right;
                }
            }
        }
        return target.data;
    }


}