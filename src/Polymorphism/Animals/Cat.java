package Polymorphism.Animals;

public class Cat extends Animal{
    public Cat(String name, String favouriteFood) {
        super(name, favouriteFood);
    }

    @Override
    protected String explainSelf() {
        return String.format("I am %s and my favourite food is %s%nMEEOW", this.getName(), this.getFavouriteFood());
    }
}
