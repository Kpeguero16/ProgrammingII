/*
-.- .... .- .-.. .. .-..    .--. . --. ..- . .-. ---
*/
package util;

public class Student {
    private String firstName; // Instance field holding student's first name
    private String lastName; // Instance field holding student's last name
    private int pid; // Instance field holding student's panther id
    private Grade grade; // Instance field holding student's grade object

    public Student(String firstName, String lastName, int pid, int score) { // Initializes Student object
        this.firstName = firstName;
        this.lastName = lastName;
        this.pid = pid;
        this.grade = new Grade(score);
    }

    public String getFirstName() { // Returns student's first name
        return firstName;
    }
    public String getLastName() { // Returns student's last name
        return lastName;
    }
    public int getPid() { // Returns student's panther ID
        return pid;
    }
    public Grade getGrade() { // Returns student's Grade object
        return grade;
    }

    public void setGrade(Grade grade) { // Sets the student's grade object
        this.grade = grade;
    }
}
