//runs a given set of instructions
package runner;
import glyphoinstructions.GlyphoInstruction;
import utils.Utils;
import validator.InstructionValidator;

import java.util.ArrayList;

public class CodeRunner {

    public void runGlypho(ArrayList<GlyphoInstruction> instructionSet) {
        InstructionValidator validator = new InstructionValidator();
        for (int i = 0; i < instructionSet.size(); i++) {
            Utils.jumpIndex = -1;
            instructionSet.get(i).run();
            Utils.instructionCounter++;
            if(Utils.jumpToRight == true) {
                for(int j = instructionSet.get(i).getIdx() + 1; j <= instructionSet.size(); j++) {
                    if(instructionSet.get(j).getTag()  == instructionSet.get(i).getTag()) {
                        Utils.jumpIndex = instructionSet.get(j).getIdx();
                        break;
                    }
                }
                Utils.jumpToRight = false;
                i = Utils.jumpIndex;
            }

            if(Utils.jumpToLeft == true) {
                for(int j = instructionSet.get(i).getIdx() - 1; j >= 0; j--) {
                    if(instructionSet.get(j).getTag()  == instructionSet.get(i).getTag()) {
                        Utils.jumpIndex = instructionSet.get(j).getIdx();
                        break;
                    }
                }
                Utils.jumpToLeft = false;
                i = Utils.jumpIndex - 1;
            }
        }
    }
}
