/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author ajay
 */
public class StudentDriver {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        Scanner scan = new Scanner(new File("studentData.txt"));
        ArrayList<Student> studentList = new ArrayList<>();
        while (scan.hasNext()) {
            int studentId = scan.nextInt();
            String lastName = scan.next();
            String firstName = scan.next();
            double gpa = scan.nextDouble();
            Student s = new Student(studentId, lastName, firstName, gpa);
            studentList.add(s);

        }
        System.out.println("****After adding to the list*****");
        printStudents(studentList);
        Collections.sort(studentList);
        System.out.println("****After sorting in natural ordering****");
        printStudents(studentList);

        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                if (s1.getLastName().compareTo(s2.getLastName()) == 0) {
                    return s1.getFirstName().compareTo(s2.getFirstName());
                } else {
                    return s1.getLastName().compareTo(s2.getLastName());
                } // end if-else
            }
        });
        
        System.out.println("****After overriding natural ordering****");
        printStudents(studentList);
        
        Collections.sort(studentList, new StudentComprator());
        System.out.println("****After overriding natural ordering in a seperate class****");
        printStudents(studentList);
    }

    private static void printStudents(ArrayList<Student> sList) {
        for (Student s : sList) {
            System.out.println(s);
        }
    }

}
