package com.company;

import com.sun.deploy.security.SelectableSecurityManager;

interface Programmer{
    String domain= "rocompany.ro";

    void printInfo();
    String code(String programLanguage);
    boolean debugCode(String code);
    String documentCode(String code,String programLanguage);
}
class Employee implements Programmer {
    private int salary;
    private String job;
    private String name;
    private int age;
    private String address;

    public Employee(String name, int age, String address, int salary, String job){
        this.salary=salary;
        this.job=job;
        this.name=name;
        this.age=age;
        this.address=address;
    }

    @Override
    public void printInfo(){
        System.out.println("Name: "+this.name+" , age: "+this.age+" job: "+this.job+" salary: "+this.salary);
    }

    public String code(String programLanguage){
        if (programLanguage.equals("C++")){
            return "#include <iostream>\n" +
                    "\n" +
                    "int main() {\n" +
                    "    std::cout << \"Hello World!\";\n" +
                    "    return 0;\n" +
                    "}";
        }
        else
            if(programLanguage.equals("Java")){
                return "public class Main {\n" +
                        "    public static void main(String[] args) {\n" +
                        "        System.out.println(\"Hello World\");\n" +
                        "    }\n" +
                        "}";
            }
            else
                if (programLanguage.equals("Python")){
                    return "print('Hello World!')";
                }
                return null;
    }
    public boolean debugCode(String code){
        if( code.contains(";")){
            System.out.println("Codul nu are erori.");
            return  false;
        }
        else{
            System.out.println("Codul are erori si trebuie verificat.");
            return true;
        }
    }
    public String documentCode(String code, String programLanguage) {
        if (code.contains("Java") == false && programLanguage.equals("Java")) {
            code = "// Cod scris in Java de tip Hello World " + "\n" + code;
            return code;
        } else if (code.contains("Python") == false && programLanguage.equals("Python")) {
            code = "// Cod scris in Python de tip Hello World " + "\n" + code;
            return code;
        } else if (code.contains("C++") == false && programLanguage.equals("C++")) {
            code = "// Cod scris in Java de tip Hello World " + "\n" + code;
            return code;
        }
        System.out.println("Fals-document");
        return code;
    }

}

    public class Main {

    public static void main(String[] args) {
        Employee empOne=new Employee("Mihaela", 30, "Cluj", 1500, "Developer");
        empOne.printInfo();

        String programLanguage="Java";
        String codeOne=empOne.code(programLanguage);
        System.out.println(codeOne);

        empOne.debugCode(codeOne);

        codeOne=empOne.documentCode(codeOne,programLanguage);
        System.out.println(codeOne);

        Employee person=new Employee("Bianca", 29, "Bucuresti", 1000,"Manager");
        person.printInfo();
    }
}
