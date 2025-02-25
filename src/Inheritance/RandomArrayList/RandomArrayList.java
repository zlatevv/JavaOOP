package Inheritance.RandomArrayList;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList extends ArrayList<Object>{
    public Object getRandomElement(){
        Random random = new Random();
        int randomIndex = random.nextInt(this.size());
        return this.remove(randomIndex);
    }
}
