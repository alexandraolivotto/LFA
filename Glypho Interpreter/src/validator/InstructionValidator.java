package validator;
import errorhandler.ErrorHandler;
import glyphoinstructions.*;
import utils.Utils;

import java.util.ArrayList;
import java.util.Stack;


public class InstructionValidator {

    public ArrayList<GlyphoInstruction> toGlyphoInstruction(ArrayList<String> set) {
        ArrayList<GlyphoInstruction> glyphoInstructions = new ArrayList<GlyphoInstruction>();
        InstructionValidator validator = new InstructionValidator();
        Stack<Integer> braces = new Stack<Integer>();
        int braceTag = 0;
        int index = 0;
        for (String instruction : set) {
            Utils.errorCounter++;
            if (!isInstructionValid(instruction)) {
                //handle Error
                ErrorHandler.handleError();
            }
            GlyphoInstruction toAdd = Utils.createInstruction(validator.getInstructionType(instruction));
            toAdd.setTag(-1);
            toAdd.setIdx(index);
            index++;
            if(instruction.equals(Lbrace.code)) {
                braces.push(braceTag);
                toAdd.setTag(braceTag);
                braceTag++;
            }
            if(instruction.equals(Rbrace.code)) {
                if(braces.empty()) {
                    //handle error
                    ErrorHandler.handleError();
                }
                toAdd.setTag(braces.pop());
            }
            glyphoInstructions.add(toAdd);
        }

        if(!braces.empty()) {
            Utils.errorCounter++;
            ErrorHandler.handleError();
        }

        return glyphoInstructions;
    }

    public boolean isInstructionStringValid(String str) {
        if(str.length() % 4 != 0) {
            return false;
        }

        return true;
    }

    public boolean isInstructionValid(String instruction) {
        if (instruction.equals(Add.code) || instruction.equals(Dup.code) || instruction.equals(Execute.code) ||
                instruction.equals(Multiply.code) || instruction.equals(Lbrace.code) || instruction.equals(Input.code) ||
                instruction.equals(Negate.code) || instruction.equals(Nop.code) || instruction.equals(Output.code) ||
                instruction.equals(Rbrace.code) || instruction.equals(Push.code) || instruction.equals(Pop.code) ||
                instruction.equals(Rot.code) || instruction.equals(Rrot.code) || instruction.equals(Swap.code)) {
            return true;
        }

        return false;
    }

    public Type getInstructionType(String instruction) {
        switch (instruction) {
            case Add.code:
                return Add.name;
            case Dup.code:
                return Dup.name;
            case Execute.code:
                return Execute.name;
            case Input.code:
                return Input.name;
            case Lbrace.code:
                return Lbrace.name;
            case Multiply.code:
                return Multiply.name;
            case Negate.code:
                return Negate.name;
            case Nop.code:
                return Nop.name;
            case Output.code:
                return Output.name;
            case Pop.code:
                return Pop.name;
            case Push.code:
                return Push.name;
            case Rbrace.code:
                return Rbrace.name;
            case Rot.code:
                return Rot.name;
            case Rrot.code:
                return Rrot.name;
            case Swap.code:
                return Swap.name;
            default:
                return Type.UNKNOWN;
        }
    }
 }
