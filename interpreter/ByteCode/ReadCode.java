/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter.ByteCode;

import interpreter.VirtualMachine;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author drew
 */
public class ReadCode extends ByteCode {

    @Override
    public void init(ArrayList<String> args) {

    }

    @Override
    public void execute(VirtualMachine vm) {
        //ask the user to enter an integer
        System.out.print("Please input an integer: ");

        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String line = in.readLine();
            vm.pushRunStack(Integer.parseInt(line));
        } catch (java.io.IOException e) {
        }

        //verify if dump mode is on
        if ("ON".equals(vm.dumpMode)) {
            System.out.println("READ");
        }
    }

    @Override
    public String toString(VirtualMachine vm) {
        return ("READ");
    }
}
