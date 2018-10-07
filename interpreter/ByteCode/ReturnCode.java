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
public class ReturnCode extends ByteCode {

    protected String functionName;
    protected int returnValue;

    @Override
    public void init(ArrayList<String> args) {
        if (args.size() > 0) {
            functionName = args.get(0);
        } else {
            functionName = "";
        }
    }

    @Override
    public void execute(VirtualMachine vm) {

        vm.pc = vm.returnAddrs.pop();
        vm.popRunStackFrame();
        returnValue = vm.peekRunStack();

        //verify if dumpMode is on
        if ("ON".equals(vm.dumpMode)) {
            int n = functionName.indexOf("<");
            String temp;
            if (n < 0) {
                temp = functionName;
            } else {
                temp = functionName.substring(0, n);
            }
            System.out.println("RETURN " + functionName + "    exit " + temp + ": " + returnValue);
        }

    }

    @Override
    public String toString(VirtualMachine vm) {
        //String str = ("RETURN " + functionName + "   exit ");
        return "RETURN" + functionName;
    }
}
