package Inheritance.animals;

public class Animal {
    private static final String INVALID_INPUT = "Invalid input!";
    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender) {
        setAge(age);
        setGender(gender);
        setName(name);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age <= 0){
            throw new IllegalArgumentException(INVALID_INPUT);
        }
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.trim().isEmpty()){
            throw new IllegalArgumentException(INVALID_INPUT);
        }
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if (gender.trim().isEmpty()){
            throw new IllegalArgumentException(INVALID_INPUT);
        }
        this.gender = gender;
    }
    public String produceSound(){
        return null;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%s%n", this.getClass().getSimpleName()));
        builder.append(String.format("%s %d %s%n", this.getName(), this.getAge(), this.getGender()));
        builder.append(String.format(this.produceSound()));
        return builder.toString();
    }
}
