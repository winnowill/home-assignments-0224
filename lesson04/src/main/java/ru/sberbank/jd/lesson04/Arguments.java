package ru.sberbank.jd.lesson04;

import lombok.Getter;
import lombok.Setter;

/**
 * Класс с разобранными значениями.
 */
@Getter
@Setter
public class Arguments {
    private String firstCom;
    private String secondCom;
    private String filePath;

    /**
     * Приведение ручного ввода к необходимому для расчета.
     */
    public void normalizeArguments() {

        if (firstCom != null) {
            // Проверка значений команды
            if ((firstCom.length() > 3)
                    && ((!firstCom.contains(Constant.HELP_COM))
                    &&(!firstCom.contains(Constant.VER_COM)))) {
                //  Не  Сервисные команды
                setFirstCom(null);
            } else if ((firstCom.length() == 3)
                    && (firstCom.contains(Constant.L_SIGN))
                    && (firstCom.contains(Constant.W_SIGN))) {
                // Сдвоеные команды
                setFirstCom(Constant.L_COM);
                setSecondCom(Constant.W_COM);
                if (filePath == null) {
                    setFilePath(Constant.FILE_PATH_DEF);
                }
            } else if (firstCom.length() == 2) {
                // Одиночные команды
                if ((firstCom.contains(Constant.L_COM))
                        || (firstCom.contains(Constant.W_COM))) {
                    if (filePath == null) {
                        setFilePath(Constant.FILE_PATH_DEF);
                    }
                } else {
                    setFirstCom(null);
                    setSecondCom(null);
                    setFilePath(null);
                }
                if ((secondCom != null)
                        && (((secondCom.length() == 2)
                        && ((!secondCom.contains(Constant.L_COM))
                        || (!secondCom.contains(Constant.W_COM))))
                        || (secondCom.length() > 2))) {
                    setFirstCom(null);
                    setSecondCom(null);
                    setFilePath(null);
                }

            }
        }
        if (filePath != null) {
            // Проверка пути
            filePath = filePath.replace(Constant.PARENT_PATH, Constant.FILE_PATH_DEF);

            if (firstCom == null) {
                setFirstCom(Constant.L_COM);
                setSecondCom(Constant.W_COM);
            }

        }

    }
}
