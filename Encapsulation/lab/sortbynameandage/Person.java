package Encapsulation.lab;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAge(age);
        this.setSalary(salary);
    }

    public Person(String firstName, String lastName, int age) {
    }

    @Override
    public String toString() {
        //Ex. 1
       // return String.format("%s %s is %d years old.", this.getFirstName(), this.getLastName(), this.getAge());

        //Ex. 2
        return String.format("%s %s gets %f leva", this.getFirstName(), this.getLastName(), this.getSalary());
    }


    public void increaseSalary(double bonus) {

        if (this.getAge() < 30){
            bonus /= 2;
        }
        this.setSalary(salary + (salary * bonus / 100 ));
    }

    public double getSalary() {
        return salary;
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

    public void setSalary(double salary) {
        if (salary < 460.0){
            throw new IllegalArgumentException("Salary cannot be less than 460 leva");
        }else {
            this.salary = salary;
        }
    }

    public void setFirstName(String firstName) {
        checkLength(firstName,"First");
        this.firstName = firstName;
    }

    private boolean checkLength(String name, String str) {
        boolean isLengthCorrect = true;
        if (name.length() < 3){
            isLengthCorrect = false;
            throw new IllegalArgumentException(str + " name cannot be less than 3 symbol");
        }
        return isLengthCorrect;
    }

    public void setLastName(String lastName) {
        checkLength(lastName,"Last");
        this.lastName = lastName;
    }

    public void setAge(int age) {
        if (age <= 0){
            throw new IllegalArgumentException("Age cannot be zero or negative integer");
        }else {
            this.age = age;
        }
    }
}
