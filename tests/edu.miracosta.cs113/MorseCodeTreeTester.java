package edu.miraocsta.cs113;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class MorseCodeTreeTester {

    private MorseCodeTree morseCodeTree;


    @Before
    public void setup(){
        morseCodeTree = new MorseCodeTree();
        morseCodeTree.buildMorseCodeTree();
    }

    /**
     * To Do!
     */

    // Make sure to provide adequate error testing.*************************************************
    // For example, how do your MorseCodeTree methods deal with errors like non-alphabetical characters?
    // -> when given a morse code but it is not in the morseCodeTree, then, throw an exception!(maybe)

    @Test
    public void testLetters(){
        assertEquals("a", morseCodeTree.readMorseCodeTree("*-"));
        assertEquals("b", morseCodeTree.readMorseCodeTree("-***"));
        assertEquals("c", morseCodeTree.readMorseCodeTree("-*-*"));
        assertEquals("d", morseCodeTree.readMorseCodeTree("-**"));
        assertEquals("e", morseCodeTree.readMorseCodeTree("*"));
        assertEquals("f", morseCodeTree.readMorseCodeTree("**-*"));
        assertEquals("g", morseCodeTree.readMorseCodeTree("--*"));
        assertEquals("h", morseCodeTree.readMorseCodeTree("****"));
        assertEquals("i", morseCodeTree.readMorseCodeTree("**"));
        assertEquals("j", morseCodeTree.readMorseCodeTree("*---"));
        assertEquals("k", morseCodeTree.readMorseCodeTree("-*-"));
        assertEquals("l", morseCodeTree.readMorseCodeTree("*-**"));
        assertEquals("m", morseCodeTree.readMorseCodeTree("--"));
        assertEquals("n", morseCodeTree.readMorseCodeTree("-*"));
        assertEquals("o", morseCodeTree.readMorseCodeTree("---"));
        assertEquals("p", morseCodeTree.readMorseCodeTree("*--*"));
        assertEquals("q", morseCodeTree.readMorseCodeTree("--*-"));
        assertEquals("r", morseCodeTree.readMorseCodeTree("*-*"));
        assertEquals("s", morseCodeTree.readMorseCodeTree("***"));
        assertEquals("t", morseCodeTree.readMorseCodeTree("-"));
        assertEquals("u", morseCodeTree.readMorseCodeTree("**-"));
        assertEquals("v", morseCodeTree.readMorseCodeTree("***-"));
        assertEquals("w", morseCodeTree.readMorseCodeTree("*--"));
        assertEquals("x", morseCodeTree.readMorseCodeTree("-**-"));
        assertEquals("y", morseCodeTree.readMorseCodeTree("-*--"));
        assertEquals("z", morseCodeTree.readMorseCodeTree("--**"));


    }

    @Test
    public void testWords(){
        String wordToTest = "danny";
        StringBuilder translatedWord = new StringBuilder();
        translatedWord.append(morseCodeTree.readMorseCodeTree("-**"));
        translatedWord.append(morseCodeTree.readMorseCodeTree("*-"));
        translatedWord.append(morseCodeTree.readMorseCodeTree("-*"));
        translatedWord.append(morseCodeTree.readMorseCodeTree("-*"));
        translatedWord.append(morseCodeTree.readMorseCodeTree("-*--"));

        assertEquals(wordToTest,translatedWord.toString());

    }

}
