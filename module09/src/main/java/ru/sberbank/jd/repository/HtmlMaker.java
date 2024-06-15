package ru.sberbank.jd.repository;

/**
 * HtmlMaker class.
 */

public class HtmlMaker {

    /**
     * Making Html string.
     *
     * @param jsonString JSON
     * @return complete HTML string
     */
    public static String makeHtml(String jsonString) {

        StringBuilder document = new StringBuilder();
        document.append("<!DOCTYPE html>");
        document.append("<html>");
        document.append("<head>");
        document.append("<meta charset = \"UTF-8\">");
        document.append("<title>Task Application</title>");
        document.append("</head>");
        document.append("<body>");
        document.append(jsonString);
        document.append("</body>");
        document.append("</html>");
        return document.toString();
    }
}
