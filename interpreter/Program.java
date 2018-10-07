package interpreter;

import interpreter.ByteCode.ByteCode;
import interpreter.ByteCode.LabelCode;
import interpreter.ByteCode.FalseBranchCode;
import interpreter.ByteCode.CallCode;
import interpreter.ByteCode.GotoCode;

import java.util.ArrayList;
import java.util.HashMap;

public class Program {

    private final ArrayList<ByteCode> program;
    private Object lableList;

    public Program() {
        program = new ArrayList<>();
    }

    public static void labelList(String key, int branch) {
        labelList.put(key, branch);
    }

    protected ByteCode getCode(int pc) {
        return this.program.get(pc);
    }

    public int getSize() {
        return this.program.size();
    }

    private static final HashMap<String, Integer> labelList = new HashMap<String, Integer>();

    /**
     * This function should go through the program and resolve all addresses.
     * Currently all labels look like LABEL <<num>>>, these need to be converted
     * into correct addresses so the VirtualMachine knows what to set the
     * Program Counter(PC) HINT: make note what type of data-stucture bytecodes
     * are stored in.
     *
     * @param byteCode
     */

    public void add(ByteCode byteCode) {
        if (byteCode instanceof LabelCode) {
            LabelCode label = (LabelCode) byteCode;
            labelList(label.getLabel(), program.size());
        }
        program.add(byteCode);
    }

    /* for loop runs while there are still values in ArrayList program
     if the ByteCode at index i is a GotoCode class object then the following code is executed
     sets chCode equal to the ByteCode value
     sets the Address of the label's PC value using the HashMap
     if the ByteCode at index i is a FalseBranchCode class object then the following code is executed
     sets chCode equal to the ByteCode value
     sets the Address of the label's PC value using the HashMap
     if the ByteCode at index i is a CallCode class object then the following code is executed
     sets chCode equal to the ByteCode value
     sets the Address of the label's PC value using the HashMap*/
    public void resolveAddrs(Program program) {

        for (int i = 0; i < program.getSize() - 1; i++) {

            if (program.getCode(i) instanceof GotoCode) {
                GotoCode code = (GotoCode) program.getCode(i);
                code.setTargetAddress(labelList.get(code.getLabel()));
            } else if (program.getCode(i) instanceof FalseBranchCode) {
                FalseBranchCode code = (FalseBranchCode) program.getCode(i);
                code.setTargetAddress(labelList.get(code.getLabel()));
            } else if (program.getCode(i) instanceof CallCode) {
                CallCode code = (CallCode) program.getCode(i);
                code.setTargetAddress(labelList.get(code.getLabel()));
            }
        }
    }

    public ArrayList<ByteCode> getByteCodeList() {
        return program;
    }
}
