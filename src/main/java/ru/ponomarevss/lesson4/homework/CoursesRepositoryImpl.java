package ru.ponomarevss.lesson4.homework;

import org.hibernate.Session;

import java.util.Collection;
import java.util.List;

public class CoursesRepositoryImpl implements CoursesRepository{

    private final Session session;

    public CoursesRepositoryImpl(Session session) {
        this.session = session;
    }

    @Override
    public void add(Course item) {
        session.beginTransaction();
        session.persist(item);
        session.getTransaction().commit();
        System.out.println("Item saved successfully: " + item);
    }

    @Override
    public void update(Course item) {
        session.beginTransaction();
        session.merge(item);
        session.getTransaction().commit();
        System.out.println("Item updated successfully: " + item);
    }

    @Override
    public void delete(Course item) {
        session.beginTransaction();
        session.remove(item);
        session.getTransaction().commit();
        System.out.println("Item removed successfully: " + item);
    }

    @Override
    public Course getById(Integer integer) {
        session.beginTransaction();
        Course course = session.byId(Course.class).load(integer);
        session.getTransaction().commit();
        System.out.println("Item retrieved successfully: " + course);
        return course;
    }

    @Override
    public Collection<Course> getAll() {
        session.beginTransaction();
        List<Course> courses = session.createQuery("FROM Course", Course.class).getResultList();
        session.getTransaction().commit();
        System.out.println("All courses retrieved successfully");
        return courses;
    }
}
