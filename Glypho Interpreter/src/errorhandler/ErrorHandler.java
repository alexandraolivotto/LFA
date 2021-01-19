package errorhandler;

import utils.Utils;

public class ErrorHandler {
    private static String errorFile;

    public ErrorHandler(String errorFile) {
        this.errorFile = errorFile;
    }

    public static void handleError() {
        String err = "Error:" + Utils.errorCounter;
        System.err.println(err);
        System.exit(-1);
    }
}
