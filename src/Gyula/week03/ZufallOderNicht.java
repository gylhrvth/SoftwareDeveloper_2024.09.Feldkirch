package Gyula.week03;

import java.util.Random;

public class ZufallOderNicht {
    public static Random random = new Random();

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(random.nextInt(101));
        }
    }
}
