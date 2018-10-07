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
public class BopCode extends ByteCode {

    private String op;

    @Override
    public void init(ArrayList<String> args) {
        op = args.get(0);
    }

    @Override
    public void execute(VirtualMachine vm) {
        //pop operands
        int firstOperation = vm.popRunStack();
        int secondOperation = vm.popRunStack();

        //do operations
        switch (op) {
            case "+":
                vm.pushRunStack(secondOperation + firstOperation);
                break;
            case "-":
                vm.pushRunStack(secondOperation - firstOperation);
                break;
            case "/":
                vm.pushRunStack(secondOperation / firstOperation);
                break;
            case "*":
                vm.pushRunStack(secondOperation * firstOperation);
                break;
            case "==":
                if (secondOperation == firstOperation) {
                    vm.pushRunStack(1);
                } else {
                    vm.pushRunStack(0);
                }
                break;
            case "!=":
                if (secondOperation != firstOperation) {
                    vm.pushRunStack(1);
                } else {
                    vm.pushRunStack(0);
                }
                break;
            case "<=":
                if (secondOperation <= firstOperation) {
                    vm.pushRunStack(1);
                } else {
                    vm.pushRunStack(0);
                }
                break;
            case ">":
                if (secondOperation > firstOperation) {
                    vm.pushRunStack(1);
                } else {
                    vm.pushRunStack(0);
                }
                break;
            case ">=":
                if (secondOperation >= firstOperation) {
                    vm.pushRunStack(1);
                } else {
                    vm.pushRunStack(0);
                }
                break;
            case "<":
                if (secondOperation < firstOperation) {
                    vm.pushRunStack(1);
                } else {
                    vm.pushRunStack(0);
                }
                break;
            case "|":
                if (secondOperation == 0 && firstOperation == 0) {
                } else {
                    vm.pushRunStack(1);
                }
                break;
            case "&":
                if (secondOperation == 1 && firstOperation == 1) {
                    vm.pushRunStack(1);
                }
                break;
        }
    }

    @Override
    public String toString(VirtualMachine vm) {
        return ("BOP " + op);
    }
}
