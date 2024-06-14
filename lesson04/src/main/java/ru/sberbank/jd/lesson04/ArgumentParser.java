package ru.sberbank.jd.lesson04;

/**
 * Класс разбора ввееднных значений.
 */
public class ArgumentParser {
    /**
     * Разбор значений.
     *
     * @param args Входные параметры
     * @return Разобраные аргументы
     */
    public Arguments parse(String[] args) {
        Arguments arguments = new Arguments();
        for (String arg : args) {
            if (arg.length() > 3) {
                if ((arg.contains(Constant.SLASH_PATH))
                        || (arg.contains(Constant.SLASH))
                        || (arg.contains(Constant.ALL_FILES))
                        || (arg.contains(Constant.PARENT_PATH))) {
                    arguments.setFilePath(arg);
                    break;
                } else {
                    if (arguments.getFirstCom() == null) {
                        arguments.setFirstCom(arg.toLowerCase());
                        break;
                    }
                }
            } else if (arg.length() == 3) {
                if (arguments.getFirstCom().isEmpty()) {
                    arguments.setFirstCom(arg.toLowerCase());
                }
            } else if (arg.length() == 2) {
                if (arguments.getFirstCom() == null) {
                    arguments.setFirstCom(arg.toLowerCase());
                } else if (arguments.getSecondCom() == null) {
                    arguments.setSecondCom(arg.toLowerCase());
                }
            }
        }
        return arguments;
    }
}
