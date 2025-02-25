package Inheritance.StackOfStrings;
import java.util.List;

public class StackOfStrings{
    private List<String> data;
    public void push(String item){
        this.data.add(item);
    }
    public String pop(){
        return this.data.removeLast();
    }
    public String peek(){
        return this.data.getLast();
    }
    public boolean isEmpty(){
        return this.data.isEmpty();
    }
}
