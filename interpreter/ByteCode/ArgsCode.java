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
public class ArgsCode extends ByteCode {

    private int n;

    @Override
    public void init(ArrayList<String> args) {
        n = Integer.parseInt(args.get(0));
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.newFrame(n);

        //verify if dump mode is on
        if ("ON".equals(vm.dumpMode)) {
            System.out.println("ARGS" + " " + n);
        }
    }

    @Override
    public String toString(VirtualMachine vm) {
        return ("ARGS " +"["+n +"]");
    }
}
