package app;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by chip on 3/23/18.
 */
public class csvData {
    String rawData;
    String data[][];
    String lineData[];
    int lineCount;
    int fieldCount;
    int i;
    private String filePath;
    private FileInputStream file;

    csvData(String f) {
        rawData = "";
        lineCount = 0;
        fieldCount = 1;
        filePath = f;
        try {
            file = new FileInputStream(f);
        } catch (FileNotFoundException e) {
            System.out.println("File not found or was unreadable." + e);
        }

        try {
            do {
                i = file.read();
                if (lineCount == 0 ) {
                    if (i == 44) {
                        fieldCount++;
                    }
                }
                 if (i == 10)  {
                        lineCount++;
                 }
                 rawData += (char) i;
            } while (i != -1);
        } catch (IOException e) {
            System.out.println("Error reading file." + e);
        }

        data = new String[lineCount][];
        lineData = rawData.split("\n");
        for (int counter=0; counter < lineCount; counter ++) {
            data[counter] = lineData[counter].split(",");
        }

        try {
            file.close();
        } catch (IOException e) {
            System.out.println("Error closing file." + e);
        }
    }

    int getLineCount() { return lineCount; }
    int getFieldCount() { return fieldCount; }
    String getRawData() { return rawData; }
    String[] getLineArray() { return lineData; }
    String[][] getDataArray() { return data; }
    String[] getHeaderArray() { return data[0]; }
    String getHeaders() { return Arrays.toString(data[0]); }


}
