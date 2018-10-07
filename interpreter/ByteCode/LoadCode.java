/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter.ByteCode;

import interpreter.VirtualMachine;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author drew
 */
public class LoadCode extends ByteCode {

    private int n;
    private String id;

    @Override
    public void init(ArrayList<String> args) {
        n = Integer.parseInt(args.get(0));
        id = args.get(1);
    }

    @Override
    public void execute(VirtualMachine vm) {

        vm.runStack.load(n);

        //verify if dump mode is on
        if ("ON".equals(vm.dumpMode)) {
            System.out.println("LOAD " + n + " " + id + "    <load " + id + ">");

        }
    }

    @Override
    public String toString(VirtualMachine vm) {
        return ("LOAD " + n + " " + id + "   <load " + id);
    }
}
