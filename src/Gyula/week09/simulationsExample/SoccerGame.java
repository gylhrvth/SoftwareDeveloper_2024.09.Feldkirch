package Gyula.week09.simulationsExample;

import java.util.Random;
import java.util.Vector;

public class SoccerGame {
    private static Random random = new Random();
    private String desciption;
    private Vector<Player> homePlayers;
    private Vector<Player> foreignPlayers;
    private int scoreHome;
    private int scoreForeing;

    public SoccerGame(String description){
        this.desciption = description;
        this.homePlayers = new Vector<>();
        this.foreignPlayers = new Vector<>();
    }

    public void addPlayer(Player p, boolean home){
        if (homePlayers.contains(p) || foreignPlayers.contains(p)) {
            System.out.println("Player " + p + " is already in game.");
            return;
        }
        if (home){
            homePlayers.add(p);
        } else {
            foreignPlayers.add(p);
        }
    }

    public void resetScore(){
        scoreHome = 0;
        scoreForeing = 0;
    }

    public void printResult(){
        if (scoreHome > scoreForeing){
            System.out.println("The team HOME has won " + scoreHome + ":" + scoreForeing);
        } else if (scoreHome == scoreForeing) {
            System.out.println("The teams have a draw " + scoreHome + ":" + scoreForeing);
        } else {
            System.out.println("The team FOREIGN has won " + scoreForeing + ":" + scoreHome);
        }
    }

    public void simulateMinute(int minute){
        if (minute % 10 == 0) {
            System.out.println(minute + ". has been started");
        }
        Player playerWithChanceToGoal = foreignPlayers.get(random.nextInt(foreignPlayers.size()));
        int chanceForHome = random.nextInt(100);
        if (chanceForHome > 80) {
            playerWithChanceToGoal = homePlayers.get(random.nextInt(homePlayers.size()));
        }
        for (Player p: homePlayers){
            scoreHome += p.simulate(playerWithChanceToGoal);
        }
        for (Player p: foreignPlayers){
            scoreForeing += p.simulate(playerWithChanceToGoal);
        }
    }
}
