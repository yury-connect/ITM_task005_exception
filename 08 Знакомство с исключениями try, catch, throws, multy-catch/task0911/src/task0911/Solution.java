package task0911;

import java.util.Arrays;
import java.util.HashMap;

/* 
    Исключение при работе с коллекциями Map
    Перехватить исключение (и вывести его на экран), указав его тип, возникающее при выполнении кода:
    HashMap<String, String> map = new HashMap<String, String>(null);
    map.put(null, null);
    map.remove(null);

    Requirements:
    1. Программа должна выводить сообщение на экран.
    2. В программе должен быть блок try-catch.
    3. Программа должна отлавливать исключения конкретного типа, а не все возможные (Exception).
    4. Выведенное сообщение должно содержать тип возникшего исключения.
    5. Имеющийся код в методе main не удалять.
*/


public class Solution {
    public static void main(String[] args) {

        try {
            HashMap<String, String> map = new HashMap<String, String>(null);
            map.put(null, null);
            map.remove(null);
        } catch (NullPointerException e) {
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
