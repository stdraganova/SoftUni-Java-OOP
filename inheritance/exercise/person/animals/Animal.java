package inheritance.exercise.person.animals;

public class Animal {

    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender) {
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    private void setName(String name) {
        //Ако името е нулл или празно(вкл спейсове)
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("Invalid input!");
        }
        this.name = name;
    }

    private void setAge(int age) {
        if(age < 0){
            throw new IllegalArgumentException("Invalid input!");
        }
        this.age = age;
    }

    private void setGender(String gender) {
        if(gender == null || gender.isBlank()){
            throw new IllegalArgumentException("Invalid input!");
        }
        this.gender = gender;
    }

    public String produceSound(){
        //Връщаме празен стринг нулл понеже не знаем какъв звук издават всички животни
        return null;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        //Дава името на класа, от който се вика метода и слага нов ред
        sb.append(this.getClass().getSimpleName()).append(System.lineSeparator());
        sb.append(getName()).append(" ").append(getAge()).append(" ").append(getGender()).append(System.lineSeparator());
        sb.append(produceSound());

        return sb.toString();
    }
}
