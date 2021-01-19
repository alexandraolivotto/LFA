package glyphoinstructions;
import errorhandler.ExceptionHandler;
import main.Main;
import stack.GlyphoStack;
import utils.Utils;

import java.math.BigInteger;
import java.util.ArrayList;

public class Output extends GlyphoInstruction {
    public static final Type name = Type.OUTPUT;
    public static final String code = "0111";
    @Override
    public void run() {
        BigInteger show;
        ArrayList<Character> bigBase;
        if (!GlyphoStack.stack.empty()) {
            if (Main.base != Utils.dBase) {
                if (Main.base < Utils.dBase) {
                    StringBuilder neg = new StringBuilder();
                    show = Utils.decimalToBase(Main.base, GlyphoStack.stack.peek());

                    System.out.println(show);
                } else {
                    if(GlyphoStack.stack.peek().compareTo(BigInteger.ZERO) == 0) {
                        System.out.println("0");
                        GlyphoStack.stack.pop();
                        return;
                    }
                    bigBase = Utils.decimalToBigBase(Main.base, GlyphoStack.stack.peek());
                    StringBuilder rev = new StringBuilder(bigBase.size());
                    for (Character c : bigBase) {
                        rev.append(c);
                    }
                    GlyphoStack.stack.pop();
                    rev.reverse();
                    System.out.println(rev.toString());
                }

            } else {
                show = GlyphoStack.stack.pop();
                System.out.println(show);
            }
        } else {
            //handle exception
            Utils.instructionCounter = this.getIdx();
            ExceptionHandler.handleException();
        }
    }
}
