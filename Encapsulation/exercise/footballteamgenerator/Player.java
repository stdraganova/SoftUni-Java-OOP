package Encapsulation.exercise.footballteamgenerator;

public class Player {
    private String name;
    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;

    public Player(String name, int endurance, int sprint, int dribble, int passing, int shooting) {
        this.setName(name);
        this.setEndurance(endurance);
        this.setSprint(sprint);
        this.setDribble(dribble);
        this.setPassing(passing);
        this.setShooting(shooting);
    }

    private void setName(String name) {
        if (name == null || name.isEmpty() || name.isBlank()){
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    private void setEndurance(int endurance) {
        if (endurance < 0 || endurance > 100){
            String message = "Endurance should be between 0 and 100.";
            throw new IllegalArgumentException(message);
        }
        this.endurance = endurance;
    }

    private void setSprint(int sprint) {
        if (sprint < 0 || sprint > 100){
            String message = "Sprint should be between 0 and 100.";
            throw new IllegalArgumentException(message);
        }
        this.sprint = sprint;
    }

    private void setDribble(int dribble) {
        if (dribble < 0 || dribble > 100){
            String message = "Dribble should be between 0 and 100.";
            throw new IllegalArgumentException(message);
        }
        this.dribble = dribble;
    }

    private void setPassing(int passing) {
        if (passing < 0 || passing > 100){
            String message = "Passing should be between 0 and 100.";
            throw new IllegalArgumentException(message);
        }
        this.passing = passing;
    }

    private void setShooting(int shooting) {
        if (shooting < 0 || shooting > 100){
            String message = "Shooting should be between 0 and 100.";
            throw new IllegalArgumentException(message);
        }
        this.shooting = shooting;
    }

    public String getName() {
        return name;
    }

    public double overallSkillLevel() {
        double skillLevel = (this.endurance + this.dribble + this.shooting + this.sprint + this.passing) / 5.0;
        return skillLevel;
    }
}
