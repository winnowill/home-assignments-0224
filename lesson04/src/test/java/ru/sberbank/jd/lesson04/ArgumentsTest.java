package ru.sberbank.jd.lesson04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ArgumentsTest {
    /**
     * Введен только путь с маской
     */
    @Test
    void inputFilePath(){
        Arguments arguments = new Arguments();
        arguments.setFilePath("~/_repos/jd");
        String expect = "~/_repos/jd";
        expect = expect.replace(Constant.PARENT_PATH,Constant.FILE_PATH_DEF );
        arguments.normalizeArguments();
        Assertions.assertEquals(Constant.L_COM, arguments.getFirstCom());
        Assertions.assertEquals(Constant.W_COM, arguments.getSecondCom());
        Assertions.assertEquals(expect, arguments.getFilePath());
    }

    /**
     * Неправильно введена команда.
     */
    @Test
    void inputWrongCom(){
        Arguments arguments = new Arguments();
        arguments.setFirstCom("--hello");
        arguments.normalizeArguments();
        Assertions.assertNotEquals(Constant.HELP_COM, arguments.getFirstCom());
        Assertions.assertNull(arguments.getFirstCom());
        Assertions.assertNull( arguments.getSecondCom());
    }

    /**
     * Введена комбинированная команда без пути.
     */
    @Test
    void inputCombinateCom(){
        Arguments arguments = new Arguments();
        arguments.setFirstCom("-lw");
        arguments.normalizeArguments();
        Assertions.assertEquals(Constant.L_COM, arguments.getFirstCom());
        Assertions.assertEquals(Constant.W_COM, arguments.getSecondCom());
        Assertions.assertEquals(Constant.FILE_PATH_DEF, arguments.getFilePath());
    }

    /**
     * Введено 2 команды и путь одна из команд с ошибкой.
     */
    @Test
    void inputAllCom(){
        Arguments arguments = new Arguments();
        arguments.setFirstCom(Constant.L_COM);
        arguments.setSecondCom("--hello");
        arguments.setFilePath(Constant.FILE_PATH_DEF);
        arguments.normalizeArguments();
        Assertions.assertNull( arguments.getFirstCom());
        Assertions.assertNull( arguments.getSecondCom());
        Assertions.assertNull(arguments.getFilePath());
    }
}