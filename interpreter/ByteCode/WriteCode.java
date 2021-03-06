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
public class WriteCode extends ByteCode {

    @Override
    public void init(ArrayList<String> args) {

    }

    @Override
    public void execute(VirtualMachine vm) {
        System.out.println(vm.peekRunStack());

        //verify if the dumpMode is on
        if ("ON".equals(vm.dumpMode)) {
            System.out.println("WRITE");
        }
    }

    @Override
    public String toString(VirtualMachine vm) {
        return ("WRITE");
    }
}
