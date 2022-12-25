import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Generator {

    public static int random() {
        int min = 0;
        int max = 120;
        int diff = max - min;
        Random random = new Random();
        int i = random.nextInt(diff + 1);
        return i;
    }
    public static void main(String[] args) throws IOException {
        List<String> data = new LinkedList<>();
        FileWriter fileWriter = new FileWriter("data_temp.txt", false);
        for (int i = 1; i <= 100001; i++) {
            data.add("Minsk " + random() + "\n");
        }
        for (int i = 1; i <= 100001; i++) {
            data.add("Brest " + random() + "\n");
        }
        for (int i = 1; i <= 100001; i++) {
            data.add("Vitebsk " + random() + "\n");
        }
        for (int i = 1; i <= 100001; i++) {
            data.add("Mogilev " + random() + "\n");
        }
        for (int i = 1; i <= 100001; i++) {
            data.add("Grodno " + random() + "\n");
        }
        for (int i = 1; i <= 100001; i++) {
            data.add("Gomel " + random() + "\n");
        }
        Collections.shuffle(data);
        for (int i = 0; i < data.size(); i++) {
            fileWriter.append(data.get(i));
        }
        fileWriter.close();
    }
}
