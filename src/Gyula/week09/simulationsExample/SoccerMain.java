package Gyula.week09.simulationsExample;

public class SoccerMain {
    public static void main(String[] args) {
        SoccerGame game = new SoccerGame("Training");

        game.addPlayer(new Player("Aylin"), true);
        game.addPlayer(new Player("Erik"), true);
        game.addPlayer(new Player("Thiemo"), true);
        game.addPlayer(new Player("Furkan"), true);
        game.addPlayer(new Player("Aki"), true);
        game.addPlayer(new Player("Sandro"), false);
        game.addPlayer(new Player("Gyula"), false);


        game.resetScore();
        for (int minute = 0; minute <= 90; ++minute) {
            game.simulateMinute(minute);
        }
        game.printResult();
    }
}
