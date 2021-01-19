package glyphoinstructions;

import utils.Utils;

public class Rbrace extends GlyphoInstruction {
    public static final Type name = Type.RBRACE;
    public static final String code = "0123";
    @Override
    public void run() {
        Utils.jumpToLeft = true;
    }
}
