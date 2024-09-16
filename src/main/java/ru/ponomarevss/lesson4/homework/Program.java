package ru.ponomarevss.lesson4.homework;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Program {
    /**
     * Задание
     * =======
     * Создайте базу данных (например, SchoolDB).
     * В этой базе данных создайте таблицу Courses с полями id (ключ), title, u duration.
     * Настройте Hibernate для работы с вашей базой данных.
     * Создайте Java-класс Course, соответствующий таблице Courses, с необходимыми аннотациями Hibernate.
     * Используя Hibernate, напишите код для вставки, чтения, обновления и удаления данных в таблице Courses
     * Убедитесь, что каждая операция выполняется в отдельной транзакции.
     */
    public static void main(String[] args) {
        try (SessionFactory sessionFactory = new Configuration()
                .configure("homework4_hibernate.cfg.xml")
                .addAnnotatedClass(Course.class)
                .buildSessionFactory()) {

            Session session = sessionFactory.openSession();
            CoursesRepository repository = new CoursesRepositoryImpl(session);

//          create new course
            Course course = Course.create();

//          save course to db
            repository.add(course);

//          retrieve course
            Course retrievedCourse = repository.getById(course.getId());

//          modify course
            retrievedCourse.updateTitle();
            retrievedCourse.updateDuration();

//          update modified course to db
            repository.update(retrievedCourse);

//          delete course from db
            repository.delete(retrievedCourse);

//          retrieve and sout all courses
            repository.getAll().forEach(System.out::println);

        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
    }
}
