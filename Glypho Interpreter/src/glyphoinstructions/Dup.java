package glyphoinstructions;
import errorhandler.ExceptionHandler;
import stack.GlyphoStack;
import utils.Utils;

import java.math.BigInteger;

public class Dup extends GlyphoInstruction {
    public static final Type name = Type.DUP;
    public static final String code = "0101";
    @Override
    public void run() {
        BigInteger a;
        if(!GlyphoStack.stack.empty()) {
            a = GlyphoStack.stack.peek();
            GlyphoStack.stack.push(a);
        } else {
            //handle exception
            Utils.instructionCounter = this.getIdx();
            ExceptionHandler.handleException();
        }
    }
}
