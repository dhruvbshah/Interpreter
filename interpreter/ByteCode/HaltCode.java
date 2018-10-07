/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter.ByteCode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

/**
 *
 * @author drew
 */
public class HaltCode extends ByteCode {

    @Override
    public void init(ArrayList<String> args) {

    }

    @Override
    public void execute(VirtualMachine vm) {
        //terminate the program
        vm.isRunning = false;

        //check if the dumpMode is on
        if ("ON".equals(vm.dumpMode)) {
            System.out.println("HALT");
        }
    }

    @Override
    public String toString(VirtualMachine vm) {
        return ("HALT");
    }
}
