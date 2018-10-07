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
public class FalseBranchCode extends ByteCode {

    private String label;
    private int targetAddress;

    @Override
    public void init(ArrayList<String> args) {
        label = args.get(0);

    }

    @Override
    public void execute(VirtualMachine vm) {

        if (vm.runStack.pop() == 0) {
            vm.setPC(targetAddress);
        }
        //verify if the dumpMode is on
        if ("ON".equals(vm.dumpMode)) {
            System.out.println("FALSEBRANCH " + " " + label);
        }
    }

    public int getTargetAddress() {
        return targetAddress;
    }

    public void setTargetAddress(int n) {
        targetAddress = n;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString(VirtualMachine vm) {
        return ("FALSEBRANCH " + targetAddress);
    }
}
