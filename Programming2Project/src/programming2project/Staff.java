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

/**
 * Staff class
 *
 * @author Alston Alwinappar
 * @since 04/29/22
 */
public class Staff extends Person implements Payroll {

    private String duty;
    private int workload;// weekly working hour, cannot exceed 40

    public Staff() {
        super();
    }

    public Staff(String fname, String lname, String gender, int age, int empID,
            String duty, int workload) {
        super(fname, lname, gender, age, empID);
        this.duty = duty;
        if (workload > 40 || workload < 0) {
//this checks if workload is smaller than 0 or exceeds 40 hours
            throw new InvalidWorkload("Invalid Workload" + workload);
        } else {
            this.workload = workload;
        }
    }

    public boolean equals(Staff staff) {
        if (!super.equals(staff)) {
            return false;
        } else if (!this.duty.equals(staff.duty)) {
            return false;
        } else if (this.workload != staff.workload) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String str = "";

        str += super.toString();
        str += String.format("Duty: %s\n", duty);
        str += String.format("Workload: %d\n", workload);

        return str;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public int getWorkload() {
        return workload;
    }

    public void setWorkload(int workload) {
        if (workload > 40 || workload < 0) {
//this checks if workload is smaller than 0 or exceeds 40 hours
            throw new InvalidWorkload("Invalid Workload" + workload);
        } else {
            this.workload = workload;
        }
    }

    /**
     * This method indicates which category the person is in: Staff or Teacher
     *
     * @return category of the person: Staff or Teacher
     */
    @Override
    public String category() {
        String category = String.format("%s %s is a staff member.", super.getFname(),
                super.getLname());

        return category;
    }

    /**
     * This method calculates the payroll of the staff according to their
     * workload
     *
     * @return salary which is there total payroll
     */
    @Override
    public double ComputePayRoll() {

        double salary = (workload * 32 * 2) * 0.75;

        return salary;
    }

}
