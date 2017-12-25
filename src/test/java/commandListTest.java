import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

public class commandListTest {

    @Test
    public void applyTest() {
        int expected = 3;
        LinkedList<String> myList = new LinkedList<>();
        myList.add("apply 3");

        int acctual = RunCommands.runCommands(myList);
        assertEquals(expected, acctual);
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
    public void applyWithAddTest() {
        int expected = 5;
        LinkedList<String> myList = new LinkedList<>();
        myList.add("add 2");
        myList.add("apply 3");

        int acctual = RunCommands.runCommands(myList);
        assertEquals(expected, acctual);
    }

}
