package main;
import decoder.GlyphoDecoder;
import glyphoinstructions.GlyphoInstruction;
import reader.GlyphoReader;
import runner.CodeRunner;
import validator.InstructionValidator;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static String glyFile;
    public static String baseString;
    public static int base;
    public static void main(String[] args) throws IOException {
        glyFile = args[0];
        base = 10;
        if(args.length > 1) {
            baseString = args[1];
            base = Integer.parseInt(baseString);
        }

        GlyphoReader glyphoReader = new GlyphoReader(glyFile);
        String glyphoCode = glyphoReader.load();
        GlyphoDecoder decoder = new GlyphoDecoder();
        CodeRunner runner = new CodeRunner();
        ArrayList<String> instructions = decoder.decode(glyphoCode);
        InstructionValidator validator = new InstructionValidator();
        ArrayList<GlyphoInstruction> glyphoInstructions = validator.toGlyphoInstruction(instructions);

        runner.runGlypho(glyphoInstructions);
    }
}
