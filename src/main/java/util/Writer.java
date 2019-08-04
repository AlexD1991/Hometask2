package util;

import java.io.*;
import java.nio.charset.StandardCharsets;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

public class Writer {

    public static void clearFile(String filePath){
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(filePath);
            writer.print("");
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void writeToFile(String text, String filePath){
        try
        {
            File f = new File(filePath);
            OutputStreamWriter write = new OutputStreamWriter(new FileOutputStream(f,true), StandardCharsets.UTF_8);
            BufferedWriter writer = new BufferedWriter(write);
            writer.write(text);
            writer.close();
        } catch (IOException e)
        {
            LOGGER.info("Impossible to create or write to the file " + filePath);
            e.printStackTrace();
        }
    }
}
