package task1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/* 
Количество букв
Введи с клавиатуры 10 строчек и посчитай в них количество различных букв без учета регистра. Результат выведи на экран в алфавитном порядке.

Пример вывода:
а 5
б 8
в 3
г 7
д 0
...
я 9


Requirements:
1. Программа должна 10 раз считывать данные с клавиатуры.
2. Программа должна выводить текст на экран.
3. Выведенный текст должен содержать 33 строки.
4. Каждая строка вывода должна содержать букву русского алфавита, пробел и количество раз, которое буква встречалась в введенных строках.*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Алфавит
        List<Character> alphabet = Arrays.asList(
                'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж',
                'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о',
                'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц',
                'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я');

        // Ввод строк
        final int size = 2;
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            System.out.printf("Введите строку: №%d из %d: ", i + 1, size);
            String line = reader.readLine();
            list.add(line.toLowerCase());
        }

        Map<Character, Integer> lettersMap = new HashMap<>();
        for (Character letter : alphabet) {
            lettersMap.put(letter, 0);
        }

        for (String line : list) {
            countLetters(lettersMap, line);
        }

        lettersMap.entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .forEach(entry -> System.out.printf(
                        "Буква   '%s'   встречается \t %s   раз;\n", entry.getKey(), entry.getValue()));
    }

    private static void countLetters(Map<Character, Integer> letters, String line) {
        line.replace(" ", "");
        for (char current : line.toCharArray()) {
            try {
                letters.put(current, letters.get(current) + 1);
            } catch (NullPointerException e) {
                System.out.println("\tНеизвестная буква:   '" + current + "'");
            }
        }
    }
}
