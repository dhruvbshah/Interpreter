package interpreter;

import interpreter.ByteCode.ByteCode;
import interpreter.ByteCode.DumpCode;
import java.util.List;
import java.util.Stack;

public class VirtualMachine {

    public RunTimeStack runStack;
    public Stack<Integer> returnAddrs;
    private final Program program;
    public int pc;
    public boolean isRunning;
    public Object dumpMode = "OFF";
    int dump;

    protected VirtualMachine(Program program) {
        this.program = program;
    }

    public void executeProgram() {

        pc = 0;
        runStack = new RunTimeStack();
        returnAddrs = new Stack<>();
        isRunning = true;
        //dumpMode = "OFF";

        while (isRunning) {
            ByteCode code = program.getCode(pc);
            System.out.println(code.toString(this));
            code.execute(this);
            if ("ON".equals(dumpMode) && !(code instanceof DumpCode)) {
                runStack.dump();
            }
            pc++;
        }

        /*while (isRunning){
            if(dumpMode.equals("ON")){
                dump = 1;
            }
            ByteCode code = program.getCode(pc);
            System.out.println(code.toString(this));
            code.execute(this);
        }*/
    }

    public void setPC(int i) {
        pc = i;
    }

    public int getPC() {
        return pc;
    }

    public void newFrame(int i) {
        runStack.newFrameAt(i);
    }

    public void popRunStackFrame() {
        runStack.popFrame();
    }

    public int popRunStack() {
        return runStack.pop();
    }

    public int peekRunStack() {
        return runStack.peek();
    }

    public void pushRunStack(int i) {
        runStack.push(i);
    }

    public void loadRunStack(int i) {
        runStack.load(i);
    }

    public void storeRunStack(int i) {
        runStack.store(i);
    }

    public List topRunStack() {
        List top = runStack.topStack();
        return top;
    }

    public void pushReturnAd(int i) {
        returnAddrs.push(i);
    }

    public int popReturnAd() {
        return returnAddrs.pop();
    }

    public void dumpSwitch(String flag) {
        dumpMode = flag;
    }

    public void halt() {
        isRunning = false;
    }

    public int getRunStackSize() {
        return runStack.getN();
    }
}
