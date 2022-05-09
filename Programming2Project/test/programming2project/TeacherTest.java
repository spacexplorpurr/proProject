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

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hansika
 */
public class TeacherTest {

    public TeacherTest() {
    }

    /**
     * Test of category method, of class Teacher.
     */
    @Test
    public void testCategory() {
        System.out.println("category");
        Teacher instance = new Teacher("Nia", "Smith", "Female", 18, 04, "Science", "Master", 2, false);
        String expResult = "Nia Smith is a teacher.";
        String result = instance.category();
        assertEquals(expResult, result);
    }

    /**
     * Test of ComputePayRoll method, of class Teacher.
     */
    @Test
    public void testComputePayRoll() {
        System.out.println("ComputePayRoll");
        Teacher instance = new Teacher("Nia", "Smith", "Female", 18, 04, "Science", "Master", 2, false);
        double expResult = 4460.8;
        double result = instance.ComputePayRoll();
        assertEquals(expResult, result, 0.0);
    }

}
