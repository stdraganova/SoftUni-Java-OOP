public class Chicken {
    private String name;
    private int age;

    public Chicken(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    private void setName(String name) {
        if (name.length() < 1){
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    private void setAge(int age) {
        if (age < 0 || age > 15){
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double productPerDay () {
        return calculateProductPerDay();
    }

    private double calculateProductPerDay() {
        double eggsPerDay = 0;
        if (this.age <= 5){
            eggsPerDay = 2;
        } else if (this.age <= 11) {
            eggsPerDay = 1;
        }else {
            eggsPerDay = 0.75;
        }

        return eggsPerDay;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
