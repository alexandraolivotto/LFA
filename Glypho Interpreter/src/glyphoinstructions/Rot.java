package glyphoinstructions;
import errorhandler.ExceptionHandler;
import stack.GlyphoStack;
import utils.Utils;

import java.math.BigInteger;
import java.util.ArrayList;

public class Rot extends GlyphoInstruction {
    public static final Type name = Type.ROT;
    public static final String code = "0010";
    @Override
    public void run() {
        if (!GlyphoStack.stack.empty()) {
            BigInteger toRot = GlyphoStack.stack.pop();
            ArrayList<BigInteger> temp = new ArrayList<BigInteger>();
            while (!GlyphoStack.stack.empty()) {
                temp.add(GlyphoStack.stack.pop());
            }
            GlyphoStack.stack.push(toRot);
            for (int i = temp.size() - 1; i >= 0; i--) {
                GlyphoStack.stack.push(temp.get(i));
            }
        } else {
            //handle exception
            Utils.instructionCounter = this.getIdx();
            ExceptionHandler.handleException();
        }
    }
}
