import java.util.Scanner;

public class MainChicken {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());

        Chicken chicken = new Chicken(name, age);

        System.out.printf("Chicken %s (age %d) can produce %.2f eggs per day", chicken.getName(), chicken.getAge(), chicken.productPerDay());
    }
}
