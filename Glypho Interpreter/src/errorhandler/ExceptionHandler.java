package errorhandler;

import utils.Utils;

public class ExceptionHandler {
    private static String errorFile;

    public ExceptionHandler(String errorFile) {
        this.errorFile = errorFile;
    }

    public static void handleException() {
        String err = "Exception:" + Utils.instructionCounter;
        System.err.println(err);
        System.exit(-2);
    }
}
