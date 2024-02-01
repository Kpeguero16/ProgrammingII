/*
-.- .... .- .-.. .. .-..    .--. . --. ..- . .-. ---
*/
package util;

public class Grade {
    private int score; // Instance field holding Student's score 1-100
    private String letterGrade; // Instance field holding Student's letter grade A-F

    public Grade(int score){ // Initializes a grade object
        this.score = score;
        this.letterGrade = convertScoreToLetter(score);
    }

    public int getScore() { // Returns score 1-100
        return score;
    }
    public String getLetterGrade() { // Returns letter grade A-F
        return letterGrade;
    }

    public static String convertScoreToLetter(double score){ // Converts student's score (1-100) to a letter grade (A-F)
        if(score >= 95){
            return "A";
        }
        else if(score >= 90){
            return "A-";
        }
        else if(score >= 87){
            return "B+";
        }
        else if (score >= 83){
            return "B";
        }
        else if(score >= 80){
            return "B-";
        }
        else if (score >= 77){
            return "C+";
        }
        else if(score >= 70){
            return "C";
        }
        else if(score >=60){
            return "D";
        }
        else return "F";
    }

    @Override
    public String toString() {
        return letterGrade;
    }
}