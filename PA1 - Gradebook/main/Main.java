/*
-.- .... .- .-.. .. .-..    .--. . --. ..- . .-. ---
*/
package main;

import util.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Gradebook gradebook = new Gradebook(); // Initializes grade book
	    Scanner keyboard = new Scanner(System.in); // Initializes scanner object
        System.out.println("""
                Welcome to my grade book!
                Please enter the information of the first student using the following format:
                firstName lastName PID grade".
                Press Enter when you are done.""");
        while(true) /* Input handling phase */ { // input handling phase
            String input = keyboard.nextLine();
            if (input.equals("DONE")) break;

            String[] tokens = input.split(" "); // Splits input into a string array
            if (tokens.length != 4){ // Checks how many values were inputted
                System.out.println("Try again.");
                continue;
            }
            if(validateTokens(tokens)) { // Check if the input is valid
                gradebook.getListOfStudents().add(new Student(tokens[0], //Adds student to the grade book
                        tokens[1],
                        Integer.parseInt(tokens[2]),
                        Integer.parseInt(tokens[3])));
            } else{
                System.out.println("Try again.");
                continue;
            }

            System.out.println("""
                    Please enter the information of the next student using the same format.
                    If there is no more students, please enter the keyword "DONE".
                    Press Enter when you are done.""");
        }
        System.out.println("Please enter a new command: ");
        while(true) /*Command handling phase*/ { // command handling phase
            String command = keyboard.nextLine();
            if (command.equals("QUIT")) break;
            String[] commands = command.split(" "); // Splits command into a string array
            switch(commands[0]){ // Checks the first item in the string array commands
                case "min":
                    switch(commands[1]){ // Checks the second item in the string array commands
                        case "score":
                            System.out.println("The minimum score is: " + gradebook.calculateMinScore());
                            break;
                        case "letter":
                            System.out.println("The minimum letter is: " + gradebook.calculateMinLetter());
                            break;
                    }
                    break;
                case "max":
                    switch(commands[1]){ // Checks the second item in the string array commands
                        case "score":
                            System.out.println("The maximum score is: " + gradebook.calculateMaxScore());
                            break;
                        case "letter":
                            System.out.println("The maximum letter is: " + gradebook.calculateMaxLetter());
                            break;
                    }
                    break;
                case "letter":
                    try{ // Tries to convert the second string in the array commands into an int to find student
                        System.out.println("The student's letter grade is: "
                                + gradebook.findStudent(Integer.parseInt(commands[1])).getGrade().getLetterGrade());
                        break;
                    }
                    catch(Exception e){
                        System.out.println("Try again.");
                        break;
                    }
                case "name":
                    try{ // Tries to convert the second string in the array commands into an int to find student
                        System.out.println("The student's full name is: "
                                + gradebook.findStudent(Integer.parseInt(commands[1])).getFirstName()
                                + " "
                                + gradebook.findStudent(Integer.parseInt(commands[1])).getLastName());
                        break;
                    }
                    catch(Exception e){
                        System.out.println("Try again.");
                        break;
                    }
                case "change":
                    try{ // Tries to convert the second string in the array commands into an int to find student
                        if(checkGrade(commands[2])){
                            gradebook.findStudent(Integer.parseInt(commands[1])).setGrade(new Grade(Integer.parseInt(commands[2])));
                            System.out.println("Grade changed performed successfully.");
                            break;
                        } else {
                            System.out.println("Try again.");
                            break;
                        }
                    }
                    catch(Exception e){
                        System.out.println("Try again.");
                        break;
                    }
                case "average":
                    switch(commands[1]){
                        case "score":
                            System.out.println("The average score is: " + gradebook.calculateAverageScore());
                            break;
                        case "letter":
                            System.out.println("The average letter is: " + gradebook.calculateAverageLetter());
                            break;
                    }
                    break;
                case "median":
                    switch(commands[1]){
                        case "score":
                            System.out.println("The median score is: " + gradebook.calculateMedianScore());
                            break;
                        case "letter":
                            System.out.println("The median letter is: " + gradebook.calculateMedianLetter());
                            break;
                    }
                    break;
                case "tab":
                    switch(commands[1]){
                        case "scores":
                            gradebook.printScores(); // Prints student table with int scores
                            break;
                        case "letters":
                            gradebook.printLetters(); // Prints student table with letter grades
                            break;
                    }
                    break;
                default:
                    System.out.println("Try again.");
            }
        }
    }
    private static boolean validateTokens(String[] arrayOfTokens){ // Checks that all 4 tokens are valid
        return checkFirstName(arrayOfTokens[0]) &&
                checkLastName(arrayOfTokens[1]) &&
                checkPID(arrayOfTokens[2]) &&
                checkGrade(arrayOfTokens[3]);
    }
    private static boolean checkFirstName(String input){ // Checks if the first name follows the rules
        if (!Character.isUpperCase(input.charAt(0)))   return false;
        char[] chars = input.toCharArray();
        for(char c : chars){
            if(!Character.isAlphabetic(c)) return false;
        }
        return true;
    }
    private static boolean checkLastName(String input){ // Checks if the last name follows the rules
        if (!Character.isUpperCase(input.charAt(0)))   return false;
        int counter = 0;
        char[] chars = input.toCharArray();
        for(char c : chars){
            if(Character.isAlphabetic(c)) continue;
            if(c == '.'){
                counter++;
            } else return false;
        }
        return counter <= 1;
    }
    private static boolean checkPID(String input){ // Checks if the Panther ID follows the rules
        if(input.length() != 7) return false; // Checks that the PantherID is 7 characters long
        if(input.charAt(0) == '0') return false; // Checks that there isn't a leading zero
        char[] chars = input.toCharArray();
        for(char c : chars){
            if(!Character.isDigit(c)) return false;
        }
        return true;
    }
    private static boolean checkGrade(String input){ // Checks if the grade follows the rules
        int grade;
        try{ // Tries to convert the second string in the array commands into an int
            grade = Integer.parseInt(input);
        }
        catch(Exception e){
            return false;
        }
        return grade >= 0 && grade <= 100; // Checks is the grade int is between 0 and 100 inclusive
    }

}
