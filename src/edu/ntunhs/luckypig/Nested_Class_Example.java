package edu.ntunhs.luckypig;

public class Nested_Class_Example {
    public static void main(String[] args) {
        OuterClass outer1 = new OuterClass();
        OuterClass.InnerClass inner1 = new OuterClass().new InnerClass();
        OuterClass.InnerClass.insideInnerClass insideInner1 = new OuterClass().new InnerClass().new insideInnerClass();
        outer1.printClassInfo();
        inner1.printClassInfo();
        insideInner1.printClassInfo();
    }
}

class OuterClass {
    String classInfo;

    OuterClass() {
        classInfo = "You are in OuterClass";
    }

    void printClassInfo() {
        System.out.println(classInfo);
    }

    class InnerClass {
        String classInfo;

        InnerClass() {
            classInfo = "You are in InnerClass(Nested Class Example)";
        }

        void printClassInfo() {
            System.out.println(classInfo);
        }

        class insideInnerClass {
            String classInfo;

            insideInnerClass() {
                classInfo = "You are in insideInnerClass(Nested Class Example)";
            }

            void printClassInfo() {
                System.out.println(classInfo);
            }
        }
    }
}