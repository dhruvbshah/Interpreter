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
public class DumpCode extends ByteCode {

    private String dumpState;

    @Override
    public void init(ArrayList<String> args) {
        dumpState = args.get(0);
    }

    @Override
    public void execute(VirtualMachine vm) {
        //sets the dumpMode
        vm.dumpMode = dumpState;

    }

    @Override
    public String toString(VirtualMachine vm) {
        return ("DUMP" + dumpState);
    }
}
