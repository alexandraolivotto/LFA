package glyphoinstructions;

import errorhandler.ExceptionHandler;
import stack.GlyphoStack;
import utils.Utils;

public class Pop extends GlyphoInstruction {
    public static final Type name = Type.POP;
    public static final String code = "0122";
    @Override
    public void run() {
        if (!GlyphoStack.stack.empty()) {
            GlyphoStack.stack.pop();
        } else {
            //handle exception
            Utils.instructionCounter = this.getIdx();
            ExceptionHandler.handleException();
        }
    }
}
