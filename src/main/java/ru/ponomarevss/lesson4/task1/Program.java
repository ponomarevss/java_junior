package ru.ponomarevss.lesson4.task1;

import ru.ponomarevss.lesson4.models.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

/**
 * Задача 1
 * ===
 * <p>
 * Используя SQL, создайте таблицу students с полями id (ключ), пате, и age.
 * Реализация подключения к базе данных через JDBC:
 * Напишите Java-код для подключения к базе данных (например, MySQL или PostgreSQL)
 * Реализуйте вставку, чтение, обновление и удаление данных в таблице Students
 * с использованием провайдера JDBC.
 */
public class Program {

    private static final Random random = new Random();

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/";
        String user = "root";
        String password = "password";

        try(Connection connection = DriverManager.getConnection(url, user, password)) {

            // Создание БД
            createDatabase(connection);
            System.out.println("Database created successfully");

            // Использовать БД
            useDatabase(connection);
            System.out.println("Use database successfully");

//            // Создание таблицы
            createTable(connection);
            System.out.println("Create table successfully");

            // Создание и внесение данных
//            int count = random.nextInt(5, 11);
//            for (int i = 0; i < count; i++) {
//                insertData(connection, Student.create());
//            }
//            System.out.println("Insert data successfully");

            // Чтение данных
            Collection<Student> students = readData(connection);
            students.forEach(System.out::println);
            System.out.println("Read data successfully");

            // Обновление данных
//            for (Student student : students) {
//                student.updateName();
//                student.updateAge();
//                updateData(connection, student);
//            }
//            System.out.println("Update data successfully");

            // Повторное чтение данных после обновления
//            students = readData(connection);
//            students.forEach(System.out::println);
//            System.out.println("Read data successfully");

            // Удаление данных
            for (Student student : students) {
                deleteData(connection, student.getId());
            }
            System.out.println("Delete data successfully");

            // Повторное чтение данных после удаления
            students = readData(connection);
            students.forEach(System.out::println);
            System.out.println("Read data successfully");

//            connection.close();
//            System.out.println("Database connection closed successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // region Utility methods

    private static void createDatabase(Connection connection) throws SQLException {
        String createDatabaseSQL = "CREATE DATABASE IF NOT EXISTS studentsDB;";
        try (PreparedStatement statement = connection.prepareStatement(createDatabaseSQL)) {
            statement.execute();
        }
    }

    private static void useDatabase(Connection connection) throws SQLException {
        String useDatabaseSQL = "USE studentsDB;";
        try (PreparedStatement statement = connection.prepareStatement(useDatabaseSQL)) {
            statement.execute();
        }
    }

    private static void createTable(Connection connection) throws SQLException {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS students (id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(100), age INT);";
        try (PreparedStatement statement = connection.prepareStatement(createTableSQL)) {
            statement.execute();
        }
    }

    private static void insertData(Connection connection, Student student) throws SQLException {
        String insertDataSQL = "INSERT INTO students (name, age) VALUES (?, ?);";
        try (PreparedStatement statement = connection.prepareStatement(insertDataSQL)) {
            statement.setString(1, student.getName());
            statement.setInt(2, student.getAge());
            statement.executeUpdate();
        }
    }

    private static Collection<Student> readData(Connection connection) throws SQLException {
        ArrayList<Student> studentsList = new ArrayList<>();
        String readDataSQL = "SELECT * FROM students;";
        try (PreparedStatement statement = connection.prepareStatement(readDataSQL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                studentsList.add(new Student(id, name, age));
            }
            return studentsList;
        }
    }

    private static void updateData(Connection connection, Student student) throws SQLException {
        String updateDataSQL = "UPDATE students set name=?, age=? WHERE id=?;";
        try(PreparedStatement statement = connection.prepareStatement(updateDataSQL)) {
            statement.setString(1, student.getName());
            statement.setInt(2, student.getAge());
            statement.setInt(3, student.getId());
            statement.executeUpdate();
        }
    }

    /**
     * Delete data.
     *
     * @param connection the connection
     * @param id         the id
     * @throws SQLException the sql exception
     */
    private static void deleteData(Connection connection, int id) throws SQLException {
        String deleteDataSQL = "DELETE FROM students WHERE id=?;";
        try(PreparedStatement statement = connection.prepareStatement(deleteDataSQL)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }

    // endregion
}
