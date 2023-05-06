/**
 * Трай с ресурсами
 * Для примера и упрощения, вам уже даны 2 класса имплементирующие интерфейс AutoCloseable
 * Любой класс, который имплементит данный интерфейс или интерфейс Closeable, является ресурсом.
 * Так же ресурсами в JAVA являются практически всё IO/NIO и классы требующие закрытия (напр. при работе с БД)
 *
 * Задача:
 * 1. Используя конструкцию "Трай с ресурсами", ОДНОВРЕМЕННО вызвать оба этих класса и посмотреть на то, каким образом
 * ресурсы будут сначала открыты, отработаны, а затем закрыты.
 * 2. Заменить вывод сообщений в консоль, на логирование уровня INFO
 */
public class Main {
    public static void main(String[] args) {

    }
}

class AutoCloseableResourcesFirst implements AutoCloseable {

    public AutoCloseableResourcesFirst() {
        System.out.println("Вызов конструктора -> AutoCloseableResources_First");
    }

    public void doSomething() {
        System.out.println("Какой то метод -> AutoCloseableResources_First");
    }

    @Override
    public void close() throws Exception {
        System.out.println("ЗАКРЫВАЕМ ресурс -> AutoCloseableResources_First");
    }
}


class AutoCloseableResourcesSecond implements AutoCloseable {

    public AutoCloseableResourcesSecond() {
        System.out.println("Вызов конструктора -> AutoCloseableResources_Second");
    }

    public void doSomething() {
        System.out.println("Какой то метод -> AutoCloseableResources_Second");
    }

    @Override
    public void close() throws Exception {
        System.out.println("ЗАКРЫВАЕМ ресурс -> AutoCloseableResources_Second");
    }
}