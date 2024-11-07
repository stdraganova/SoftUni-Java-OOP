package interfacesandabstraction.exercise.defineaninterfaceperson.foodshortage;

public class Main {

    public static void main(String[] args) {

//        Scanner scanner = new Scanner(System.in);
//
//        List<Buyer> buyers = new ArrayList<>();
//        //List<Rebel> rebels = new ArrayList<>();
//
//        int n = Integer.parseInt(scanner.nextLine());
//
//        for (int i = 0; i < n; i++) {
//            String[] tokens = scanner.nextLine().split("\\s+");
//
//            String name = tokens[0];
//            int age = Integer.parseInt(tokens[1]);
//
//            if (tokens.length == 3) {
//                String  group = tokens[2];
//
//                Buyer rebel = new Rebel(name, age, group);
//                buyers.add(rebel);
//            }else {
//                String id = tokens[2];
//                String birthDate = tokens[3];
//
//                Buyer citizen = new Citizen(name, age, id, birthDate);
//                buyers.add(citizen);
//            }
//        }
//
//        String command = scanner.nextLine();
//
//        while (!command.equals("End")) {
//
//            String name = command;
//
//            buyers.stream().filter(buyer -> buyer.getName().equals(name)).forEach(Buyer::buyFood);
//            command = scanner.nextLine();
//        }
//
//        AtomicInteger totalFoodCount = new AtomicInteger();
//
//        buyers.stream().forEach(buyer -> totalFoodCount.addAndGet(buyer.getFood()));
//
//        System.out.println(totalFoodCount.get());
    }
}
