import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.Files.exists;

public class Main {
    public static void main(String[] args) {
        if (args.length == 1) {
            String argument = args[0];
            Path sourcePath = Paths.get(argument);
            if (!exists(sourcePath)) {
                try {
                    System.out.println(String.format("File: '%s' does not exists", argument));
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                System.exit(0);
            }
            FileHandler fileHandler = new FileHandler(sourcePath.toString());
            RunCommands runCommands = new RunCommands(new Calculate(), fileHandler.readFile());

            int result;
            result = runCommands.runCommands();
            if (result == -1) {
                System.out.println(String.format("File: %s contains an error", argument));
            } else {
                System.out.println(result);
            }
        } else {
            System.out.println("Argument is missing");
        }
    }
}
