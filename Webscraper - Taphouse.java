// For at dette program kan køre skal Jsoup biblioteket integreres. 

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class TapHouseScraping {
    public static void main(String[] args) {
        try {
            final Document doc = Jsoup.connect("https://taphouse.dk/").get();

            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println(String.format("| %-40s | %-68s | %-30s | %-10s | %-8s | %-15s |", "Navn", "Øl", "Type", "ABV", "Stor", "Lille"));
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

            for (Element row : doc.select("table#beerTable tr")) {

                if (row.select("td:nth-of-type(1)").text().equals("")) {
                    continue;
                } else {
                    final String name = row.select("td:nth-of-type(2)").text();
                    final String beer = row.select("td:nth-of-type(3)").text();
                    final String type = row.select("td:nth-of-type(4)").text();
                    final String country = row.select("td:nth-of-type(5)").text();
                    final String abv = row.select("td:nth-of-type(6)").text();
                    final String stor = row.select("td:nth-of-type(7)").text();
                    final String lille = row.select("td:nth-of-type(8)").text();

                    System.out.println(String.format("| %-40s | %-68s | %-30s | %-10s | %-8s | %-10s|", name, beer, type, country, abv, stor, lille));
                }

            }
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
