package ru.sberbank.jd.lesson04;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;


class ArgumentParserTest {
    /**
     * На вход подан только путь к файлам.
     */
    @Test
    void sendPath() {
        String[] args = new String[1];
        args[0] = "E:/data";
        ArgumentParser parser = new ArgumentParser();
        Arguments arguments = parser.parse(args);
        Assertions.assertEquals("E:/data", arguments.getFilePath());
        Assertions.assertNull( arguments.getFirstCom());
        Assertions.assertNull( arguments.getSecondCom());
    }
    /**
     * На вход подана сервисная команда
     */
    @Test
    void sendLongCom() {
        String[] args = new String[2];
        args[0] = Constant.HELP_COM;
        args[1] = "E:/data";
        ArgumentParser parser = new ArgumentParser();
        Arguments arguments = parser.parse(args);
        Assertions.assertEquals("--help", arguments.getFirstCom());
        Assertions.assertNull( arguments.getSecondCom());
        Assertions.assertNull(arguments.getFilePath());
    }
    /**
     * На вход подана  команда подсчета и сервисная
     */
    @Test
    void sendCalcCom() {
        String[] args = new String[3];
        args[0] = Constant.L_COM;
        args[1] = Constant.HELP_COM;
        args[2] = "E:/data";
        ArgumentParser parser = new ArgumentParser();
        Arguments arguments = parser.parse(args);
        Assertions.assertEquals("-l", arguments.getFirstCom());
        Assertions.assertNull( arguments.getSecondCom());
        Assertions.assertEquals("E:/data", arguments.getFilePath());
    }
}