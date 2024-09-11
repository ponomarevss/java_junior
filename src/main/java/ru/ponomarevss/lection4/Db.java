package ru.ponomarevss.lection4;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class Db {

    public static void hibernateConn() {
        Connector connector = new Connector();
        try(Session session = connector.getSession()) {
            Transaction transaction = session.beginTransaction();
            List<Magic> books = session.createQuery("FROM Magic", Magic.class).getResultList();
            books.forEach(session::remove);
            transaction.commit();
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());;
        }
    }

//    public static void hibernateConn() {
//        Connector connector = new Connector();
//        try(Session session = connector.getSession()) {
//            String hql = "from Magic where id = :id";
//            Query<Magic> query = session.createQuery(hql, Magic.class);
//            query.setParameter("id", 4);
//            Magic magic = query.getSingleResult();
//            System.out.println(magic);
//            magic.setName("Проклятие толстой жопы");
//            magic.setAttBonus(-10);
//            session.beginTransaction();
//            session.merge(magic);
//            session.getTransaction().commit();
//        } catch (RuntimeException e) {
//            System.err.println(e.getMessage());;
//        }
//    }

//    public static void hibernateConn() {
//        Connector connector = new Connector();
//        try(Session session = connector.getSession()) {
//            List<Magic> books = session.createQuery("FROM Magic", Magic.class).getResultList();
//            books.forEach(System.out::println);
//        } catch (RuntimeException e) {
//            System.err.println(e.getMessage());;
//        }
//    }
//

//    public static void hibernateConn() {
//        Connector connector = new Connector();
//        Session session = connector.getSession();
//        session.beginTransaction();
//        Magic magic = new Magic("Волшебная стрела", 10, 0);
//        session.persist(magic);
//        magic = new Magic("Молния", 25, 0);
//        session.persist(magic);
//        magic = new Magic("Жажда крови", 0, 6);
//        session.persist(magic);
//        magic = new Magic("Проклятие", 0, -3);
//        session.persist(magic);
//        magic = new Magic("Лечение", -30, 0);
//        session.persist(magic);
//        session.getTransaction().commit();
//        session.close();
//    }



//    public static void hibernateCon() {
//        final StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder().configure().build();
//        SessionFactory sessionFactory = new MetadataSources(standardServiceRegistry).buildMetadata().buildSessionFactory();
//        Session session = sessionFactory.openSession();
//
//        Magic magic = new Magic("Волшебная стрела", 10, 0);
//
//        session.beginTransaction();
//        session.persist(magic);
//        session.getTransaction().commit();
//        session.close();
//    }

//    private static final String URL = "jdbc:mysql://localhost:3306";
//    private static final String USER = "toor";
//    private static final String PASSWORD = "toortoor";

//    public static void jdbcCon() {
//        try(Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
//            Statement statement = connection.createStatement();
//            statement.execute("DROP SCHEMA test;");
//            statement.execute("CREATE SCHEMA test;");
//            statement.execute("CREATE TABLE test.table (id INT NOT NULL, firstname VARCHAR(45) NULL, lastname VARCHAR(45) NULL, PRIMARY KEY(id));");
//            statement.execute("INSERT INTO test.table (id, firstname, lastname) VALUES (1, 'Alpha', 'Abraham');");
//            statement.execute("INSERT INTO test.table (id, firstname, lastname) VALUES (2, 'Bravo', 'Ben');");

//            ResultSet resultSet = statement.executeQuery("SELECT * FROM test.table;");
//            while (resultSet.next()) {
//                System.out.println(resultSet.getString(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3));
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }


}
