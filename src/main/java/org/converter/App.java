package org.converter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * пример работы логгера
 * Hello world!
 */
public class App {
    private static Logger LOGGER = LoggerFactory.getLogger(App.class);
//private static final Logger LOGGER = LogManager.getLogger(Class.class.getName());
    public static void main(String[] args) {
        LOGGER.info("a test message");
        LOGGER.error("COLOR ERROR");
        LOGGER.warn("COLOR WARN");
        LOGGER.info("COLOR INFO");
        LOGGER.debug("COLOR DEBUG");
        LOGGER.trace("COLOR TRACE");
        System.out.println("Hello World!");
    }
}
