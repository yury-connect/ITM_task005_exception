import java.util.logging.Level;

/*
 *  Логирование состояний и ошибок в работе программы.
 *  Напишите метод, который выбрасывает проверяемое исключение и поймайте его в методе main
 *  Отловите и залогируйте начало вызова метода с ошибкой и саму ошибку уровнем INFO и WARNING соответственно
*/


public class Main {
    public static void main(String[] args) {
        Logger logger = new Logger(Main.class.getName());

        try {
            logger.log(Level.INFO, "Начало вызова метода с ошибкой.");
            method(); // выбрасывает исключение
        } catch (Exception e) {
            logger.log(Level.WARNING, "Сама ошибка: " + e);
        }

        System.out.println("\nHello world!\n");
    }

    private static void method() throws Exception { // Может кинуть ПРОВЕРЯЕМОЕ исключение
        Exception exeption = new Exception();
        String methodName = new Exception().getStackTrace()[0].getMethodName();
        String exeptionName = exeption.toString();
        System.err.printf("\nНа связи метод: '%s'. Выбрасываю исключение '%s'\n\n", methodName, exeptionName);
        throw exeption;
    }



    //***** Создаю стандартный логгер java для логирования событий *****
    static class Logger {
        private final java.util.logging.Logger logger;

        public Logger(String name) {
            this.logger = java.util.logging.Logger.getLogger(name);
        }

        public void log(Level level, String message) {
            logger.log(level, message);
        }
    }
}
