package glyphoinstructions;
import stack.GlyphoStack;

import java.math.BigInteger;

public class Push extends GlyphoInstruction {
    public static final Type name = Type.PUSH;
    public static final String code = "0012";
    @Override
    public void run() {
        GlyphoStack.stack.push(BigInteger.ONE);
    }
}