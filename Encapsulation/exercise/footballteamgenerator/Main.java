package Encapsulation.exercise.footballteamgenerator;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Team> teams = new TreeMap<>();

        String[] command = scanner.nextLine().split(";");

        while (!command[0].equals("END")) {
            String teamName = command[1];

            switch (command[0]){
                case "Encapsulation.exercise.footballteamgenerator.Team" -> {teams.putIfAbsent(teamName, new Team(teamName));}
                case "Add" -> {
                    String playerName = command[2];
                    int endurance = Integer.parseInt(command[3]);
                    int sprint = Integer.parseInt(command[4]);
                    int dribble = Integer.parseInt(command[5]);
                    int passing = Integer.parseInt(command[6]);
                    int shooting = Integer.parseInt(command[7]);

                    Player player = new Player(playerName,endurance,sprint,dribble,passing,shooting);

                    if (!teams.containsKey(teamName)) {
                        String message = "Encapsulation.exercise.footballteamgenerator.Team %s does not exist.".formatted(teamName);
                        throw new IllegalArgumentException(message);
                    }

                    Team team = teams.get(teamName);
                    team.addPlayer(player);
                }
                case "Remove" -> {
                    String playerName = command[2];
                    teams.get(teamName).removePlayer(playerName);
                }
                case "Rating" -> {
                    if (!teams.containsKey(teamName)) {
                        String message = "Encapsulation.exercise.footballteamgenerator.Team %s does not exist.".formatted(teamName);
                        throw new IllegalArgumentException(message);
                    }

                    if (teams.get(teamName).getPlayers().isEmpty()){
                        System.out.printf("%s - 0%n", teamName);
                    }else {
                        System.out.printf("%s - %.0f%n", teamName, teams.get(teamName).getRating());

                    }

                   }
            }

            command = scanner.nextLine().split(";");
        }
    }
}
