# Exercise 38: Decompile a Class File

## Objective
Reverse engineer compiled Java bytecode.

## Instructions
1. Write a simple Java program (e.g., `Exercise01_HelloWorld.java`) and compile it using `javac Exercise01_HelloWorld.java`. This will produce a `Exercise01_HelloWorld.class` file.
2. Download a Java decompiler such as **JD-GUI** (http://java-decompiler.github.io/) or **CFR** (http://www.benf.org/other/cfr/).
3. Open the `.class` file using the decompiler.
4. You will see the decompiled Java source code, which should closely match the original source code, though some variable names or exact formatting might differ depending on how it was compiled.

### Example using CFR from command line:
```bash
java -jar cfr.jar Exercise01_HelloWorld.class
```
This will print the decompiled Java source code directly to your terminal.
