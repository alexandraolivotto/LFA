package glyphoinstructions;
import errorhandler.ExceptionHandler;
import stack.GlyphoStack;
import utils.Utils;
import validator.InstructionValidator;

import java.math.BigInteger;
import java.util.ArrayList;

public class Execute extends GlyphoInstruction {
    public static final Type name = Type.EXECUTE;
    public static final String code = "0120";

    @Override
    public void run() {
        if (!GlyphoStack.stack.empty()) {
            ArrayList<BigInteger> numInstr = new ArrayList<BigInteger>();
            String instruction = new String();
            while (!GlyphoStack.stack.empty() && numInstr.size() < 4) {
                numInstr.add(GlyphoStack.stack.pop());
            }
            if(numInstr.size() < 4) {
                //handle exception
                Utils.instructionCounter = this.getIdx();
                ExceptionHandler.handleException();
            }
            ArrayList<Integer> decodedInstr = Utils.decodeStackInstruction(numInstr);
            instruction = Utils.keepNumbersOnly(decodedInstr.toString());
            InstructionValidator validator = new InstructionValidator();
            if (validator.isInstructionValid(instruction)) {
                if(!validator.getInstructionType(instruction).equals(Type.LBRACE)
                        && !validator.getInstructionType(instruction).equals(Type.RBRACE) ) {
                    GlyphoInstruction sec = Utils.createInstruction(validator.getInstructionType(instruction));
                    sec.setIdx(this.getIdx());
                    sec.run();
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
        } else {
            //handle exception
            Utils.instructionCounter = this.getIdx();
            ExceptionHandler.handleException();
        }
    }
}
