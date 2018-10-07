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
public class LitCode extends ByteCode {

    protected int n;
    protected String id;

    @Override
    public void init(ArrayList<String> args) {
        n = Integer.parseInt(args.get(0));
        if (args.size() > 1) {
            id = args.get(1);
        } else {
            id = "";
        }
    }

    @Override
    public void execute(VirtualMachine vm) {

        if ("".equals(id)) {
            vm.pushRunStack(n);
        } else {
            vm.pushRunStack(0);
        }

        //verify if dumpMode is on
        if ("ON".equals(vm.dumpMode)) {
            String output = "LIT " + n + " " + id;
            if (!id.equals("")) {
                output = output + "    int " + id;
            }
            System.out.println(output);
        }

    }

    @Override
    public String toString(VirtualMachine vm) {
        return "LIT " + n + " " + id;
    }
}
