package glyphoinstructions;
public class Nop extends GlyphoInstruction {
    public static final Type name = Type.NOP;
    public static final String code = "0000";
    @Override
    public void run() {
    }
}
