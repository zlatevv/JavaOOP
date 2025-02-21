package WorkingWithAbstraction.StudentResources;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StudentSystem {
    private Map<String, Student> repo;

    public StudentSystem()
    {
        this.repo = new HashMap<>();
    }

    public Map<String, Student> getRepo() {
        return this.repo;
    }

    public void ParseCommand(String[]args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");

        String command = input[0];

        if (command.equals("Create"))
        {
            String name = input[1];
            int age = Integer.parseInt(input[2]);
            double grade =Double.parseDouble(input[3]);
            if (!repo.containsKey(name))
            {
                Student student = new Student(name, age, grade);
                repo.put(name,student);
            }
        }
        else if (command.equals("Show"))
        {
            String name = input[1];
            if (repo.containsKey(name))
            {
                Student student = repo.get(name);
                String view = String.format("%s is %s years old.",student.getName(),student.getAge());

                if (student.getGrade() >= 5.00)
                {
                    view += " Excellent student.";
                }
                else if (student.getGrade() < 5.00 && student.getGrade() >= 3.50)
                {
                    view += " Average student.";
                }
                else
                {
                    view += " Very nice person.";
                }

                System.out.println(view);
            }
        }
    }
}
