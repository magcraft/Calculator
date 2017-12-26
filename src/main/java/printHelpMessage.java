public class printHelpMessage {
    public static String getMessage() {
        String nextLine = System.getProperty("line.separator");

        StringBuilder helpMessage = new StringBuilder();
        helpMessage.append("This program requires an argument for work." + nextLine);
        helpMessage.append(nextLine);
        helpMessage.append("\tFor example look at the command:" + nextLine);
        helpMessage.append("\t\t'java Calculator example.cvs'" + nextLine);
        helpMessage.append("\twhere:" + nextLine);
        helpMessage.append("\t\tjava - JVM which will execute the application;" + nextLine);
        helpMessage.append("\t\tMain - this is a class which runs the program;" + nextLine);
        helpMessage.append("\t\texample.cvs - a file contains the command for calculation." + nextLine);
        helpMessage.append(nextLine);
        helpMessage.append("\tProgram supports next commands:" + nextLine);
        helpMessage.append("\t\t- add N - where N is a number for adding" + nextLine);
        helpMessage.append("\t\t- multiply N - where N is a number for multiple" + nextLine);
        helpMessage.append("\t\t- divide N - N is a number for dividing, must not be equal 0 (zero)" + nextLine);
        helpMessage.append("\t\t- subtract N - where N is a number for subtracting" + nextLine);
        helpMessage.append("\t\t- apply N - where N is a number which starts a calculation." + nextLine);
        helpMessage.append("\t\t\tThis command can be the only one in each file." + nextLine);
        helpMessage.append("\t\t\tImportant note without 'apply N' calculation will not begin ." + nextLine);
        helpMessage.append(nextLine);
        helpMessage.append("\tFor example we have a file with commands:" + nextLine);
        helpMessage.append(nextLine);

        helpMessage.append("\tExample 1" + nextLine);
        helpMessage.append("\t\t[rows in file]" + nextLine);
        helpMessage.append("\t\tapply 5" + nextLine);
        helpMessage.append(nextLine);
        helpMessage.append("\t\t[result on the screen]" + nextLine);
        helpMessage.append("\t\t5" + nextLine);
        helpMessage.append(nextLine);
        helpMessage.append("\t\t[explanation]" + nextLine);
        helpMessage.append("\t\t5" + nextLine);
        helpMessage.append(nextLine);

        helpMessage.append("\tExample 2" + nextLine);
        helpMessage.append("\t\t[rows in file]" + nextLine);
        helpMessage.append("\t\tadd 2" + nextLine);
        helpMessage.append("\t\tmultiply 3" + nextLine);
        helpMessage.append("\t\tapply 4" + nextLine);
        helpMessage.append(nextLine);
        helpMessage.append("\t\t[result on the screen]" + nextLine);
        helpMessage.append("\t\t18" + nextLine);
        helpMessage.append(nextLine);
        helpMessage.append("\t\t[explanation]" + nextLine);
        helpMessage.append("\t\t(4 + 2) * 3 = 18" + nextLine);

        return  helpMessage.toString();
    }
}
