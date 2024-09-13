package task0902;

/* 
    И снова StackTrace
    Написать пять методов, которые вызывают друг друга.
    Каждый метод должен возвращать имя метода, вызвавшего его, полученное с помощью StackTrace.

    Requirements:
    1. В классе должно быть 5 методов (метод main не учитывать).
    2. Каждый метод должен вызывать следующий: main вызывать method1, method1 вызывать method2 и т.д.
    3. Каждый метод должен возвращать имя метода, вызвавшего его.
    4. Для получения имени вызвавшего метода, используй метод getMethodName.
*/


public class Solution {
    public static void main(String[] args) {
        System.out.println("\n\n\tЦепочка вызовов:\n" + method1());;
    }

    public static String method1() {
        return whoCalledMe() + " -> " + method2();
    }

    public static String method2() {
        return whoCalledMe() + " -> " + method3();
    }

    public static String method3() {
        return whoCalledMe() + " -> " + method4();
    }

    public static String method4() {
        return whoCalledMe() + " -> " + method5();
    }

    public static String method5() {
        return whoCalledMe();
    }


    private static String whoCalledMe() {
        String callingMethodName = getCallingMethodName(3);
        System.out.printf("На связи метод: '%s'. Меня вызвал метод: '%s'\n"
                , getCallingMethodName(2)
                , callingMethodName)
        return callingMethodName;
    }

    private static String getCallingMethodName(int n) {
        StackTraceElement[] stackTraceElements = new Exception().getStackTrace();
        return stackTraceElements[n].getMethodName();
    }
}
