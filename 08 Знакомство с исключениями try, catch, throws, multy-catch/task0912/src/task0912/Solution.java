package task0912;

/* 
Исключение при работе с числами
Перехватить исключение (и вывести его на экран), указав его тип, возникающее при выполнении кода:
int num=Integer.parseInt("XYZ");
System.out.println(num);


Requirements:
1. Программа должна выводить сообщение на экран.
2. В программе должен быть блок try-catch.
3. Программа должна отлавливать исключения конкретного типа, а не все возможные (Exception).
4. Выведенное сообщение должно содержать тип возникшего исключения.
5. Имеющийся код в методе main не удалять.*/

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {

        try {
            int num = Integer.parseInt("XYZ");
            System.out.println(num);
        } catch (NumberFormatException e) {
            System.out.println("\n\tType: \t" + e.getClass().getSimpleName());
            System.out.println("\n\tClass: \t" + e.getClass().getName());
            System.out.println("\n\tMessage: \t" + e.getMessage());
            System.out.println("\n\tStackTraceElements:");
            Arrays.stream(e.getStackTrace()).forEach(System.out::println);
        } catch (Exception eprst) {
            System.err.println("Не верно написан код. Программист балбес! :)");
            throw eprst;
        }
    }
}
