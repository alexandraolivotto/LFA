package decoder;

import errorhandler.ErrorHandler;
import utils.Utils;
import validator.InstructionValidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;

public class GlyphoDecoder {
    private final int instrLength = 4;

    public String removeOtherChars(String toDecode) {
        String newToDecode = new String();

        for(int i = 0; i < toDecode.length(); i++) {
            int ascii = (char) toDecode.charAt(i);
            if(ascii >= 33 && ascii <= 126 ) {
                newToDecode += toDecode.charAt(i);
            }
        }
        return newToDecode;
    }

    public String keepNumbersOnly(String toDecode) {
        String newToDecode = new String();

        for(int i = 0; i < toDecode.length(); i++) {
            int ascii = (char) toDecode.charAt(i);
            if(ascii >= 48 && ascii <= 57 ) {
                newToDecode += toDecode.charAt(i);
            }
        }
        return newToDecode;
    }

    public String removeDuplicates(String toDecode) {
        String noDup = new String();

        char[] toChars = toDecode.toCharArray();
        LinkedHashSet<Character> set = new LinkedHashSet<Character>();

        for (char c : toChars) {
            set.add(c);
        }

        for (Character c : set) {
            noDup += c;
        }

        return noDup;
    }

    public HashMap<Character, Integer> mapCharsToValues(String str) {
        HashMap<Character, Integer> assoc = new HashMap<Character, Integer>();
        int counter = 0;
        char[] toChars = str.toCharArray();

        for (char c : toChars) {
            assoc.put(c, counter);
            counter++;
        }

        return assoc;
    }

    public ArrayList<String> split(String toDecode) {
        ArrayList<String> listOfInstr = new ArrayList<String>();
        String temp = new String();

        for (int i = 0; i < toDecode.length(); i++) {
            temp += toDecode.charAt(i);
            if (temp.length() == 4) {
                listOfInstr.add(temp);
                temp = new String();
            }
        }
        return listOfInstr;
    }

    public ArrayList<String> decode(String toDecode){
        toDecode = removeOtherChars(toDecode);
        InstructionValidator validator = new InstructionValidator();
        if (!validator.isInstructionStringValid(toDecode)) {
            Utils.errorCounter = toDecode.length() / Utils.instrLen;
            ErrorHandler.handleError();
        }
        ArrayList<String> instructions = split(toDecode);
        ArrayList<ArrayList<Integer>> finalArr = new ArrayList<ArrayList<Integer>>();
        ArrayList<String> returnInstr = new ArrayList<String>();
        for (String i : instructions) {
            ArrayList<Integer> decodedInstr = new ArrayList<Integer>();
            int j = 0;
            String noDup = removeDuplicates(i);
            HashMap<Character, Integer> map = mapCharsToValues(noDup);
            char[] toChars = i.toCharArray();

            for(char c : toChars) {
                int num = map.get(c);
                decodedInstr.add(num);
            }
            finalArr.add(decodedInstr);
        }

        for (ArrayList<Integer> list: finalArr
        ) {
            returnInstr.add( keepNumbersOnly(list.toString()));
        }

        return  returnInstr;
    }
}
