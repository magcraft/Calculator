import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class FileHandler {
    private String fileName;

    public FileHandler(String fileName) {
        this.fileName = fileName;
    }

    public LinkedList<String> readFile() {
        LinkedList<String> dataFromFile = new LinkedList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(this.fileName))) {
            dataFromFile.add(reader.readLine());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return  dataFromFile;
    }
}
