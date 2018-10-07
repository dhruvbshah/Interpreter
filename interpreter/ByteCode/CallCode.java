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
public class CallCode extends ByteCode {

    protected String functionName;
    protected int targetAddress;
    protected int value;

    public CallCode() {

    }

    @Override
    public void init(ArrayList<String> args) {
        functionName = (String) args.get(0);
    }

    /**
     *
     * @param vm
     */
    @Override
    public void execute(VirtualMachine vm) {
        vm.pushReturnAd(vm.getPC());
        vm.setPC(value);
    }

    @Override
    public String toString(VirtualMachine vm) {
        //String str = ("CALL " + value + " " + functionName + "   ");
        return ("CALL" + functionName);
    }

    public String getLabel() {
        return functionName;
    }

    public void setTargetAddress(int i) {
        value = i;
    }
}
