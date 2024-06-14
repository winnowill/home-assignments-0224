package ru.sberbank.jd.lesson04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OutputGeneratorTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void checkVersion() {
        String[] args = new String[1];
        args[0] = Constant.VER_COM;
        ArgumentParser parser = new ArgumentParser();
        Arguments arguments = parser.parse(args);
        Assertions.assertNotNull(arguments.getFirstCom());
        OutputGenerator generator = new OutputGenerator();
        OutputResult result = generator.generate(arguments);
        Assertions.assertEquals("wc: --version version01, Разработчик Елфимова Л. В.", result.toString());
    }

    @Test
    void callHelp()  {

        String[] args = new String[1];
        args[0] = Constant.HELP_COM;
        ArgumentParser parser = new ArgumentParser();
        Arguments arguments = parser.parse(args);
        Assertions.assertNotNull(arguments.getFirstCom());
        OutputGenerator generator = new OutputGenerator();
        OutputResult result = generator.generate(arguments);
        Assertions.assertEquals("wc: --help - Список доступных команд-l - количество строк-w - количество слов--help - печать справки по использованию программы--version - Версия программы",
                                   result.toString());
    }

    @Test
    void calculateLinesAndWords(){
        String[] args = new String[1];
        args[0] = Constant.FILE_PATH_DEF;
        ArgumentParser parser = new ArgumentParser();
        Arguments arguments = parser.parse(args);
        OutputGenerator generator = new OutputGenerator();
        OutputResult result = generator.generate(arguments);
        Assertions.assertEquals("wc: 2 3 E:\\Java\\Java_dev\\home-assignments-0224\\lesson04\\text\n" +
                        "2  3", result.toString());

    }


}