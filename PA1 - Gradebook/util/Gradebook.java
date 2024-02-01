/*
-.- .... .- .-.. .. .-..    .--. . --. ..- . .-. ---
*/
package util;

import java.util.*;

public class Gradebook {
    private ArrayList<Student> listOfStudents;

	public Gradebook() { // Initializes gradebook object
		listOfStudents = new ArrayList<Student>();
	}

	public Gradebook(ArrayList<Student> listOfStudents) {
		this.listOfStudents = listOfStudents;
	}

	public ArrayList<Student> getListOfStudents() { // Returns list of students
		return listOfStudents;
	}

	public Student findStudent(int PID){ // Returns Student with specific Panther ID
		for(Student s : listOfStudents){
			if (s.getPid() == PID){
				return s;
			}
		}
        return null;
    }
	public double calculateAverageScore() { // Returns the Average Score
	double sum = 0;
	for(Student s: listOfStudents)
	    sum += s.getGrade().getScore();
	return sum / listOfStudents.size();
    }
	public Grade calculateAverageLetter(){ // Calculates the Average Letter
		return new Grade((int)calculateAverageScore());
	}
    public float calculateMedianScore() { // Returns the Median Score
	int i = 0, n = listOfStudents.size();
	int[] scores = new int[n];
	for(Student s: listOfStudents)
	    scores[i++] = s.getGrade().getScore();
	Arrays.sort(scores);
	if (n % 2 == 0)
	    return (scores[n / 2] + scores[n / 2 - 1]) / 2.0f;
	else
	    return scores[n / 2];
    }
	public Grade calculateMedianLetter(){ // Calculates the Median Letter
		return new Grade((int)calculateMedianScore());
	}
	public int calculateMinScore(){ // Calculates the Minimum Score
		int minScore = Integer.MAX_VALUE;
		for(Student s : listOfStudents){
			if(s.getGrade().getScore() < minScore){
				minScore = s.getGrade().getScore();
			}
		}
		return minScore;
	}
	public int calculateMaxScore(){ // Calculates the Maximum score
		int maxScore = Integer.MIN_VALUE;
		for(Student s : listOfStudents){
			if(s.getGrade().getScore() > maxScore){
				maxScore = s.getGrade().getScore();
			}
		}
		return maxScore;
	}
	public Grade calculateMinLetter(){ // Calculates the Minimum Letter
		return(new Grade(calculateMinScore()));
	}
	public Grade calculateMaxLetter(){ // Calculates the Maximum Letter
		return(new Grade(calculateMaxScore()));
	}
    public void printScores(){ // Prints out a 4 column table with the student's information
		System.out.println("First Name\tLast Name\tPanther ID\tLetter-Grade");
		for(Student s : listOfStudents){
			System.out.println(s.getFirstName()
			+ "\t" + s.getLastName()
			+ "\t" + s.getPid()
			+ "\t" + s.getGrade().getScore());
		}
	}
	public void printLetters(){ // Prints out a 4 column table with the student's information
		for(Student s : listOfStudents){
			System.out.println(s.getFirstName()
					+ "\t" + s.getLastName()
					+ "\t" + s.getPid()
					+ "\t" + s.getGrade().getLetterGrade());
		}
	}
}
