package base;

/**
 * Запись конфигурации
 */
public class Config {
    public static int instanceCount = 0;

    String host;
    int port, maxConnections, timeOut;
    boolean debug;

    {
        host = "localhost";
        port = 8080;
        maxConnections = 100;
        timeOut = 30;
        debug = false;

        instanceCount++;
    }

    /**
     * Базовый конструктор, который не создается автоматически по причине наличия других
     */
    public Config() {
    }

    /**
     * Конструктор со всеми параметрами
     *
     * @param host           Наименование/IP хоста
     * @param port           Порт
     * @param maxConnections Максимальное число подключений
     * @param timeOut        Таймаут
     * @param debug          Дебаг-мод
     */
    public Config(String host, int port, int maxConnections, int timeOut, boolean debug) {
        this.host = host;
        this.port = port;
        this.maxConnections = maxConnections;
        this.timeOut = timeOut;
        this.debug = debug;
    }

    /**
     * Упрощенный конструктор только с названием хоста и портом
     *
     * @param host Наименование/IP хоста
     * @param port Порт
     */
    public Config(String host, int port) {
        this.host = host;
        this.port = port;
    }

    /**
     * Вывод конфигурации со всеми параметрами в консоль
     */
    public void printConfig() {
        System.out.printf("""
                        ————————————————————————————————————————————————————————————————————————————————————
                        Configuration (total %d):
                            Host: %s
                            Port: %d
                            Maximum connections: %d
                            TimeOut: %d
                            Debug mod: %b
                        ————————————————————————————————————————————————————————————————————————————————————
                        """,
                instanceCount, host, port, maxConnections, timeOut, debug
        );
    }

    /**
     * Тестовый метод для демонстрации возможностей класса
     */
    public static void testClass() {
        Config configFull = new Config("192.168.0.1", 27015, 1024, 60, true);
        configFull.printConfig();

        Config configPart = new Config("8.8.8.8", 465);
        configPart.printConfig();

        for (int i = 0; i < 3; i++) {
            Config newConfig = new Config();
            newConfig.printConfig();
        }
    }
}

/*
Задача 4. Класс Config.
Создайте класс Config для хранения настроек приложения. Поля: host (String), port (int), maxConnections (int), timeout (int), debug (boolean).
Используйте блок инициализации для установки значений по умолчанию: host = "localhost", port = 8080, maxConnections = 100, timeout = 30, debug = false.
Реализуйте конструктор без параметров (использует только блок), конструктор принимающий host и port, полный конструктор со всеми полями.
Добавьте метод printConfig и статическое поле instanceCount считающее количество созданных конфигураций.
Продемонстрируйте что блок инициализации выполняется при каждом создании объекта.
 */