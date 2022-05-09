/*
 * The MIT License
 *
 * Copyright 2022 alston.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package programming2project;

import java.io.File;
//import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Test class
 *
 * @author Alston Alwinappar
 * @since 04/29/22
 */
public class Programming2Project {

    public static void main(String[] args) {
//                Deliverable 2 (Implementation)
//For this deliverable, your repository should contain the following files:
//• Completed UML Class Diagrams for all classes and interfaces with their relationship
//• The implementation of all required features (the source code)
//• A snapshot of output demonstrating the functionality of the application whether correct
//or incorrect, complete, or incomplete.
//• Graphic elements to display and input data

// Staff
        ArrayList<Staff> staffs = new ArrayList<>();
        staffs = readStaffData("ListOfStaffs.txt");//readStaffData method returns an arraylist

        Staff s2 = new Staff("Chloe", "Bourgeois", "female", 26, 06, "Cook", 15);

//        staffs.add(s2);// adding new Staff in array list
//        System.out.println("List Of Staffs: ");
//        System.out.println();
//        for (Staff s : staffs) {// this for loop prints out all the staffs
//            System.out.println(s);
//        }
// this method creates output file with new staffs included
//        writeStaffFile("ListOfStaffs.txt", staffs);// this method creates output file with new staffs included
//        
// the codes below test codes in staff method
//        System.out.printf("%.2f\n", staffs.get(0).ComputePayRoll());
        System.out.printf("%s\n", staffs.get(0).category());
//        System.out.printf("%s\n", staffs.get(0));
//        System.out.println(staffs.get(0) == staffs.get(0));
//        System.out.println(staffs.get(0) == staffs.get(1));
// Teacher
        ArrayList<Teacher> teachers = new ArrayList<>();
        //readTeacherData method returns an arraylist
        teachers = readTeacherData("ListOfTeachers.txt");

        Teacher t2 = new Teacher("Mari", "Agreste", "Female", 25, 7, "Poetry", "Bachelor",
                3, false);

        teachers.add(t2);//adding new Teacher in array list
//
//        System.out.println("List Of Teachers: ");
//        System.out.println();
//        for (Teacher t : teachers) {// this for loop prints out all the staffs
//            System.out.println(t);
//        }

// this method creates output file with new teachers included
        writeTeacherFile("ListOfTeachers.txt", teachers);
        // the codes below test codes in teacher method
//        System.out.printf("%.2f\n", teachers.get(0).ComputePayRoll());
        System.out.println("");
        System.out.printf("%s's payroll is %.2f\n", teachers.get(0).getFname(),
                teachers.get(1).ComputePayRoll());
//        System.out.printf("%.2f\n", teachers.get(2).ComputePayRoll());
//        System.out.printf("%s\n", teachers.get(2).category());
//        System.out.printf("%s\n", teachers.get(2));

// the 2 lines below test equal method
//        System.out.println(teachers.get(0) == teachers.get(0));
//        System.out.println(teachers.get(0) == teachers.get(1));
        Department d = new Department("Science", 11, teachers, staffs);
        System.out.println("");
        System.out.println(d);// testing toString method of department
//        System.out.println(d.getTeachers());//test if it prints all teachers
//        System.out.println(d.getStaffs());
//        d.addStaff(s2);// testing if it adds a new staff properly
        try {
// line below tests if the method catches exception when you add staff who's 
// already in that department
            d.addStaff(staffs.get(2));
//            d.addStaff(s2);// testing if it causes exception error if you add new staff
        } catch (InvalidEmpID e) {
            System.out.println(e.getMessage());
        }

//        d.removeStaff(staffs.get(0));//testing if it removes staff
//        System.out.println(d.getStaffs());
//        System.out.println(staffs.get(0));
//        try {
// line below tests if the method catches exception when you add staff who's 
// already in that department
//            d.addTeacher(teachers.get(1));
//            d.addTeacher(t2);// testing if it causes exception error if you add new staff
//        } catch (InvalidEmpID e) {
//            System.out.println(e.getMessage());
//        }
        System.out.println("");
        d.removeTeacher(teachers.get(0));
        System.out.println(d.getTeachers());
    }

    /**
     * This method creates a new file. It writes data based on the original file
     * and array list of staffs that's provided
     *
     * @param path the original file
     * @param staffs array list of all staffs
     */
    public static void writeStaffFile(String path, ArrayList<Staff> staffs) {
        File listOfStaffs = new File(path);

        try ( Scanner input = new Scanner(listOfStaffs)) {
//the line below creates an output file of all the staffs(including those added additionally)
            File newListOfStaffs = new File("NewListOfStaffs.txt");

            FileWriter fw = new FileWriter(newListOfStaffs);

            try ( PrintWriter pw = new PrintWriter(fw)) {
                for (Staff staff : staffs) {//goes through all the staff in the array list
                    //all pw.write codes write data of each staff in the new file
                    pw.write(staff.getFname() + " ");//gets the name of the staff
                    pw.write(staff.getLname() + " ");
                    pw.write(staff.getGender() + " ");
                    pw.write(staff.getAge() + " ");
                    pw.write(staff.getEmpID() + " ");
                    pw.write(staff.getDuty() + " ");
                    pw.write(staff.getWorkload() + " ");
                    pw.write("\n");
                }
                pw.close();
            }
        } catch (IOException e) {//catches exceptions if something went wrong when reading
            System.out.printf("Something went wrong with the input or output file.");
        }
    }

