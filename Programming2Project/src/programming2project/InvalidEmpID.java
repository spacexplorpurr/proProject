/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programming2project;

/**
 *
 * @author 2181409
 */
public class InvalidEmpID extends RuntimeException {

    public InvalidEmpID() {
    }

    public InvalidEmpID(String message) {
        super(message);
    }

}
