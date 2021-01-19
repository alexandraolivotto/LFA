package glyphoinstructions;
import errorhandler.ExceptionHandler;
import stack.GlyphoStack;
import utils.Utils;

import java.math.BigInteger;

public class Negate extends GlyphoInstruction {
    public static final Type name = Type.NEGATE;
    public static final String code = "0121";
    @Override
    public void run() {
        BigInteger a;
        if (!GlyphoStack.stack.empty()) {
            a = GlyphoStack.stack.pop();
            GlyphoStack.stack.push(a.negate());
        } else {
            //handle exception
            Utils.instructionCounter = this.getIdx();
            ExceptionHandler.handleException();
        }
    }
}
