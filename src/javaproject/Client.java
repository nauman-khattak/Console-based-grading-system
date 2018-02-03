package javaproject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Client {

    Scanner input = new Scanner(System.in);
    ArrayList<Student> students;
    String userChoice;
    String assignment1_marks; //temp variable to store 1st assignment marks
    String assignment2_marks; //temp variable to store 2nd assignment marks
    String pracWork_marks;    //temp variable to store practical work marks
    String finalExam_marks;   //temp variable to store final examination marks
    int average_overallMarks; //average of overall marks of all students
    int equal_above_average;  //total number of students who has equal to or above the average overall marks
    int below_average;        //total number of students who has above average overall marks
    int HD, D, C, P, N;       //total number of every grade assigned i.e which grade is assigned to how many students.

    public Client() {
        operation();

    }

    public void operation() {

        do {
            menu();
            userChoice = input.nextLine();
//            input.next();
            if (userChoice.matches("[1-9]|10|11$")) {
                switch (Integer.valueOf(userChoice)) {

                    case 1:
                        System.exit(0);
                        break;

                    case 2:
                        setStudentRecords();
                        break;

                    case 3:
                        try {
                            for (int i = 0; i < students.size(); i++) {
                                System.out.println(students.get(i).toString());
                            }
                        } catch (NullPointerException e) {
                            System.out.println("First enter assignments, practical & final exam marks by choosing option 2");
                        }
                        break;

                    case 4:
                        try {
                            int sumOfOverallMarks = 0;//sum of overall marks of every student
                            for (int i = 0; i < students.size(); i++) {
                                sumOfOverallMarks += students.get(i).getOverallMarks();
                            }
                            average_overallMarks = sumOfOverallMarks / students.size();
                            System.out.println("Average overall marks for students: " + average_overallMarks);
                        } catch (NullPointerException e) {
                            System.out.println("First enter assignments, practical & final exam marks by choosing option 2");
                        }
                        break;

                    case 5:
                        try {
                            for (int i = 0; i < students.size(); i++) {
                                if (students.get(i).getOverallMarks() >= average_overallMarks) {
                                    equal_above_average++;
                                } else {
                                    below_average++;
                                }
                            }
                            System.out.println("Equal to or above average: " + equal_above_average);
                            System.out.println("Below average: " + below_average);
                        } catch (NullPointerException e) {
                            System.out.println("First enter assignments, practical & final exam marks by choosing option 2");
                        }
                        break;

                    case 6:
                        try {
                            for (int i = 0; i < students.size(); i++) {
                                if (students.get(i).getFinalGrade().equals("HD")) {
                                    HD++;
                                } else if (students.get(i).getFinalGrade().equals("D")) {
                                    D++;
                                } else if (students.get(i).getFinalGrade().equals("C")) {
                                    C++;
                                } else if (students.get(i).getFinalGrade().equals("P")) {
                                    P++;
                                } else {
                                    N++;
                                }
                            }
                            System.out.println("Total number of each grade assigned\nHD: " + HD + "\nD :" + D + "\nC :" + C + "\nP :" + P + "\nN :" + N);
                        } catch (NullPointerException e) {
                            System.out.println("First enter assignments, practical & final exam marks by choosing option 2");
                        }
                        break;

                    case 7:
                        System.out.print("Enter student ID: ");
                        String iD = "";//initial input via console in the form of string
                        long id = 0;//this variable will store the value entered via console but after conversion from string to long
                        boolean flag = false;//this will keep while loop running until user inters valid id of long data type.

                        do {
                            iD = input.nextLine();
                            try {
                                id = Long.valueOf(iD);//converting string to long
                                flag = false;
                                try {
                                    boolean status = false; //status shows wheter student is found or not
                                    for (int i = 0; i < students.size(); i++) {
                                        if (students.get(i).id == id) {
                                            System.out.println(students.get(i).toString());
                                            status = true; //true means student is found
                                        }
                                    }
                                    if (!status) {
                                        System.out.println("There is no student with id " + id);
                                    }
                                } catch (NullPointerException e) {
                                    System.out.println("First enter assignments, practical & final exam marks by choosing option 2");
                                }
                            } catch (NumberFormatException e) {
                                System.out.print("Invalid student ID(not of 'long' data type)\n"
                                        + "Do you want to enter student ID again (y/n) : ");
                                String idChoice = input.nextLine();
                                if ("y".equalsIgnoreCase(idChoice)) {
                                    System.out.print("Enter student ID: ");
                                    flag = true;
                                } else {
                                    flag = false;
                                }
                            }
                        } while (flag);
                        break;

                    case 8:
                        System.out.print("Enter first name: ");
                        String first_name = input.nextLine();
                        System.out.print("Enter last name or surname: ");
                        String last_name = input.nextLine();
                        try {
                            boolean status1 = false; //status1 wheter student is found or not
                            for (int i = 0; i < students.size(); i++) {
                                if (students.get(i).firstName.equalsIgnoreCase(first_name) && students.get(i).lastName.equalsIgnoreCase(last_name)) {
                                    System.out.println(students.get(i).toString());
                                    status1 = true; //true means student is found
                                }
                            }
                            if (!status1) {
                                System.out.println("There is no student having first name " + first_name + " and last surname " + last_name);
                            }
                        } catch (NullPointerException e) {
                            System.out.println("Students array is empty.\nFill the array by visiting step 2 & enter required credentials there.");
                        }
                        break;

                    case 9:
                        try {
                            sortbyOverallMarks();
                            System.out.println("Highest overall marks : " + students.get(0).getOverallMarks());
                            System.out.println("Student name : " + students.get(0).firstName + " " + students.get(0).lastName);

                            System.out.println("\nSecond highest overall marks : " + students.get(1).getOverallMarks());
                            System.out.println("Student name : " + students.get(1).firstName + " " + students.get(1).lastName);
                        } catch (NullPointerException e) {
                            System.out.println("Sorry! We are unable to display higest & second highest overall marks.\n"
                                    + "The reason is students array is empty.\nFill the array by visiting step 2 & enter required credentials there.");
                        }
                        break;

                    case 10:
                        try {
                            quickSortAlgo();
                            for (int i = 0; i < students.size(); i++) {
                                System.out.println(students.get(i).toString());
                            }
                        } catch (NullPointerException e) {
                            System.out.println("Students array is empty.\nFill the array by visiting step 2 first.");
                        }
                        break;

                    case 11:
                        try {
                            sortbySurname();// this will sort ArrayList student into ascending order of student surnames
                            for (int i = 0; i < students.size(); i++) {
                                System.out.println(students.get(i));
                            }
                        } catch (NullPointerException e) {
                            System.out.println("Students array is empty.\nFill the array by visiting step 2 first.");
                        }

                        break;
                }
            } else {
                System.out.println("Wrong input, please enter value between [1-11]");
            }
        } while (true);
    }

    public void menu() {
        System.out.print("\n****************************Choose an Option*****************************\n"
                + "* 1) Quit\t\t\t\t\t\t\t\t*\n"
                + "* 2) Add (to the array) all information about a student\t\t\t*\n"
                + "* 3) View every student credentials\t\t\t\t\t*\n"
                + "* 4) View average overall marks for students\t\t\t\t*\n"
                + "* 5) View total number of above & below average overall marks students  *\n"
                + "* 6) View final grades awarded\t\t\t\t\t\t*\n"
                + "* 7) View student credentials using student ID\t\t\t\t*\n"
                + "* 8) View student credentials using student first name & surname\t*\n"
                + "* 9) View top 2 students with highest overall marks\t\t\t*\n"
                + "* 10) Sort students ascendly by student ID's\t\t\t\t*\n"
                + "* 11) Sort stuents ascendly by surname using different algorithm\t*\n"
                + "*************************************************************************\n\n>> ");
    }

    public void setStudentRecords() {
        //We are doing it for 6 students and we are gaiving both hard code and console based input
        //Title, First & Last name, ID and DOB are hardcoded while assignments, practical marks and final exam marks will user enter at runtime.
        //This method can be customized further in case if user wants totally hard coded input or totally console based input.
        students = new ArrayList<>();
        Student s1 = new Student("Mr", "Muhammad", "Nauman", 124, 20, 07, 1994);
        Student s2 = new Student("Mr", "Arham", "zaneer", 646, 12, 10, 1995);
        Student s3 = new Student("Miss", "Fatima", "Awan", 784, 31, 01, 1993);
        Student s4 = new Student("Ms", "Afsah Ur Rehman", "Awan", 214, 28, 02, 1996);
        Student s5 = new Student("Miss", "Hina Rabbani", "Khar", 365, 25, 3, 1997);
        Student s6 = new Student("Mr", "Imran", "Khan", 185, 14, 06, 1992);

        for (int i = 1; i <= 6; i++) {
            switch (i) {
                case 1:
                    students.add(s1);
                    break;
                case 2:
                    students.add(s2);
                    break;
                case 3:
                    students.add(s3);
                    break;
                case 4:
                    students.add(s4);
                    break;
                case 5:
                    students.add(s5);
                    break;
                case 6:
                    students.add(s6);
                    break;
            }
            Student st = students.get(i - 1);
            System.out.println("\nPlease enter details of " + st.title + " " + st.firstName + " " + st.lastName);

            //setting 1st assignment marks between range [0-100]
            System.out.print("Enter 1st Assignment marks[0-100] : ");
            do {
                assignment1_marks = input.nextLine();
                if (assignment1_marks.matches("^[0-9][0-9]?$|^100$")) {
                    st.setAssignment1_Marks(Integer.valueOf(assignment1_marks));
                } else {
                    System.out.print("Wrong input, please enter again between [0-100] : ");
                }
            } while (!assignment1_marks.matches("^[0-9][0-9]?$|^100$"));//while range isn't between [0-100]

            //setting 2nd assignment marks between range [0-100]
            System.out.print("Enter 2nd Assignment marks[0-100] : ");
            do {
                assignment2_marks = input.nextLine();
                if (assignment2_marks.matches("^[0-9][0-9]?$|^100$")) {
                    st.setAssignment2_Marks(Integer.valueOf(assignment2_marks));
                } else {
                    System.out.print("Wrong input, please enter again between [0-100] : ");
                }
            } while (!assignment2_marks.matches("^[0-9][0-9]?$|^100$"));//while range isn't between [0-100]

            //setting practical work marks between range [0-10]
            System.out.print("Enter practical work marks[0-10] : ");
            do {
                pracWork_marks = input.nextLine();
                if (pracWork_marks.matches("[0-9]$|^10$")) {
                    st.setPracticalWork(Integer.valueOf(pracWork_marks));
                } else {
                    System.out.print("Wrong input, please enter again between [0-10] : ");
                }
            } while (!pracWork_marks.matches("[0-9]$|^10$"));//while range isn't between [0-10]

            //setting final exam marks between range [0-100]
            System.out.print("Enter final examination marks[0-100] : ");
            do {
                finalExam_marks = input.nextLine();
                if (finalExam_marks.matches("^[0-9][0-9]?$|^100$")) {
                    st.setFinalExaminationMarks(Integer.valueOf(finalExam_marks));
                } else {
                    System.out.print("Wrong input, please enter again between [0-100] : ");
                }
            } while (!finalExam_marks.matches("^[0-9][0-9]?$|^100$")); //while range isn't between [0-100]

            st.setOverallMarks();
            st.setFinalGrade();
        }
    }

    public static void main(String[] args) {
        new Client();
    }

    public ArrayList<Student> sortbyOverallMarks() {
        Collections.sort(students, Student.overallMarksComparator);// this will sort ArrayList<Students> students in ascending order of student overall marks, then we well pick the last two students as the highest and 2nd highest overall marks candidates
        return students;
    }

    public ArrayList<Student> sortbySurname() {
        Collections.sort(students, Student.surnameComparator);//This will sort ArrayList<Studetns> students in ascending order of students surnames
        return students;
    }
//##################################################################################################//
    //Below portion is quick sort algorithm. Its extremely fast sorting algo which is used to sort arrays having tens of thousands of elements.
    //In this algo array is devided in two equal parts by pivot and every part is repeatedly sorted
    //We used this algo only for part 10 of our program because we have to use different sorting algo than the part 11 as stated in assignment
    //you can view more info about quick sort algo on google

    public void quickSortAlgo() {
        int left = 0;//start index of our arrayList
        int right = students.size() - 1;//Last index of our arrayList
        quickSort(students, left, right);
    }

    public void quickSort(ArrayList<Student> studentsList, int left, int right) {
        if (studentsList.size() == 0) {
            return;
        }
        if (left >= right) {
            return;
        }
        long pivot = studentsList.get(left + (right - left) / 2).id;//pivot is the middle value. i.e ID of student object which lies in the centre of ArrayList
        int i = left, j = right;
        while (i < j) {
            while (studentsList.get(i).id < pivot) {
                i++;
            }
            while (studentsList.get(j).id > pivot) {
                j--;
            }
            if (i <= j) {
                swap(i++, j--);
            }
        }
        if (left < j) {
            quickSort(studentsList, left, j);
        }
        if (right > i) {
            quickSort(studentsList, i, right);
        }
    }

    public void swap(int x, int y) {
        Student temp = students.get(x); //this variable will store Student object
        students.set(x, students.get(y)); // replacing the object at index x with object at index y
        students.set(y, temp); //replacing the object at index y with previous value of x
    }
}
