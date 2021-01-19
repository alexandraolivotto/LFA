package reader;
import java.io.*;
import java.util.Scanner;

public class GlyphoReader {
    private final String inputPath;
    public String getInputPath() {
        return inputPath;
    }

    public GlyphoReader(String inputPath) {
        this.inputPath = inputPath;
    }

    public String load() throws IOException {
        String glyphoCode = new String();
        File file = new File(inputPath);

        BufferedReader br = new BufferedReader(new FileReader(file));
        glyphoCode = br.readLine();
        return glyphoCode;
    }
}
