package interfacesandabstraction.exercise.defineaninterfaceperson.foodshortage;

public class Rebel implements Person, Buyer {

    private static final int START_FOOD = 0;
    private String name;
    private int age;
    private String group;
    private int food;

    public Rebel(String name, int age, String group) {
        this.name = name;
        this.age = age;
        this.group = group;
        this.food = START_FOOD;
    }

    public String getGroup() {
        return group;
    }

    @Override
    public void buyFood() {
        this.food += 5;
    }

    @Override
    public int getFood() {
        return food;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }
}
