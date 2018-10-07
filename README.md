# Interpreter
This assignment is an interpreter for a mock language X. Given a set amount of base code, I implemented an abstract byte code class, their individual abstract classes, a byte code loader, resolved the loaded bytecodes’ address and a virtual machine that uses an array list, which will be treated as a runtime stack. To summarize, when the Interpreter runs, it will load all the bytecodes from a x.cod file, generating all the bytecodes and resolving them to their correct addresses, which will be passed to the virtual machine and each bytecode will be executed accordingly. The result will be a small program, prompting the user for an input and returning a factorial or a Fibonacci number. This was all completed on the NetBeans IDE.
