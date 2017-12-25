import java.util.LinkedList;

public class RunCommands {
    private static final int COMMAND_ARGUMENTS = 2;
    private static final String PARAMETER_DIVIDER = " ";
    private static final int PARAMETER_INDEX = 1;

    public static int runCommands(LinkedList<String> myList) {
        Calculate calculate = new Calculate();
        String[] currentCommand = new String[COMMAND_ARGUMENTS];
        boolean passed;
        StringBuilder errorMessage = new StringBuilder();

        passed = proceedApply(myList, calculate);
        if (passed) {
            for (int i = 0; i < myList.size()-1; i++) {
                String currentLine = myList.get(i);
                if (commandFormatIsOk(currentLine)) {
                    currentCommand = getSplitMyCommand(currentLine);
                    String whatWeDo = currentCommand[0].toUpperCase();
                    int amount = getAmount(currentCommand);
                    switch (whatWeDo) {
                        case "ADD":
                            passed = calculate.add(amount);
                            break;
                        case "MULTIPLY":
                            passed = calculate.multiply(amount);
                            break;
                        case "SUBTRACT":
                            passed = calculate.subtract(amount);
                            break;
                        case "DIVIDE":
                            passed = calculate.divide(amount);
                            break;

                        default:
                            errorMessage.append(String.format("Sorry command '%s' is not supported", whatWeDo));
                            break;
                    }
                    if (!(passed)) {
                        errorMessage.append(String.format("Something is wrong, with command '%s'", currentLine));
                        break;
                    }
                } else {
                    return -1;
                }
            }
            if (passed) {
                return calculate.getAmount();
            }
        }
        if (errorMessage.length() != 0) {
            System.out.println(errorMessage.toString());
        }
        return -1;
    }

    private static boolean proceedApply(LinkedList<String> myList, Calculate calculate) {
        String[] currentCommand;
        boolean passed;
        String applyString = myList.getLast();
        if (applyString.toUpperCase().startsWith("APPLY")) {
            if (commandFormatIsOk(applyString)) {
                currentCommand = getSplitMyCommand(applyString);
                passed = calculate.apply(getAmount(currentCommand));
            } else {
                System.out.println(String.format("Sorry an argument for command '%s' is missing!", applyString));
                return false;
            }
        } else {
            System.out.println(String.format("Sorry the last command has to be Apply, but was '%s'", applyString));
            return false;
        }
        return passed;
    }

    private static String[] getSplitMyCommand(String applyString) {
        return applyString.split(PARAMETER_DIVIDER);
    }

    private static int getAmount(String[] command) {
        return Integer.parseInt(command[PARAMETER_INDEX]);
    }

    private static boolean commandFormatIsOk(String command) {
        return COMMAND_ARGUMENTS == command.split(PARAMETER_DIVIDER).length;
    }
}