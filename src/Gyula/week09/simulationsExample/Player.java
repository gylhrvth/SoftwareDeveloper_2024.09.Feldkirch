package Gyula.week09.simulationsExample;

import java.util.Random;

public class Player {
    private enum State {
        RUNNING,
        RESTING,
        CELEBRATE,
    }

    private static Random random = new Random();
    private String name;
    private State state;
    private int timeToLeft;

    public Player(String name){
        this.name = name;
        this.state = State.RESTING;
        this.timeToLeft = 0;
    }

    public int simulate(Player goal){
        --timeToLeft;
        if (timeToLeft > 0) {
            return 0;
        }

        int goalCount = 0;
        switch (state){
            case RESTING -> {
                System.out.println(name + " starts running...");
                state = State.RUNNING;
                timeToLeft = random.nextInt(5, 10);
            }
            case RUNNING -> {
                int chanceForGoal = random.nextInt(100);
                if (this.equals(goal) && (chanceForGoal > 50)){
                    System.out.println(name + " SCOOOOOOOOOOR...");
                    state = State.CELEBRATE;
                    timeToLeft = 1;
                    goalCount = 1;
                } else {
                    System.out.println(name + " needs rest...");
                    state = State.RESTING;
                    timeToLeft = 1;
                }
            }
            case CELEBRATE -> {
                System.out.println(name + " after celebrating, need to rest");
                state = State.RESTING;
                timeToLeft = 1;
            }
        }
        return goalCount;
    }

    @Override
    public String toString() {
        return name;
    }
}
