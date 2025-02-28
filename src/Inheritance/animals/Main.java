package Inheritance.animals;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Animal> animals = new ArrayList<>();

        while (true) {
            String type = scanner.nextLine();
            if (type.equals("Beast!")) break;
            String[] data = scanner.nextLine().split(" ");
            String name = data[0];
            int age = Integer.parseInt(data[1]);
            String gender = data.length > 2 ? data[2] : "";

            Animal animal;
            switch (type) {
                case "Dog":
                    animal = new Dog(name, age, gender);
                    break;
                case "Frog":
                    animal = new Frog(name, age, gender);
                    break;
                case "Cat":
                    animal = new Cat(name, age, gender);
                    break;
                case "Kitten":
                    animal = new Kitten(name, age);
                    break;
                case "Tomcat":
                    animal = new Tomcat(name, age);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid input!");
                }
                animals.add(animal);
            }
        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }
}
