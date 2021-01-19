package glyphoinstructions;
import errorhandler.ExceptionHandler;
import stack.GlyphoStack;
import utils.Utils;

import java.math.BigInteger;

public class Add extends GlyphoInstruction {
    public static final Type name = Type.ADD;
    public static final String code = "0102";
    @Override
    public void run() {
        BigInteger a;
        BigInteger b;
        if (!GlyphoStack.stack.empty()) {
            a = GlyphoStack.stack.pop();
            if (!GlyphoStack.stack.empty()) {
                b = GlyphoStack.stack.pop();
                GlyphoStack.stack.push(a.add(b));
            } else {
                //handle exception
                Utils.instructionCounter = this.getIdx();
                ExceptionHandler.handleException();
            }
        } else {
            //handle exception
            Utils.instructionCounter = this.getIdx();
            ExceptionHandler.handleException();
        }
    }
}
