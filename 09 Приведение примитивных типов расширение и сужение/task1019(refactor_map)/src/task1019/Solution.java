package task1019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Функциональности маловато!
Программа вводит с клавиатуры пару (число и строку) и выводит их на экран.
Нужно сделать так, чтобы программа вводила с клавиатуры пары (число и строку) и сохраняла их в HashMap.

Ключевые требования:
Пустая строка - конец ввода данных.
Числа могут повторяться.
Строки всегда уникальны.
Введенные данные не должны потеряться!
Затем программа должна выводить содержание HashMap на экран.
Каждую пару - с новой строки.

Пример ввода:
1
Мама
2
Рама
1
Мыла

Пример вывода:
1 Мыла
2 Рама
1 Мама


Requirements:
1. Программа должна считывать данные с клавиатуры.
2. Программа должна выводить текст на экран.
3. В методе main объяви переменную коллекции HashMap и сразу проинициализируй ee.
4. Программа должна помещать в HashMap пары считанные с клавиатуры.
5. Программа должна выводить на экран содержимое HashMap согласно условию. Ключ и значение разделены пробелом. Каждое значение с новой строки.*/


public class Solution {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        Map<String, Integer> map = new HashMap<>();

        boolean isContinue = true;
        while (isContinue) {
            System.out.print("\nВведите число: ");
            int id = Integer.parseInt(getLine());
            System.out.print("Введите строку:");
            String name = getLine();
            System.out.printf("\tВведено: \tId = '%d', \tName = '%s'\n", id, name);
            if (name.length() != 0) {
                map.put(name, id);
            } else {
                isContinue = false;
            }
        }

        System.out.println("\nВывожу результат:");
        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            System.out.printf("key = '%s', \tvalue = '%d'\n", entry.getKey(), entry.getValue());
        }
    }

    private static String getLine() throws IOException {
        return reader.readLine();
    }
}
