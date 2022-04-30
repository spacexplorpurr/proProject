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
 * Person class
 *
 * @author Alston Alwinappar
 * @since 04/29/22
 */
public abstract class Person {

    private String fname;
    private String lname;
    private String gender;
    private int age;
    private int empID;

    public Person() {
    }

    public Person(String fname, String lname, String gender, int age, int empID) {
        this.fname = fname;
        this.lname = lname;
        this.gender = gender;
        this.age = age;
        this.empID = empID;
    }

    public abstract String category();

    public boolean equals(Person person) {
        if (this.empID != person.empID) {
            return false;
        }
        if (this.age != person.age) {
            return false;
        }
        if (!this.fname.equals(person.fname)) {
            return false;
        }
        if (!this.lname.equals(person.lname)) {
            return false;
        }
        if (!this.gender.equals(person.gender)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String str = "";

        str += String.format("First Name: %s\n", fname);
        str += String.format("Last Name: %s\n", lname);
        str += String.format("Gender: %s\n", gender);
        str += String.format("Age: %d\n", age);
        str += String.format("Employee ID: %d\n", empID);

        return str;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

}
