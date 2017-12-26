This is a simple calculator program. The program gives data for calculation from the file which is a first argument when you run the program.

Because this is a console application you need to use console for run it.

Command for run program looks like this:

Before you are going to run the program you need to go to the folder witch contains the program files.

java Calculator file_for_calculation

Or write path to the folder with program files. It can look like this:
java [path to the program files]Calculator [path to the calculation file]file_for_calculation

Suppose all program files and calculation file in the “Test” folder. And if you use Windows the folder is on disk C: than you can use command.

for Windows: 
“java c:\Test\Calculator example.csv”

for Linux/Mac: 
“java /Test/Calculation example.csv”

You can find file for calculation example in Resource folder called “example.csv”. This file contains several commands (add2, multiply3, apply4) When you run the application using the command “java [path to files]Calculator [path to example file]example.cvs”

You will see the calculation result 18, because (4+2) * 3 = 18.

Every command has format: “command_name number”
Command and number have to be separated by space.

Calculation file can contains five different command “add”, “subtract”, “divide”, “multiply” and final command “apply”.

Commands can be combined in different order except the “apply”. This command can be the only one in each file and it has to be last command in the file.

Some explanation how it works.

	For example look at the command:
		'java Main example.cvs'
	where:
		java - JVM which will execute the application;
		Main - this is a class which runs the program;
		example.cvs - a file contains the command for calculation.

	Program supports next commands:
		- add N - where N is a number for adding
		- multiply N - where N is a number for multiple
		- divide N - N is a number for dividing, must not be equal zero
		- subtract N - where N is a number for subtracting
		- apply N - where N is a number which starts a calculation.
			This command can be the only one in each file.
			Important note without 'apply N' calculation will not begin .

	For example we have a file with commands:

	Example 1
		[rows in file]
		apply 5

		[result on the screen]
		5

		[explanation]
		5

	Example 2
		[rows in file]
		add 2
		multiply 3
		apply 4

		[result on the screen]
		18

		[explanation]
		(4 + 2) * 3 = 18
