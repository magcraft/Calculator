import java.util.LinkedList;

public class RunCommands {
    private static final String COMMAND_SAMPLE = "Command Argument";
    private static final int PARAMETER_INDEX = 1;

    public static int runCommands(LinkedList<String> myList) {
        int count = COMMAND_SAMPLE.split(" ").length;
        int result = 0;
        for (int i = 0; i < myList.size(); i++) {
            String[] currentLine = myList.get(i).split(" ");
            if (count != currentLine.length) {
                System.out.println("Wrong comand = " + currentLine);
            }
            result = Integer.parseInt(currentLine[PARAMETER_INDEX]);
        }
        return result;
    }
}
