package glyphoinstructions;
import errorhandler.ExceptionHandler;
import stack.GlyphoStack;
import utils.Utils;

import java.math.BigInteger;

public class Lbrace extends GlyphoInstruction {
    public static final Type name = Type.LBRACE;
    public static final String code = "0110";
    @Override
    public void run() {
        if(GlyphoStack.stack.empty()) {
            //handle exception
            Utils.instructionCounter = this.getIdx();
            ExceptionHandler.handleException();
        }
        if(GlyphoStack.stack.peek().equals(BigInteger.ZERO)) {
            Utils.jumpToRight = true;
        }
    }
}
