package Gyula.week08;

public class EnumExample {
    public static int PLANNED = 1;
    public static int PRODUCTION = 2;
    public static int RELEASED = 3;

    enum SerieStatus{
        PLANNED,
        PRODUCTION,
        RELEASED,
        STOPPED
    }

    public static void main(String[] args) {
        int serieStatus = PLANNED;
        serieStatus = 8;

        SerieStatus serieStatus2 = SerieStatus.PLANNED;
        // serieStatus2 = 8;   <=== Geht nicht

        switch (serieStatus2){
            case PLANNED ->
                    System.out.println("Planed");
            case PRODUCTION ->
                    System.out.println("Production");
            case RELEASED ->
                    System.out.println("Released");
            default ->
                    System.out.println("Stopped Production");
        }

        switch (serieStatus2){
            case PLANNED:
                System.out.println("Planed");
                break;
            case PRODUCTION:
                System.out.println("Production");
                break;
            case RELEASED:
                System.out.println("Released");
                break;
            default:
                System.out.println("Stopped Production");
                break;
        }
    }
}
