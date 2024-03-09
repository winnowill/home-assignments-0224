package ru.sberbank.jd.lesson04;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Класс генерации результатов вывода команд.
 */
public class OutputGenerator {
    /**
     * Генерация результатов работы команд.
     *
     * @param arguments Входные парметры
     * @return Результаты работы команд
     */
    public OutputResult generate(Arguments arguments) {
        arguments.normalizeArguments();
        String message = "";
        if (arguments.getFirstCom() == null) {
            message = "Неправильно введена команда.Воспользуйтесть командой  --help";
            return new OutputResult(message);
        }
        switch (arguments.getFirstCom()) {
            case Constant.L_COM:
                try {
                    if (arguments.getSecondCom() == Constant.W_COM) {
                        message = calculateLinesAndWords(arguments.getFilePath(), 3);
                    } else {
                        message = calculateLinesAndWords(arguments.getFilePath(), 1);
                    }
                } catch (Exception e) {
                    message = e.getMessage();
                }
                break;
            case Constant.HELP_COM:
                message = arguments.getFirstCom() + " - Список доступных команд"
                        + "-l - количество строк"
                        + "-w - количество слов"
                        + "--help - печать справки по использованию программы"
                        + "--version - Версия программы";
                break;
            case Constant.VER_COM:
                message = arguments.getFirstCom() + " " + "version01, Разработчик Елфимова Л. В.";
                break;
            case Constant.W_COM:
                try {
                    message = calculateLinesAndWords(arguments.getFilePath(), 2);
                } catch (Exception e) {
                    message = e.getMessage();
                }
                break;
            default:
                break;
        }
        return new

                OutputResult(message);
    }

    /**
     * Подсчет количества слов и строк в файле.
     *
     * @param filePath Путь до файла
     * @return Сообщение
     * @throws Exception Ошибки чтения файла
     */
    public String calculateLinesAndWords(String filePath, int mode) throws Exception {
        int countWords = 0;
        int countWordsTotal = 0;
        long countLines = 0L;
        long countLinesTotal = 0L;
        String message = "";
        List<Path> pathList = new ArrayList<>();

        try (Stream<Path> stream = Files.walk(Paths.get(filePath))) {
            pathList = stream.map(Path::normalize)
                    .filter(Files::isRegularFile)
                    .toList();
        }
        for (Path path : pathList) {
            switch (mode) {

                case 1:
                    // считаем строки
                    try (Stream<String> lines = Files.lines(path)) {
                        countLines = lines.count();
                        countLinesTotal = countLinesTotal + countLines;
                        message = message + (int) countLines + " " + path + "\n";
                        break;
                    }
                case 2:
                    //считаем слова
                    String line = Files.readString(path);
                    String[] words = line.split(" ");
                    countWords = countWords + words.length + 1;
                    countWordsTotal = countWordsTotal + countWords;
                    message = message + (int) countLines + " " + path + "\n";
                    break;
                default:
                    // считаем слова и строки
                    try (Stream<String> lines = Files.lines(path)) {
                        countLines = lines.count();
                        countLinesTotal = countLinesTotal + countLines;
                        line = Files.readString(path);
                        words = line.split(" ");
                        countWords = countWords + words.length +  1;
                        countWordsTotal = countWordsTotal + countWords;
                        message = message + (int) countLines + " " + countWords + " " + path + "\n";
                        break;
                    }
            }
        }
        return message = message + (int) countLinesTotal + "  " + countWordsTotal;
    }

}
