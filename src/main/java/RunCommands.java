import java.util.LinkedList;

public class RunCommands {
    private static final int COMMAND_ARGUMENTS = 2;
    private static final String PARAMETER_DIVIDER = " ";
    private static final int PARAMETER_INDEX = 1;

    public static int runCommands(LinkedList<String> myList) {
        Calculate calculate = new Calculate();
        String[] currentCommand = new String[COMMAND_ARGUMENTS];

        String applyString = myList.getLast();
        if (applyString.toUpperCase().startsWith("APPLY")) {
            if (commandFormatIsOk(applyString)) {
                currentCommand = getSplitMyCommand(applyString);
                calculate.apply(getAmount(currentCommand));
            } else {
                return -1;
            }
        }

        for (int i = 0; i < myList.size()-1; i++) {
            String currentLine = myList.get(i);
            if (commandFormatIsOk(currentLine)) {
                currentCommand = getSplitMyCommand(currentLine);
                String whatWeDo = currentCommand[0].toUpperCase();
                switch (whatWeDo) {
                    case "ADD":
                        calculate.add(getAmount(currentCommand));
                        break;
                }

            } else {
                return -1;
            }
        }
        return calculate.getAmount();
    }

    private static String[] getSplitMyCommand(String applyString) {
        return applyString.split(PARAMETER_DIVIDER);
    }

    private static int getAmount(String[] command) {
        return Integer.parseInt(command[PARAMETER_INDEX]);
    }

    private static boolean commandFormatIsOk(String command) {
        if (COMMAND_ARGUMENTS == command.split(PARAMETER_DIVIDER).length) {
            return true;
        }
        return false;
    }
}