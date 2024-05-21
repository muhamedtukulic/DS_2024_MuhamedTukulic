package HomeWork1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    public static Entry[] readFile(String filePath) throws IOException {
        List<Entry> entries = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(";");
                Entry entry = new Entry(data[0], data[1], data[2], data[3], data[4], data[5]);
                entries.add(entry);
            }
        }
        return entries.toArray(new Entry[0]);
    }

    public static void writeToFile(Entry[] entries, String filePath) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            bw.write("Name;Street Address;City;Postcode;Country;Phone Number\n");
            for (Entry entry : entries) {
                bw.write(entry.toString() + "\n");
            }
        }
    }
}
