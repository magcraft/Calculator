import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

public class commandListTest {

    @Test
    public void applyTest() {
        int expected = 3;
        LinkedList<String> myList = new LinkedList<>();
        myList.add("apply 3");

        RunCommands runCommands = new RunCommands(new Calculate(), myList);
        int actual = runCommands.runCommands();
        assertEquals(expected, actual);
    }

    @Test
    public void wrongCommandFormatTest() {
        int expected = -1;
        LinkedList<String> myList = new LinkedList<>();
        myList.add("apply ");

        RunCommands runCommands = new RunCommands(new Calculate(), myList);
        int actual = runCommands.runCommands();
        assertEquals(expected, actual);
    }

    @Test
    public void wrongCommandFormat2Test() {
        int expected = -1;
        LinkedList<String> myList = new LinkedList<>();
        myList.add("add ");
        myList.add("apply 1");

        RunCommands runCommands = new RunCommands(new Calculate(), myList);
        int actual = runCommands.runCommands();
        assertEquals(expected, actual);
    }

    @Test
    public void listWitWrongCommandTest() {
        int expected = -1;
        LinkedList<String> myList = new LinkedList<>();
        myList.add("addee 1");
        myList.add("apply 4");

        RunCommands runCommands = new RunCommands(new Calculate(), myList);
        int actual = runCommands.runCommands();
        assertEquals(expected, actual);
    }

    @Test
    public void wrongCommandOrderTest() {
        int expected = -1;
        LinkedList<String> myList = new LinkedList<>();
        myList.add("apply 1");
        myList.add("add 2");

        RunCommands runCommands = new RunCommands(new Calculate(), myList);
        int actual = runCommands.runCommands();
        assertEquals(expected, actual);
    }


    @Test
    public void applyWithAddTest() {
        int expected = 5;
        LinkedList<String> myList = new LinkedList<>();
        myList.add("add 2");
        myList.add("apply 3");

        RunCommands runCommands = new RunCommands(new Calculate(), myList);
        int actual = runCommands.runCommands();
        assertEquals(expected, actual);
    }

    @Test
    public void firstExampleFromListTest() {
        int expected = 18;
        LinkedList<String> myList = new LinkedList<>();
        myList.add("add 2");
        myList.add("multiply 3");
        myList.add("apply 4");

        RunCommands runCommands = new RunCommands(new Calculate(), myList);
        int actual = runCommands.runCommands();
        assertEquals(expected, actual);
    }

    @Test
    public void secondExampleFromListTest() {
        int expected = 45;
        LinkedList<String> myList = new LinkedList<>();
        myList.add("multiply 9");
        myList.add("apply 5");

        RunCommands runCommands = new RunCommands(new Calculate(), myList);
        int actual = runCommands.runCommands();
        assertEquals(expected, actual);
    }

    @Test
    public void allCommandsFromListTest() {
        int expected = 4;
        LinkedList<String> myList = new LinkedList<>();
        myList.add("add 2");
        myList.add("multiply 3");
        myList.add("subtract 2");
        myList.add("divide 4");
        myList.add("apply 4");

        RunCommands runCommands = new RunCommands(new Calculate(), myList);
        int actual = runCommands.runCommands();
        assertEquals(expected, actual);
    }

    @Test
    public void divideByZeroTest() {
        int expected = -1;
        LinkedList<String> myList = new LinkedList<>();
        myList.add("divide 0");
        myList.add("apply 4");

        RunCommands runCommands = new RunCommands(new Calculate(), myList);
        int actual = runCommands.runCommands();
        assertEquals(expected, actual);
    }
}
