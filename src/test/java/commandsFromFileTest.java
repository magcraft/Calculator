import org.junit.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

public class commandsFromFileTest {

    @Test
    public void readFromFileTest() {
        String fileName = "ApplyTest_1.csv";
        LinkedList<String> expectedList = new LinkedList<>();
        expectedList.add("Apply 4");
        createFile(fileName, expectedList);

        FileHandler fileHandler = new FileHandler(fileName);
        LinkedList<String> myList = fileHandler.readFile();
        deleteFile(fileName);

        assertEquals(Arrays.toString(expectedList.toArray()), Arrays.toString(myList.toArray()));
    }

    @Test
    public void readSeveralLinesFromFileTest() {
        String fileName = "ApplyTest_2.csv";
        LinkedList<String> expectedList = new LinkedList<>();
        expectedList.add("add 2");
        expectedList.add("multiply 3");
        expectedList.add("Apply 4");
        createFile(fileName, expectedList);

        FileHandler fileHandler = new FileHandler(fileName);
        LinkedList<String> myList = fileHandler.readFile();

        assertEquals(Arrays.toString(expectedList.toArray()), Arrays.toString(myList.toArray()));
        deleteFile(fileName);
    }

    @Test
    public void readSeveralLinesFromFileAndCalculateTest() {
        String fileName = "ApplyTest_3.csv";
        int expectedInt = 18;
        LinkedList<String> expectedList = new LinkedList<>();
        expectedList.add("add 2");
        expectedList.add("multiply 3");
        expectedList.add("Apply 4");
        createFile(fileName, expectedList);

        FileHandler fileHandler = new FileHandler(fileName);
        RunCommands runCommands = new RunCommands(new Calculate(), fileHandler.readFile());
        assertEquals(expectedInt, runCommands.runCommands());
        deleteFile(fileName);
    }

    private void deleteFile(String fileName) {
        try {
            File ourFile = new File(fileName);
            ourFile.delete();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void createFile(String fileName, LinkedList<String> myList) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (int i = 0; i < myList.size(); i++) {
                writer.write(myList.get(i));
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
