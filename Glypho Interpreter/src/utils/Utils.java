package utils;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Scanner;

import errorhandler.ExceptionHandler;
import glyphoinstructions.*;

public class Utils {
    public static final int instrLen = 4;
    public static BufferedReader inputReader =
            new BufferedReader(new InputStreamReader(System.in));

    public static Scanner inputScanner = new Scanner(System.in);

    public static int instructionCounter = 0;

    public static int errorCounter = -1;

    public static boolean jumpToRight = false;
    public static boolean jumpToLeft = false;
    public static int jumpIndex = -1;
    public static int dBase = 10;

  //  public static HashMap<BigInteger, Integer> negatives = new HashMap<BigInteger, Integer>();



    public static BigInteger getDecimal(String n, int base){
        BigInteger d = BigInteger.ZERO;
        BigInteger num = BigInteger.ZERO;
        BigInteger bigBase = new BigInteger(String.valueOf(BigInteger.valueOf(base)));
        int p = 0;
        //int negative = 0;

        for(int i = n.length() - 1; i >= 0; i--){
            char ch = n.charAt(i);
            switch(ch){
                case '0':
                    num = new BigInteger("0");
                    break;
                case '1':
                    num = new BigInteger("1");
                    break;
                case '2':
                    num = new BigInteger("2");
                    break;
                case '3':
                    num = new BigInteger("3");
                    break;
                case '4':
                    num = new BigInteger("4");
                    break;
                case '5':
                    num = new BigInteger("5");
                    break;
                case '6':
                    num = new BigInteger("6");
                    break;
                case '7':
                    num = new BigInteger("7");
                    break;
                case '8':
                    num = new BigInteger("8");
                    break;
                case '9':
                    num = new BigInteger("9");
                    break;
                case 'A':
                    num = new BigInteger("10");
                    break;
                case 'B':
                    num = new BigInteger("11");
                    break;
                case 'C':
                    num = new BigInteger("12");
                    break;
                case 'D':
                    num = new BigInteger("13");
                    break;
                case 'E':
                    num = new BigInteger("14");
                    break;
                case 'F':
                    num = new BigInteger("15");
                    break;
                case 'G':
                    num = new BigInteger("16");
                    break;
                case 'H':
                    num = new BigInteger("17");
                    break;
                case 'I':
                    num = new BigInteger("18");
                    break;
                case 'J':
                    num = new BigInteger("19");
                    break;
                case 'K':
                    num = new BigInteger("20");
                    break;
                case 'L':
                    num = new BigInteger("21");
                    break;
                case 'M':
                    num = new BigInteger("22");
                    break;
                case 'N':
                    num = new BigInteger("23");
                    break;
                case 'O':
                    num = new BigInteger("24");
                    break;
                case 'P':
                    num = new BigInteger("25");
                    break;
                case 'Q':
                    num = new BigInteger("26");
                    break;
                case 'R':
                    num = new BigInteger("27");
                    break;
                case 'S':
                    num = new BigInteger("28");
                    break;
                case 'T':
                    num = new BigInteger("29");
                    break;
                case 'U':
                    num = new BigInteger("30");
                    break;
                case 'V':
                    num = new BigInteger("31");
                    break;
                case 'W':
                    num = new BigInteger("32");
                    break;
                case 'X':
                    num = new BigInteger("33");
                    break;
                case 'Y':
                    num = new BigInteger("34");
                    break;
                case 'Z':
                    num = new BigInteger("35");
                    break;
                case '-':
                    num = BigInteger.ZERO;
          //          negative = 1;
                    break;
            }
            BigInteger val = bigBase.pow(p);
            BigInteger toAdd = num.multiply(val);
            d = d.add(toAdd);
            p++;
        }
        //negatives.put(d, negative);
        return d;
    }
    public static ArrayList<Character> decimalToBigBase(int base, BigInteger num){
        ArrayList<Character> str = new ArrayList<Character>();
        BigInteger quot = num;
        int reminder = 0;
        while (!quot.equals(BigInteger.ZERO)) {
            reminder = Integer.parseInt(quot.mod(BigInteger.valueOf(base)).toString()) ;
            quot = quot.divide(BigInteger.valueOf(base));
            if(reminder > 9) {
                switch (reminder){
                    case 10:
                        str.add('A');
                        break;
                    case 11:
                        str.add('B');
                        break;
                    case 12:
                        str.add('C');
                        break;
                    case 13:
                        str.add('D');
                        break;
                    case 14:
                        str.add('E');
                        break;
                    case 15:
                        str.add('F');
                        break;
                    case 16:
                        str.add('G');
                        break;
                    case 17:
                        str.add('H');
                        break;
                    case 18:
                        str.add('I');
                        break;
                    case 19:
                        str.add('J');
                        break;
                    case 20:
                        str.add('K');
                        break;
                    case 21:
                        str.add('L');
                        break;
                    case 22:
                        str.add('M');
                        break;
                    case 23:
                        str.add('N');
                        break;
                    case 24:
                        str.add('O');
                        break;
                    case 25:
                        str.add('P');
                        break;
                    case 26:
                        str.add('Q');
                        break;
                    case 27:
                        str.add('R');
                        break;
                    case 28:
                        str.add('S');
                        break;
                    case 29:
                        str.add('T');
                        break;
                    case 30:
                        str.add('U');
                        break;
                    case 31:
                        str.add('V');
                        break;
                    case 32:
                        str.add('W');
                        break;
                    case 33:
                        str.add('X');
                        break;
                    case 34:
                        str.add('Y');
                        break;
                    case 35:
                        str.add('Z');
                        break;
                }
            } else {
                str.add((char)(reminder + '0'));
            }
        }
        return  str;
    }

