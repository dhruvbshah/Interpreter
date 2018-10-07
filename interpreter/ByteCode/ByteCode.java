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
public abstract class ByteCode {

    // initializes bytecode
    public abstract void init(ArrayList<String> args);

    //executes the virtual machine
    public abstract void execute(VirtualMachine vm);

    public abstract String toString(VirtualMachine vm);
}
