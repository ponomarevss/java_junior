package ru.ponomarevss.lesson4.homework;

import jakarta.persistence.*;

import java.util.Random;

@Entity
@Table(name = "courses")
public class Course {

    private static final String[] titles = new String[]{
            "Quantum Physics", "Digital Storytelling", "Cultural Studies", "Urban Sustainability",
            "Cryptography Basics", "Neuroplasticity", "Color Psychology", "Robotics Engineering",
            "Happiness Philosophy", "Fashion History", "AI Ethics", "Marine Ecology",
            "Mythology Studies", "Data Visualization", "Culinary Science", "Space Exploration",
            "Global Health", "Creative Writing", "Environmental Law", "Art Technology"
    };
    private static final Random random = new Random();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private int duration;

    public Course() {
    }

    public Course(int id, String title, int duration) {
        this.id = id;
        this.title = title;
        this.duration = duration;
    }

    public Course(String title, int duration) {
        this.title = title;
        this.duration = duration;
    }

    public static Course create() {
        return new Course(titles[random.nextInt(titles.length)], random.nextInt(30, 120));
    }

    public void updateTitle() {
        title = titles[random.nextInt(titles.length)];
    }

    public void updateDuration() {
        duration = random.nextInt(30, 120);
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", duration=" + duration +
                '}';
    }
}
