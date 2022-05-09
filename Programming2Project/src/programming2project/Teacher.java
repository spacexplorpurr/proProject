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

import java.util.Objects;

/**
 * Teacher class
 *
 * @author Alston Alwinappar
 * @since 04/29/22
 */
public class Teacher extends Person implements Payroll {

    private String specialty;
    private String degree;
    private int exp;
// changed type from Teacher to boolean, it indicates if the teacher is dean or not
    private boolean dean;

    public Teacher(String fname, String lname, String gender, int age, int empID,
            String specialty, String degree, int exp, boolean dean) {
        super(fname, lname, gender, age, empID);
        this.specialty = specialty;
        this.degree = degree;
        this.exp = exp;
        this.dean = dean;
    }

    public boolean equals(Teacher teacher) {
        if (!super.equals(teacher)) {
            return false;
        } else if (this.dean != teacher.dean) {
            return false;
        } else if (!this.specialty.equals(teacher.specialty)) {
            return false;
        } else if (!this.degree.equals(teacher.degree)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String str = "";

        str += super.toString();
        str += String.format("Specialty: %s\n", specialty);
        str += String.format("Degree: %s\n", degree);
        str += String.format("Years of Experience: %d\n", exp);
//        str += String.format("Is the teacher a dean: %d\n", dean); 
//line above is commented, it causes file reading error because it's a boolean type value
        return str;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }
// commented this cause I switched dean type from Teacher to boolean and 
// everything related causes error
//    public Teacher getDean() {
//        return dean;
//    }
//
//    public void setDean(Teacher dean) {
//        this.dean = dean;
//    }

    /**
     * This method indicates which category the person is in: Staff or Teacher
     *
     * @return category of the person: Staff or Teacher
     */
    @Override
    public String category() {
        String category = String.format("%s %s is a teacher.", super.getFname(),
                super.getLname());

        return category;
    }

    /**
     * This method calculates the payroll of the teacher according to their
     * degree
     *
     * @return salary which is there total payroll
     */
    @Override
    public double ComputePayRoll() {

        double degreeRate = 0;
        switch (degree) {

            case "PhD":
                degreeRate = 112;
                break;

            case "Master":
                degreeRate = 82;
                break;

            case "Bachelor":
                degreeRate = 42;
                break;

            default:
                return 0;

        }

        double salary = (32 * degreeRate * 2) * 0.85;

        return salary;
    }

}
