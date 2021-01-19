package glyphoinstructions;
import errorhandler.ExceptionHandler;
import stack.GlyphoStack;
import utils.Utils;

import java.math.BigInteger;
import java.util.ArrayList;

public class Rrot extends GlyphoInstruction {
    public static final Type name = Type.RROT;
    public static final String code = "0100";
    @Override
    public void run() {
        if (!GlyphoStack.stack.empty()) {
            BigInteger toRot = BigInteger.ZERO;
            ArrayList<BigInteger> temp = new ArrayList<BigInteger>();
            while (!GlyphoStack.stack.empty()) {
                toRot = GlyphoStack.stack.pop();
                temp.add(toRot);
            }
            for (int i = temp.size() - 2; i >= 0; i--) {
                GlyphoStack.stack.push(temp.get(i));
            }
            GlyphoStack.stack.push(toRot);
        } else {
            //handle exception
            Utils.instructionCounter = this.getIdx();
            ExceptionHandler.handleException();
        }
    }
}
