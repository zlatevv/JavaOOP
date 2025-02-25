package Encapsulation.ShoppingSpree;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            Map<String, Person> people = new LinkedHashMap<>();
            String[] peopleInput = scanner.nextLine().split(";");
            for (String personData : peopleInput) {
                String[] tokens = personData.split("=");
                String name = tokens[0].trim();
                double money = Double.parseDouble(tokens[1].trim());
                Person person = new Person(name, money);
                people.put(name, person);
            }
            Map<String, Product> products = new HashMap<>();
            String[] productsInput = scanner.nextLine().split(";");
            for (String productData : productsInput) {
                String[] tokens = productData.split("=");
                String name = tokens[0].trim();
                double cost = Double.parseDouble(tokens[1].trim());
                Product product = new Product(name, cost);
                products.put(name, product);
            }

            String command;
            while (!(command = scanner.nextLine()).equals("END")) {
                String[] tokens = command.split(" ");
                String personName = tokens[0];
                String productName = tokens[1];

                Person person = people.get(personName);
                Product product = products.get(productName);

                try {
                    person.buyProduct(product);
                    System.out.printf("%s bought %s%n", person.getName(), product.getName());
                } catch (IllegalArgumentException msg) {
                    System.out.println(msg.getMessage());
                }
            }
            for (Person person : people.values()) {
                System.out.println(person);
            }

        } catch (IllegalArgumentException msg) {
            System.out.println(msg.getMessage());
        }

    }
}
