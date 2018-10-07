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
public class PopCode extends ByteCode {

    protected int n;

    @Override
    public void init(ArrayList<String> args) {
        n = Integer.parseInt(args.get(0));
    }

    @Override
    public void execute(VirtualMachine vm) {
        //Pop top n levels of runtime stack.
        if (vm.getRunStackSize() > 0) {
            for (int i = 0; i < n; i++) {
                vm.popRunStack();
            }
        }
        //verify if  dumpMode is on
        if (!"ON".equals(vm.dumpMode)) {
        } else {
            System.out.println("POP" + " " + n);
        }
    }

    @Override
    public String toString(VirtualMachine vm) {
        return ("POP " + n);
    }
}
