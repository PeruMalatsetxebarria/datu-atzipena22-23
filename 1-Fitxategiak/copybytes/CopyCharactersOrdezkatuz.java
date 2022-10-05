//xanadu.txt barruan dagoena kopiatzen du characteroutput.txt fitxategian

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyCharactersOrdezkatuz {
    public static void main(String[] args) throws IOException {

        FileReader inputStream = null;
        FileWriter outputStream = null;

        try {
            inputStream = new FileReader("xanadu.txt");
            outputStream = new FileWriter("characteroutput.txt");

            int c;
            String l;
            while ((c = inputStream.read()) != -1) {
                if ( (l = (inputStream.toString())) == "a"){
                    outputStream.write("o");
                } else {
                    outputStream.write("c");
                }
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }
}