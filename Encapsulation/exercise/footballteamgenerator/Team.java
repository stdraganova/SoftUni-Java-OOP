package Encapsulation.exercise.footballteamgenerator;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;

    public Team(String name) {
        this.setName(name);
        this.players = new LinkedList<>();
    }

    private void setName(String name) {
        if (name == null || name.isEmpty() || name.isBlank()){
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void removePlayer(String name) {
        Player player = players.stream().filter(player1 -> player1.getName().equals(name)).findFirst().orElse(null);

        if (player == null){
            String message = "Encapsulation.exercise.footballteamgenerator.Player %s is not in %s team.".formatted(name, this.name);
            throw new IllegalArgumentException(message);  // Add this line to throw the exception
        }

        players.remove(player);
    }

    public double getRating() {
        if (players.isEmpty()) {
            return 0;  // Return 0 when there are no players
        }

        double rating = 0;
        for (Player player : players){
            rating += player.overallSkillLevel();
        }

        rating /= players.size();

        return rating;
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }
}