    /**
     * This method creates a new file. It writes data based on the original file
     * and array list of teachers that's provided
     *
     * @param path the original file
     * @param teachers array list of all teachers
     */
    public static void writeTeacherFile(String path, ArrayList<Teacher> teachers) {
        File listOfTeachers = new File(path);

        try ( Scanner input = new Scanner(listOfTeachers)) {
//the line below creates an output file of all the teachers(including those added additionally)
            File newListOfTeachers = new File("NewListOfTeachers.txt");

            FileWriter fw = new FileWriter(newListOfTeachers);

            try ( PrintWriter pw = new PrintWriter(fw)) {
                //for loop below goes through all the teachers in the array list
                for (Teacher teacher : teachers) {
                    //all pw.write codes write data of each teachers in the new file
                    pw.write(teacher.getFname() + " ");
                    pw.write(teacher.getLname() + " ");
                    pw.write(teacher.getGender() + " ");
                    pw.write(teacher.getAge() + " ");
                    pw.write(teacher.getEmpID() + " ");
                    pw.write(teacher.getSpecialty() + " ");
                    pw.write(teacher.getDegree() + " ");
                    pw.write(teacher.getExp() + " ");
                    pw.write("\n");
                }
                pw.close();
            }
        } catch (IOException e) {//catches exceptions if something went wrong when reading
            System.out.printf("Something went wrong with the input or output file.");
        }
    }

    /**
     * This method reads text files(list of staffs). It gets the data from a
     * file and puts it in an array list of staffs.
     *
     * @param path the file name
     * @return an array list of staffs
     */
    public static ArrayList<Staff> readStaffData(String path) {
        File listOfStaffs = new File(path);

        ArrayList<Staff> staffs = new ArrayList<>();

        try ( Scanner input = new Scanner(listOfStaffs)) {

            while (input.hasNext()) {
                String row = input.nextLine();//stores a line of data as a string

                //the line below, seperates the data in a line and stores it in an array
                String[] staffInfo = row.split(" ");

                // the codes starting from here stores each data in a seperate variable
                // and changes the type of the data accordingly
                String fname = staffInfo[0];
                String lname = staffInfo[1];
                String gender = staffInfo[2];
                int age;
                int empID;
                String duty = staffInfo[5];
                int workload;

                try {
                    age = Integer.parseInt(staffInfo[3]);
                } catch (NumberFormatException e) {
                    age = -1;
                }
                try {
                    empID = Integer.parseInt(staffInfo[4]);
                } catch (NumberFormatException e) {
                    empID = -1;
                }
                try {
                    workload = Integer.parseInt(staffInfo[6]);
                } catch (NumberFormatException e) {
                    workload = -1;
                }// storing the data in seperate variables ends here

                // the code below creates a staff based on the info we extracted 
                // from the file that was read
                Staff s = new Staff(fname, lname, gender, age, empID, duty, workload);
                staffs.add(s);
//line above stores a staff in the array list created at the beginning of this method
            }
        } catch (IOException e) {//catches exceptions if something went wrong when reading
            System.out.printf("Something went wrong with the input or output file.");
        }

        return staffs;
    }

    /**
     * This method reads text files(list of teachers). It gets the data from it
     * and puts it in an array list of teachers.
     *
     * @param path the file name
     * @return an array list of teachers
     */
    public static ArrayList<Teacher> readTeacherData(String path) {
        File listOfTeachers = new File(path);

        ArrayList<Teacher> teachers = new ArrayList<>();

        try ( Scanner input = new Scanner(listOfTeachers)) {
            while (input.hasNext()) {
                String row = input.nextLine();

                String[] teacherInfo = row.split(" ");
                String fname = teacherInfo[0];
                String lname = teacherInfo[1];
                String gender = teacherInfo[2];
                int age;
                int empID;
                String specialty = teacherInfo[5];
                String degree = teacherInfo[6];
                int exp;
                boolean dean = Boolean.parseBoolean(teacherInfo[8]);
                try {
                    age = Integer.parseInt(teacherInfo[3]);
                } catch (NumberFormatException e) {
                    age = -1;
                }
                try {
                    empID = Integer.parseInt(teacherInfo[4]);
                } catch (NumberFormatException e) {
                    empID = -1;
                }
                try {
                    exp = Integer.parseInt(teacherInfo[7]);
                } catch (NumberFormatException e) {
                    exp = -1;
                }

                Teacher teacher = new Teacher(fname, lname, gender, age, empID, specialty, degree, exp, dean);
                teachers.add(teacher);

                }

            }catch (IOException e) {
            System.out.println(e);
        }

            return teachers;
        }

    }