    public static BigInteger decimalToBase(int base, BigInteger num) {
        BigInteger ret = BigInteger.ZERO;
        BigInteger quot = num;
        BigInteger reminder = BigInteger.ZERO;
        int p = 0;
        BigInteger ten = BigInteger.TEN;
        BigInteger cPow;

        String stringNum = num.toString();
        while (!quot.equals(BigInteger.ZERO)) {
            reminder = quot.mod(BigInteger.valueOf(base));
            quot = quot.divide(BigInteger.valueOf(base));
            cPow = ten.pow(p);
            BigInteger dot = reminder.multiply(cPow);
            ret = ret.add(dot);
            p++;
        }
        return ret;
    }


    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            new BigInteger(strNum);
        } catch (NumberFormatException e) {
            //handle error
            ExceptionHandler.handleException();
        }
        return true;
    }

    public static ArrayList<BigInteger> removeDuplicates(ArrayList<BigInteger> toDecode) {
        ArrayList<BigInteger> noDup = new ArrayList<BigInteger>();
        LinkedHashSet<BigInteger> set = new LinkedHashSet<BigInteger>();

        for (BigInteger i : toDecode) {
            set.add(i);
        }

        for (BigInteger i : set) {
            noDup.add(i);
        }

        return noDup;
    }



    public static HashMap<BigInteger, Integer> mapIntsToValues(ArrayList<BigInteger> str) {
        HashMap<BigInteger, Integer> assoc = new HashMap<BigInteger, Integer>();
        int counter = 0;

        for (BigInteger c : str) {
            assoc.put(c, counter);
            counter++;
        }

        return assoc;
    }

    public static ArrayList<Integer> decodeStackInstruction(ArrayList<BigInteger> stackInstr) {
        ArrayList<Integer> ret = new ArrayList<Integer>();

        ArrayList<BigInteger> noDup = removeDuplicates(stackInstr);
        HashMap<BigInteger, Integer> map = mapIntsToValues(noDup);

        for(BigInteger i : stackInstr) {
            int val = map.get(i);
            ret.add(val);
        }

        return ret;
    }

    public static String keepNumbersOnly(String toDecode) {
        String newToDecode = new String();

        for(int i = 0; i < toDecode.length(); i++) {
            int ascii = (char) toDecode.charAt(i);
            if(ascii >= 48 && ascii <= 57 ) {
                newToDecode += toDecode.charAt(i);
            }
        }
        return newToDecode;
    }



    public static GlyphoInstruction createInstruction(Type type) {
        switch (type) {
            case ADD:
                GlyphoInstruction add = new Add();
                return add;

            case DUP:
                GlyphoInstruction dup = new Dup();
                return dup;

            case EXECUTE:
                GlyphoInstruction exec = new Execute();
                return exec;

            case INPUT:
                GlyphoInstruction in = new Input();
                return in;

            case LBRACE:
                GlyphoInstruction lbrace = new Lbrace();
                return lbrace;

            case MULTIPLY:
                GlyphoInstruction m = new Multiply();
                return m;

            case NEGATE:
                Negate n = new Negate();
                return n;

            case NOP:
                Nop nop = new Nop();
                return nop;

            case OUTPUT:
                Output out = new Output();
                return out;

            case POP:
                Pop pop = new Pop();
                return pop;

            case PUSH:
                Push push = new Push();
                return push;

            case RBRACE:
                Rbrace rbrace = new Rbrace();
                return rbrace;

            case ROT:
                Rot rot = new Rot();
                return rot;


            case RROT:
                Rrot rrot = new Rrot();
                return rrot;

            case SWAP:
                Swap swap = new Swap();
                return swap;

            default:
                //handle exception
                ExceptionHandler.handleException();
        }
        GlyphoInstruction none = new GlyphoInstruction() {
            @Override
            public void run() {
                System.out.println("Smth wrong");
            }
        };
        return none;
    }
}
