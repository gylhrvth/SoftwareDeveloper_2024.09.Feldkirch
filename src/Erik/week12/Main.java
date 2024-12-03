package Erik.week12;

import java.sql.*;

// TODO: Connect DB, SELECT FROM TABLE, Initialize the Object in Java

public class Main {

    public static void main(String[] args) throws SQLException {

        // Datenbank auslesen und objekte erstellen in DB Manager


        DBManager.getInstance().createActorOOP();




        DBManager.getInstance().createMovieOOP();

















        DBManager.getInstance().closeConnection();


//        Connection conn = DBManager.getInstance().getConnection();
//
//        try {
//            PreparedStatement ps = conn.prepareStatement("select * from film f");
//
//            ResultSet rs = ps.executeQuery();
//
//            Actor actorErik = new Actor(1, "Erik", 23, 200, 103);
//            Actor actorThiemo = new Actor(1, "Thiemo", 27, 180, 80);
//            Film lifeOfErik = new Film(1, "Life of Erik", actorThiemo);
//
//            // Actor hinzufügen
//            lifeOfErik.addActor(actorThiemo);
//            lifeOfErik.addActor(actorErik);
//
//            // Film Actor und Regie Hinzufügen
//            actorThiemo.addFilmAsActor(lifeOfErik);
//            actorThiemo.addFilmAsRegie(lifeOfErik);
//
//
//            // Methoden Aufrufen
//            System.out.println("Struktur:");
//            lifeOfErik.printStructure();
//            System.out.println("-".repeat(50));
//            System.out.println("Liste:");
//            printQuery(rs);
//
//
//            ps.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        DBManager.getInstance().closeConnection();

    }

/*
    public static int[] getOptimalColumnWidth(ResultSet rs) throws SQLException {
        ResultSetMetaData metaData = rs.getMetaData();
        int[] optimalColWidth = new int[1 + metaData.getColumnCount()];

        for (int i = 1; i < optimalColWidth.length; i++) {
            optimalColWidth[i] = Math.max(
                    metaData.getColumnLabel(i).length(),
                    metaData.getColumnDisplaySize(i));
        }
        return optimalColWidth;
    }

    public static void printQuery(ResultSet rs) throws SQLException {
        ResultSetMetaData metaData = rs.getMetaData();
        int[] optimalColWidth = getOptimalColumnWidth(rs);

        while (rs.next()) {

            for (int col = 1; col <= metaData.getColumnCount(); col++) {

                if (metaData.getColumnType(col) == Types.VARCHAR) {
                    System.out.printf("| %-" + optimalColWidth[col] + "s ", rs.getString(col));
                } else {
                    System.out.printf("| %" + optimalColWidth[col] + "s ", rs.getString(col));
                }
            }
            System.out.println("|");
        }
    }


 */
}