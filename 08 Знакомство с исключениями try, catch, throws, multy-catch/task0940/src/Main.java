import java.util.logging.Level;
import java.util.logging.Logger;

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
    public final static Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        try(AutoCloseableResourcesFirst first = new AutoCloseableResourcesFirst();
            AutoCloseableResourcesSecond second = new AutoCloseableResourcesSecond()) {
            first.doSomething();
            second.doSomething();
        } catch (Exception e) {
            LOGGER.warning("Произошла ошибка: '" + e.getMessage() + "'"); // Ошибку логгируем с уровнем 'warning'
            throw new RuntimeException(e);
        }
    }
}


class AutoCloseableResourcesFirst implements AutoCloseable {

    public AutoCloseableResourcesFirst() {
        Main.LOGGER.log(Level.INFO, "Вызов конструктора -> AutoCloseableResources_First"); //        System.out.println("Вызов конструктора -> AutoCloseableResources_First");
    }

    public void doSomething() {
        Main.LOGGER.info("Какой то метод -> AutoCloseableResources_First"); //        System.out.println("Какой то метод -> AutoCloseableResources_First");
    }

    @Override
    public void close() throws Exception {
        Main.LOGGER.info("ЗАКРЫВАЕМ ресурс -> AutoCloseableResources_First"); //        System.out.println("ЗАКРЫВАЕМ ресурс -> AutoCloseableResources_First");
    }
}


class AutoCloseableResourcesSecond implements AutoCloseable {

    public AutoCloseableResourcesSecond() {
        Main.LOGGER.log(Level.INFO, "Вызов конструктора -> AutoCloseableResources_Second"); //        System.out.println("Вызов конструктора -> AutoCloseableResources_Second");
    }

    public void doSomething() {
        Main.LOGGER.info("Какой то метод -> AutoCloseableResources_Second"); //        System.out.println("Какой то метод -> AutoCloseableResources_Second");
    }

    @Override
    public void close() throws Exception {
        Main.LOGGER.info("ЗАКРЫВАЕМ ресурс -> AutoCloseableResources_Second"); //        System.out.println("ЗАКРЫВАЕМ ресурс -> AutoCloseableResources_Second");
    }
}

