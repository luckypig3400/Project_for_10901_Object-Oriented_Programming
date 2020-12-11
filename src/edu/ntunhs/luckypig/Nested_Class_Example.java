package edu.ntunhs.luckypig;

public class Nested_Class_Example {
    public static void main(String[] args) {
        
    }
}

class OuterClass {
    String classInfo;

    OuterClass() {
        classInfo = "You are in OuterClass";
    }

    void getInfo() {
        System.out.println(classInfo);
    }

    class InnerClass {
        String classInfo;

        InnerClass() {
            classInfo = "You are in InnerClass";
        }

        void getInfo() {
            System.out.println(classInfo);
        }

        class insideInnerClass {
            String classInfo;

            insideInnerClass() {
                classInfo = "You are in insideInnerClass";
            }

            void getInfo() {
                System.out.println(classInfo);
            }
        }
    }
}