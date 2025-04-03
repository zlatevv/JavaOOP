package Encapsulation.SalaryIncrease;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setAge(int age) {
        if (age <= 0){
            System.out.println("Age cannot be zero or negative integer");
        }
        this.age = age;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Person(String firstName, String lastName, int age, double percent) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = percent;
    }

    @Override
    public String toString() {
        return String.format("%s %s gets %s leva", firstName, lastName, salary);
    }

    public void increaseSalary(double bonus) {
        if (this.age < 30){
            this.setSalary(this.getSalary() + (this.getSalary() * bonus / 200));
        }else{
            this.setSalary(this.getSalary() + (this.getSalary() * bonus / 100));
        }
    }
}
