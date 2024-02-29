import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.sql.*;

public class TapHouseScraping {
    public static void main(String[] args) {
        try {
            final Document doc = Jsoup.connect("https://taphouse.dk/").get();

            String url = "jdbc:postgresql://abul.db.elephantsql.com:5432/blfjvdcv";
            String username = "blfjvdcv";
            String password = "vNiS9pUpbB0kvXPdrbmh1G6lCEtQK0sm";

            try (Connection db = DriverManager.getConnection(url, username, password)) {
                createBeerDataTable(db);

                insertDataIntoBeerDataTable(db, doc);

            } catch (SQLException e) {
                System.out.println("SQL Exception: " + e.getMessage());
                e.printStackTrace();
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    private static void createBeerDataTable(Connection db) throws SQLException{
        String createTableSql = "CREATE TABLE IF NOT EXISTS beer_data (" +
                "id SERIAL PRIMARY KEY," +
                "name VARCHAR(255)," +
                "beer VARCHAR(255)," +
                "type VARCHAR(255)," +
                "country VARCHAR(255)," +
                "abv VARCHAR(255)," +
                "stor VARCHAR(255)," +
                "lille VARCHAR(255)" +
                ")";
        try (Statement stmt = db.createStatement()){
            stmt.executeUpdate(createTableSql);
        }
    }
    private static void insertDataIntoBeerDataTable(Connection db, Document doc) throws SQLException{

        for (Element row : doc.select("table#beerTable tr")){
            if (!row.select("td:nth-of-type(1)").text().isEmpty()) {

                final String Name = row.select("td:nth-of-type(2)").text();
                final String Brewery = row.select("td:nth-of-type(3)").text();
                final String Type = row.select("td:nth-of-type(4)").text();
                final String Country = row.select("td:nth-of-type(5)").text();
                final String ABV = row.select("td:nth-of-type(6)").text();
                final String Large = row.select("td:nth-of-type(7)").text() + " kr";
                final String Small = row.select("td:nth-of-type(8)").text() + " kr";

                String sql = "INSERT INTO beer_data (name, beer, type, country, abv, stor, lille) VALUES( ?, ?, ?, ?, ?, ?, ?)";
                try (PreparedStatement pstmt = db.prepareStatement(sql)){
                    pstmt.setString(1, Name);
                    pstmt.setString(2, Brewery);
                    pstmt.setString(3, Type);
                    pstmt.setString(4, Country);
                    pstmt.setString(5, ABV);
                    pstmt.setString(6, Large);
                    pstmt.setString(7, Small);
                    pstmt.executeUpdate();
                }
            }
        }
    }
}















//            for (Element row : doc.select("table#beerTable tr")) {
//
//                if (row.select("td:nth-of-type(1)").text().equals("")) {
//                    continue;
//                } else {
//                    final String name = row.select("td:nth-of-type(2)").text();
//                    final String beer = row.select("td:nth-of-type(3)").text();
//                    final String type = row.select("td:nth-of-type(4)").text();
//                    final String country = row.select("td:nth-of-type(5)").text();
//                    final String abv = row.select("td:nth-of-type(6)").text();
//                    final String stor = row.select("td:nth-of-type(7)").text();
//                    final String lille = row.select("td:nth-of-type(8)").text();
//
//                    String sql = "INSERT INTO beer_data (name, beer, type, country, abv, stor, lille) VALUES (?, ?, ?, ?, ?, ?, ?)";
//
//                    try {
//                        Class.forName("org.postgresql.Driver");
//                    } catch (ClassNotFoundException e) {
//                        System.out.println("PostgreSQL JDBC driver not found.");
//                        e.printStackTrace();
//                        return;
//                    }
//
//                }
//            }
//            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
//        } catch (Exception ex) {
//            ex.printStackTrace();
