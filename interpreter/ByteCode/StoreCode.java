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
public class StoreCode extends ByteCode {

    private int n;//offset
    private String id;
    private int value;

    @Override
    public void init(ArrayList<String> args) {
        n = Integer.parseInt(args.get(0));
        id = args.get(1);
    }

    @Override
    public void execute(VirtualMachine vm) {

        value = vm.peekRunStack();
        vm.storeRunStack(n);

        //verify if the dumpMode is on
        if ("ON".equals(vm.dumpMode)) {
            System.out.println("STORE " + n + " " + id + "    " + id + " = " + value);
        }
    }

    @Override
    public String toString(VirtualMachine vm) {
        int top = vm.peekRunStack();
        return ("STORE " + n + " " + id + "   " + id + "=" + top);
    }
}
