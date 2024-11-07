package inheritance.lab.stackofstrings;

import java.util.List;

public class StackOfStrings {
    private List<String> data;

    //Понеже трябва листа да се държи като стек
    public void push(String item) {
        //добавяме елемента на последен индекс

        data.add(data.size() - 1, item);
    }

    public String pop() {
        //премахваме от последен индекс
        return data.remove(data.size() - 1);
    }

    public String peek() {
        //принтираме елемента на последен индекс
        return data.get(data.size() - 1);
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }
}
