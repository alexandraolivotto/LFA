package glyphoinstructions;
import errorhandler.ExceptionHandler;
import stack.GlyphoStack;
import utils.Utils;

import java.math.BigInteger;

public class Multiply extends GlyphoInstruction {
    public static final Type name = Type.MULTIPLY;
    public static final String code = "0112";
    @Override
    public void run() {
        BigInteger a;
        BigInteger b;
        if (!GlyphoStack.stack.empty()) {
            a = GlyphoStack.stack.pop();
            if (!GlyphoStack.stack.empty()) {
                b = GlyphoStack.stack.pop();
                GlyphoStack.stack.push(a.multiply(b));
            } else {
                //handle exception
                Utils.instructionCounter = this.getIdx();
                ExceptionHandler.handleException();
            }
        } else {
            //handle exception
            ExceptionHandler.handleException();
        }
    }
}
