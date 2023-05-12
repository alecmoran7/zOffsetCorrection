import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class main {

    public static void main(String[] args) throws IOException {

        String inputFileName = args[0];
        String outputFileName = args[0] + " (with offset)";
        Double desiredOffset = Math.abs(Double.parseDouble(args[1]));

        File inputFile = new File(inputFileName);
        FileWriter outputFile = new FileWriter(outputFileName);

        if (inputFile.exists()){
            try {
                Scanner scnr = new Scanner(inputFile);
                while (scnr.hasNextLine()){
                    String data = scnr.nextLine();
                    System.out.println(data);
                    Pattern pattern = Pattern.compile("Z[0-9]+.[0-9]+");
                    Matcher matcher = pattern.matcher(data);
                    boolean matchFound = matcher.find();
                    if (matchFound) {
                        Double zOffset = Double.parseDouble(data.substring(matcher.start()+1, matcher.end()));
                        Double adjustedZOffset = zOffset - desiredOffset;
                        String adjustedLine = matcher.replaceAll("Z" + adjustedZOffset.toString());
                        outputFile.write(adjustedLine + "\n");
                    }
                    else {
                        outputFile.write(data + "\n");
                    }
                }
                scnr.close();
                outputFile.close();
                System.out.println("Finished");
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        else {
            System.err.println("ERROR: File not found: " + inputFileName);
        }
    }
}
