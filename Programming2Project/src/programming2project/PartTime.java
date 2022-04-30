/*
 * The MIT License
 *
 * Copyright 2022 hansika.
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
 *
 * @author hansika
 */
public class PartTime extends Teacher implements Payroll {

    private int workload;// its hoursWorked

    public PartTime(int workload, String fname, String lname, String gender, int age, int empID, String specialty, String degree, int exp, boolean dean) {
        super(fname, lname, gender, age, empID, specialty, degree, exp, dean);
        this.workload = workload;
    }

    @Override
    public String toString() {
        super.toString();
        return "PartTime{" + "workload=" + workload + '}';
    }

    public int getWorkload() {
        return workload;
    }

    public void setWorkload(int workload) {
        this.workload = workload;
    }

    @Override
    public double ComputePayRoll() {

        double degreeRate = 0;
        switch (getDegree()) {

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

        double salary = (workload * degreeRate * 2) * 0.76;

        return salary;
    }

}
