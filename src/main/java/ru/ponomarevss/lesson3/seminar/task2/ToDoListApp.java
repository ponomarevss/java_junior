package ru.ponomarevss.lesson3.seminar.task2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ToDoListApp {
    public static final String FILE_JSON = "tasks.json";
    public static final String FILE_BIN = "tasks.bin";
    public static final String FILE_XML = "tasks.xml";

    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final XmlMapper xmlMapper = new XmlMapper();

    public static void addNewTask(Scanner scanner, List<ToDo> tasks) {
        System.out.println("Введите название новой задачи:");
        String newTaskTitle = scanner.nextLine();
        tasks.add(new ToDo(newTaskTitle));
        saveTasksToFile(FILE_JSON, tasks);
        saveTasksToFile(FILE_BIN, tasks);
        saveTasksToFile(FILE_XML, tasks);
        System.out.println("Новая задача добавлена.");
    }

    public static void saveTasksToFile(String fileName, List<ToDo> tasks) {
        try {
            if (fileName.endsWith(".json")){
                objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
                objectMapper.writeValue(new File(fileName), tasks);
            } else if (fileName.endsWith(".bin")) {
                try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
                    objectOutputStream.writeObject(tasks);
                }
            } else if (fileName.endsWith(".xml")) {
//                String s = xmlMapper.writeValueAsString(tasks);
                xmlMapper.writeValue(new File(fileName), tasks);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<ToDo> loadTasksFromFile(String fileName) {
        List<ToDo> tasks = new ArrayList<>();
        File file = new File(fileName);
        if (file.exists()) {
            try {
                if (fileName.endsWith(".json")) {
                    tasks = objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(List.class, ToDo.class));
                } else if (fileName.endsWith(".bin")) {
                    try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))) {
                        tasks = (List<ToDo>) objectInputStream.readObject();
                    }
                } else if (fileName.endsWith(".xml")) {
                    tasks = xmlMapper.readValue(file, xmlMapper.getTypeFactory().constructCollectionType(List.class, ToDo.class));
                }
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        return tasks;
    }
}
