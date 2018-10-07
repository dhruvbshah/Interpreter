package interpreter;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RunTimeStack {

    private final ArrayList runTimeStack;
    private final Stack<Integer> framePointer;

    public RunTimeStack() {
        runTimeStack = new ArrayList<>();
        framePointer = new Stack<>();
        //Add initial Frame Pointer, main is the entry
        // point of our language, so its frame pointer is 0.
        framePointer.add(0);
    }

    public void dump() {

        Iterator iter = framePointer.iterator();
        int nextFrame = 0, currentFrame = (Integer) iter.next();

        for (Integer framePointer : framePointer) {
            if (iter.hasNext()) {
                nextFrame = (Integer) iter.next();
            } else {
                nextFrame = runTimeStack.size();
            }
        }

        System.out.print("[");

        for (int j = currentFrame; j < nextFrame; j++) {
            System.out.print(runTimeStack.get(j));
            if (j != nextFrame - 1) {
                System.out.print(",");
            }
        }
    }

    public int peek() {

        return (int) runTimeStack.get(runTimeStack.size() - 1);
    }

    public void newFrameAt(int n) {

        framePointer.push(this.runTimeStack.size() - n);
    }

    public int pop() {
        //if(runTimeStack.size())
        int temp = (int) runTimeStack.size() - 1;
        return (int) runTimeStack.remove(temp);

    }

    public int push(int i) {

        runTimeStack.add(i);
        return i;
    }

    public void popFrame() {

        int temp = this.peek();
        int temp1 = framePointer.pop();
        for (int i = runTimeStack.size() - 1; i >= temp1; i--) {
            this.pop();
        }
        this.push(temp);
    }

    public int store(int n) {

        int temp = this.pop();
        runTimeStack.set(framePointer.peek() + n, temp);
        return temp;
    }

    public int load(int n) {

        int temp = (int) runTimeStack.get(framePointer.peek() + n);
        runTimeStack.add(temp);
        return temp;
    }

    public Integer push(Integer i) {

        runTimeStack.add(i);
        return i;
    }

    public int getN() {

        return runTimeStack.size() - framePointer.peek() - 1;
    }

    public List topStack() {
        List top = runTimeStack.subList(framePointer.lastElement(), runTimeStack.size());
        return top;
    }

}
