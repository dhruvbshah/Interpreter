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
public class LabelCode extends ByteCode {

    private String label;

    @Override
    public void init(ArrayList<String> args) {
        label = args.get(0);
    }

    @Override
    public void execute(VirtualMachine vm) {

        //check if the dumpMode is on
        if ("ON".equals(vm.dumpMode)) {
            System.out.println("LABEL" + " " + label);
        }
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString(VirtualMachine vm) {
        return ("LABEL " + label);
    }
}
