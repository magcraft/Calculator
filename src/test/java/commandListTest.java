import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

public class commandListTest {

    @Test
    public void applyTest() {
        int expected = 3;
        LinkedList<String> myList = new LinkedList<>();
        myList.add("apply 3");

        int actual = RunCommands.runCommands(myList);
        assertEquals(expected, actual);
    }

    @Test
    public void wrongCommandFormatTest() {
        int expected = -1;
        LinkedList<String> myList = new LinkedList<>();
        myList.add("apply ");
        int acctual = RunCommands.runCommands(myList);
        assertEquals(expected, acctual);
    }

    @Test
    public void wrongCommand2FormatTest() {
        int expected = -1;
        LinkedList<String> myList = new LinkedList<>();
        myList.add("add ");
        myList.add("apply 1");
        int acctual = RunCommands.runCommands(myList);
        assertEquals(expected, acctual);
    }

    @Test
    public void wrongCommandOrderTest() {
        int expected = -1;
        LinkedList<String> myList = new LinkedList<>();
        myList.add("apply 1");
        myList.add("add 2");
        int acctual = RunCommands.runCommands(myList);
        assertEquals(expected, acctual);
    }


    @Test
    public void applyWithAddTest() {
        int expected = 5;
        LinkedList<String> myList = new LinkedList<>();
        myList.add("add 2");
        myList.add("apply 3");

        int acctual = RunCommands.runCommands(myList);
        assertEquals(expected, acctual);
    }

    @Test
    public void firstExampleFromListTest() {
        int expected = 18;
        LinkedList<String> myList = new LinkedList<>();
        myList.add("add 2");
        myList.add("multiply 3");
        myList.add("apply 4");

        int acctual = RunCommands.runCommands(myList);
        assertEquals(expected, acctual);
    }

    @Test
    public void secondExampleFromListTest() {
        int expected = 45;
        LinkedList<String> myList = new LinkedList<>();
        myList.add("multiply 9");
        myList.add("apply 5");

        int acctual = RunCommands.runCommands(myList);
        assertEquals(expected, acctual);
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

        int acctual = RunCommands.runCommands(myList);
        assertEquals(expected, acctual);
    }

    @Test
    public void divideByZero() {
        int expected = -1;
        LinkedList<String> myList = new LinkedList<>();
        myList.add("divide 0");
        myList.add("apply 4");

        int acctual = RunCommands.runCommands(myList);
        assertEquals(expected, acctual);
    }
}
