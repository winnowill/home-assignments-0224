package ru.sberbank.jd.lesson12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Класс для работы с соединением.
 */
public class ConnectionUtils {
    public static final String POSTGRES_URL = "jdbc:postgresql://localhost:5433/postgres";
    public static final String USERNAME = "postgres";
    public static final String PASSWORD = "password";

    /**
     * Дефолтное соединение.
     *
     * @return Соединение
     */
    public static Connection getConnection() {
        Connection connection;
        try {
            connection = DriverManager.getConnection(POSTGRES_URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    /**
     * Соединение с BD.
     *
     * @param jdbcUrl Путь к BD
     * @param username login пользователя
     * @param password Пароль
     * @return Соединение
     */
    public static Connection getConnection(String jdbcUrl, String username, String password) {
        Connection connection;
        try {
            connection = DriverManager.getConnection(jdbcUrl, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    /**
     * Закрытие соединения.
     *
     * @param connection Соединение
     */
    public static void closeConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
