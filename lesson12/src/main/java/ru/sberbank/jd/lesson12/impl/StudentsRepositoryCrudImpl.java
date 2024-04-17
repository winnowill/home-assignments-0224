package ru.sberbank.jd.lesson12.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import ru.sberbank.jd.lesson12.ConnectionUtils;
import ru.sberbank.jd.lesson12.StudentsRepositoryCrud;
import ru.sberbank.jd.lesson12.model.Student;

/**
 * Позволяет выполнять CRUD операции с моделью Student.
 */

public class StudentsRepositoryCrudImpl implements StudentsRepositoryCrud {
    /**
     * Создание записи в БД.
     * id у student должен быть null, иначе требуется вызов update.
     * id генерируем через UUID.randomUUID()
     *
     * @param student - заполненный объект
     * @return сгенерированный UUID
     */
    @Override
    public UUID create(Student student) {
        if (student.getId() != null) {
            update(student);
            return student.getId();
        } else {
            Connection connection = ConnectionUtils.getConnection();
            student.setId(UUID.randomUUID());
            try (PreparedStatement statement = connection.prepareStatement("INSERT INTO student"
                    + "(id, firstname, lastname, birthdate, graduated)"
                    + "VALUES (?::uuid, ?, ?, ?::date, ?);")) {

                statement.setString(1, student.getId().toString());
                statement.setString(2, student.getFirstName());
                statement.setString(3, student.getLastName());
                statement.setString(4, 1900 + student.getBirthDate().getYear() + "-" + student.getBirthDate().getMonth()
                        + "-" + student.getBirthDate().getDay());
                statement.setBoolean(5, student.isGraduated());

                boolean executed = statement.execute();
                if (!executed) {
                    return student.getId();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

    /**
     * Получение записи по id из БД.
     *
     * @param id идентификатор записи
     * @return запись
     */
    @Override
    public Student selectById(UUID id) {
        Student student;
        Connection connection = ConnectionUtils.getConnection();

        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM student"
                + " WHERE id = ?::uuid;")) {
            statement.setString(1, id.toString());
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            student = new Student(UUID.fromString(resultSet.getString("id")),
                    resultSet.getString("firstname"), resultSet.getString("lastname"),
                    resultSet.getDate("birthdate"), resultSet.getBoolean("graduated"));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return student;
    }

    /**
     * Получение всех записей из БД.
     *
     * @return записи
     */
    @Override
    public List<Student> selectAll() {
        Connection connection = ConnectionUtils.getConnection();
        List<Student> students = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("select * from student;");

            while (resultSet.next()) {
                students.add(new Student(UUID.fromString(resultSet.getString("id")),
                        resultSet.getString("firstname"), resultSet.getString("lastname"),
                        resultSet.getDate("birthdate"), resultSet.getBoolean("graduated")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return students;
    }

    /**
     * Обновление записи в БД.
     *
     * @param student измененная запись
     * @return количество обновленных записей
     */
    @Override
    public int update(Student student) {

        int update = 0;
        if (student.getId() != null) {
            Connection connection = ConnectionUtils.getConnection();

            try (PreparedStatement statement = connection.prepareStatement("UPDATE student\n"
                    + "SET firstname=?, lastname=?, birthdate=?::date, graduated=?\n"
                    + "where id = ?::uuid;")) {
                statement.setString(1, student.getFirstName());
                statement.setString(2, student.getLastName());
                statement.setString(3, 1900 + student.getBirthDate().getYear() + "-" + student.getBirthDate().getMonth()
                        + "-" + student.getBirthDate().getDay());
                statement.setBoolean(4, student.isGraduated());
                statement.setString(5, student.getId().toString());

                boolean executed = statement.execute();
                if (executed) {
                    update = -1;
                } else {
                    update = 1;
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return update;
    }

    /**
     * Удаление указанных записей по id.
     *
     * @param idList список идентификаторов записей
     * @return количество удаленных записей
     */
    @Override
    public int remove(List<UUID> idList) {
        int delete = 0;
        Connection connection = ConnectionUtils.getConnection();
        for (UUID id : idList) {
            try (PreparedStatement statement = connection.prepareStatement("DELETE FROM student\n"
                    + "where id = ?::uuid;")) {
                statement.setString(1, id.toString());

                boolean executed = statement.execute();
                if (executed) {
                    delete = -1;
                } else {
                    delete = 1;
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return delete;
    }
}
