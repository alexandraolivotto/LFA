package glyphoinstructions;

import errorhandler.ExceptionHandler;
import main.Main;
import stack.GlyphoStack;
import utils.Utils;

import java.math.BigInteger;

public class Input extends GlyphoInstruction {
    public static final Type name = Type.INPUT;
    public static final String code = "0001";
    @Override
    public void run() {

        BigInteger num;
        if(Utils.inputScanner.hasNext()) {
            String data = Utils.inputScanner.next();

            if(Main.base <= 10) {
                if(!Utils.isNumeric(data)) {
                    ExceptionHandler.handleException();
                }
            }
            if(Main.base != Utils.dBase) {
               num = Utils.getDecimal(data, Main.base);
            } else {
                num = new BigInteger(data);
            }
            GlyphoStack.stack.push(num);
        }
    }
}
