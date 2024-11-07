package workingwithabstraction.lab.workingwithabstractionlab;

import java.util.HashMap;
import java.util.Map;

public class StudentSystem {

    private Map<String, Student> repo;

    public StudentSystem()
    {
        this.repo = new HashMap<>();
    }

    public void ParseCommand(String[]args) {
        String name = args[1];

        switch (args[0]){
            case "Create" -> {
                int age = Integer.parseInt(args[2]);
                double grade =Double.parseDouble(args[3]);
                Student  student = new Student(name, age, grade);

                repo.putIfAbsent(name, student);
            }
            case "Show" -> {
                if (repo.containsKey(name)) {
                    Student student = repo.get(name);
                    String view = String.format("%s is %s years old. ",name,student.age());

                    if (student.grade() >= 5.00) {
                        view += "Excellent student.";
                    } else if (student.grade() < 5.00 && student.grade() >= 3.50) {
                        view += "Average student.";
                    } else {
                        view += "Very nice inheritance.exercise.person.";
                    }

                    System.out.println(view);
                }
            }
        }
    }
}
