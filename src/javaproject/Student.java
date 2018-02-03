package javaproject;

import java.util.Comparator;

public class Student {

    String title;//Mr, Miss, Ms, Mrs etc
    String firstName;
    String lastName;
    long id;//Student number 
    int day, month, year;// integers for storing date of birth
    String DOB;//Date of birth in dd/mm/yyyy format
    private int assignment1_Marks;//Max marks 100
    private int assignment2_Marks;//Max marks 100
    private int practicalWork;//Max marks 10
    private int finalExaminationMarks;//Max marks 100
    private int overallMarks;//weighted average, it must be between 0-100
    private String finalGrade;//final grade will be determined by value of overall marks

    public Student() {
    }

    public Student(String title, String firstName, String lastName, long id, int day, int month, int year) {
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.day = day;
        this.month = month;
        this.year = year;
        this.DOB = day + "/" + month + "/" + year;
    }

    public void setAssignment1_Marks(int assignment1_Marks) {
        this.assignment1_Marks = assignment1_Marks;
    }

    public int getAssignment1_Marks() {
        return assignment1_Marks;
    }

    public void setAssignment2_Marks(int assignment2_Marks) {
        this.assignment2_Marks = assignment2_Marks;
    }

    public int getAssignment2_Marks() {
        return assignment2_Marks;
    }

    public void setPracticalWork(int practicalWork) {
        this.practicalWork = practicalWork;
    }

    public int getPracticalWork() {
        return practicalWork;
    }

    public void setFinalExaminationMarks(int finalExaminationMarks) {
        this.finalExaminationMarks = finalExaminationMarks;
    }

    public int getFinalExaminationMarks() {
        return finalExaminationMarks;
    }

    public String getFinalGrade() {
        return finalGrade;
    }

    public void setOverallMarks() {
        this.overallMarks = (int)(((((double)assignment1_Marks + (double)assignment2_Marks) / 200) * 40) + (((double)practicalWork / 10) * 10) + (((double)finalExaminationMarks / 100) * 50));
    }

    public int getOverallMarks() {
        return overallMarks;
    }

    public void setFinalGrade() {
        if (overallMarks >= 80 && overallMarks <= 100) {
            this.finalGrade = "HD";
        } else if (overallMarks >= 70 && overallMarks < 80) {
            this.finalGrade = "D";
        } else if (overallMarks >= 60 && overallMarks < 70) {
            this.finalGrade = "C";
        } else if (overallMarks >= 50 && overallMarks < 60) {
            this.finalGrade = "P";
        } else if (overallMarks >= 0 && overallMarks < 50) {
            this.finalGrade = "N";
        }
    }

    @Override
    public String toString() {
        return "Student{ " + "Title = " + title + ", First Name = " + firstName + ", Last Name = " + lastName + ", ID = " + id + ", DOB = " + DOB + ", 1st assignment marks = " + assignment1_Marks + ", 2nd assignment marks = " + assignment2_Marks + ", Practical work marks = " + practicalWork + ", Final exam marks = " + finalExaminationMarks + ", Overall marks = " + overallMarks + ", Final Grade = " + finalGrade + '}';
    }

    public boolean equals(Student s1, Student s2) {
        if (s1.firstName.equals(s2.firstName) && s1.lastName.equals(s2.lastName) && s1.DOB.equals(s2.DOB) && s1.id == s2.id) {
            return true;
        }
        return false;
    }

    //this method will compare ArrayList<Student> objects on the basis of overallMarks
    public static Comparator<Student> overallMarksComparator = new Comparator<Student>() {
        @Override
        public int compare(Student s1, Student s2) {
            return (s2.overallMarks < s1.overallMarks ? -1
                    : (s2.overallMarks == s1.overallMarks ? 0 : 1));
        }
    };

    //this method will ArrayList<Student> objects on the basis of student surnames
    public static Comparator<Student> surnameComparator = new Comparator<Student>() {
        @Override
        public int compare(Student s1, Student s2) {
            return (int) (s1.lastName.compareTo(s2.lastName));
        }
    };
}
