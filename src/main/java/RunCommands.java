import java.util.LinkedList;

public class RunCommands {
    private static final String PARAMETER_DIVIDER = " ";
    private static final int COMMAND_ARGUMENTS = 2;
    private static final int COMMAND_INDEX = 0;
    private static final int PARAMETER_INDEX = 1;

    private boolean passed;
    private Calculate calculate;
    private StringBuilder errorMessage;
    private LinkedList<String> myList;

    public RunCommands(Calculate calculate, LinkedList<String> myList) {
        this.passed = false;
        this.calculate = calculate;
        this.errorMessage = new StringBuilder();
        this.myList = myList;
    }

    private void setPassed(boolean passed) {
        this.passed = passed;
    }

    public boolean isPassed() {
        return passed;
    }

    public int runCommands() {
        doWork();
        if (isPassed()) {
            return calculate.getAmount();
        } else {
            System.out.println(errorMessage.toString());
        }
        return -1;
    }

    private void doWork() {
        proceedApply();
        if (isPassed()) {
            for (int i = 0; i < myList.size()-1; i++) {
                String currentLine = myList.get(i);
                if (commandFormatIsOk(currentLine)) {
                    runTheCommand(currentLine);
                    if (!(isPassed())) {
                        errorMessage.append(String.format("Something is wrong, with command '%s'", currentLine));
                        break;
                    }
                } else {
                    errorMessage.append(String.format("Command format is wrong '%s'", currentLine));
                    setPassed(false);
                    break;
                }
            }
        }
    }

    private void runTheCommand(String currentLine) {
        String[] currentCommand;
        currentCommand = getSplitMyCommand(currentLine);
        String whatWeDo = currentCommand[COMMAND_INDEX].toUpperCase();
        int amount = getAmount(currentCommand);
        switch (whatWeDo) {
            case "ADD":
                setPassed(calculate.add(amount));
                break;
            case "MULTIPLY":
                setPassed(calculate.multiply(amount));
                break;
            case "SUBTRACT":
                setPassed(calculate.subtract(amount));
                break;
            case "DIVIDE":
                setPassed(calculate.divide(amount));
                break;

            default:
                errorMessage.append(String.format("Sorry the '%s' is not supported", whatWeDo));
                errorMessage.append(System.getProperty("line.separator"));
                setPassed(false);
                break;
        }
    }

    private void proceedApply() {
        String[] currentCommand;
        String applyString = myList.getLast();
        if (applyString.toUpperCase().startsWith("APPLY")) {
            if (commandFormatIsOk(applyString)) {
                currentCommand = getSplitMyCommand(applyString);
                setPassed(calculate.apply(getAmount(currentCommand)));
            } else {
                System.out.println(String.format("Sorry an argument for command '%s' is missing!", applyString));
            }
        } else {
            System.out.println(String.format("Sorry the last command has to be Apply, but was '%s'", applyString));
        }
    }

    private String[] getSplitMyCommand(String applyString) {
        return applyString.split(PARAMETER_DIVIDER);
    }

    private int getAmount(String[] command) {
        return Integer.parseInt(command[PARAMETER_INDEX]);
    }

    private boolean commandFormatIsOk(String command) {
        return COMMAND_ARGUMENTS == command.split(PARAMETER_DIVIDER).length;
    }
}