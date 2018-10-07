package interpreter;

import interpreter.ByteCode.ByteCode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class ByteCodeLoader extends Object {

    private final BufferedReader byteSource;
    private Program program;

    public ByteCodeLoader(String file) throws IOException {
        this.byteSource = new BufferedReader(new FileReader(file));
    }

    /**
     * This function should read one line of source code at a time. For each
     * line it should: Tokenize string to break it into parts. Grab correct
     * class name for the given ByteCode from CodeTable Create an instance of
     * the ByteCode class name returned from code table. Parse any additional
     * arguments for the given ByteCode and send them to the newly created
     * ByteCode instance via the init function.
     *
     * @return
     */
    public Program loadCodes() {
        Program program = new Program();

        ArrayList<String> args = new ArrayList<>();
        String code;

        try {

            code = byteSource.readLine(); //reads line from the program

            while (code != null) {

                StringTokenizer token = new StringTokenizer(code);
                args.clear(); //clears argument

                String storedToken = token.nextToken();
                if (storedToken != null) {

                    String codeClass = CodeTable.getClassName(storedToken);

                    while (token.hasMoreTokens()) {
                        args.add(token.nextToken());
                    }

                    //try{
                    if (codeClass != null) {
                        ByteCode byteCode = (ByteCode) (Class.forName("interpreter.ByteCode." + codeClass).newInstance());

                        byteCode.init(args);

                        program.add(byteCode);
                    }
                    code = byteSource.readLine();
                }
            }
            program.resolveAddrs(program);

        } catch (IOException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            System.out.println("Exception occurred " + e + "\n");
        }

        return program;
    }
}
