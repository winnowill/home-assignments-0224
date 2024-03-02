package ru.sberbank.jd.lesson04;

/**
 * Консольное приложение дублирующее команду wc.
 */
public class WordCount {

    public static void main(String[] args) {
        ArgumentParser parser = new ArgumentParser();
        Arguments arguments = parser.parse(args);

        OutputGenerator generator = new OutputGenerator();
        OutputResult result = generator.generate(arguments);

        ResultPrinter resultPrinter = new ResultPrinter();
        resultPrinter.output(result);
    }
}
