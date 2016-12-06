package models;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by usuario on 5/12/16.
 */
public class BonoLotoModel {
    private List<Integer> winnerCombination;
    private List<Integer> smallNum;

    public Double totalBets=0.0;
    public Double collection=0.0;
    public Double jackpot=0.0;
    public Double prizes=0.0;

    public BonoLotoModel() {
        this.winnerCombination = new ArrayList<Integer>();
        this.smallNum = new ArrayList<Integer>();
    }

    public boolean addSmallNum(Integer integer) {
        return smallNum.add(integer);
    }

    public boolean addNumber(Integer integer) {
        return winnerCombination.add(integer);
    }

    @Override
    public String toString() {
        return "EuroMillonesModel{" + "\n" +
                "winnerCombination=" + winnerCombination + "\n" +
                ", stars=" + smallNum + "\n" +
                ", totalBets=" + String.format("%.2f",totalBets) + "\n" +
                ", collection=" + String.format("%.2f",collection) + "\n" +
                ", jackpot=" + String.format("%.2f",jackpot) + "\n" +
                ", prizes=" + String.format("%.2f",prizes) + "\n" +
                '}';
    }

    public void getLastResult() throws IOException {
        // Visit web euromillons
        String url="http://www.loteriasyapuestas.es/es/bonoloto";
        Document doc = Jsoup.connect(url).get();
        // Get url for last result with details
        Element ele = doc.getElementById("lastResultsTitleLink");
        url = ele.attr("abs:href");
        doc = Jsoup.connect(url).get(); // Visit web and extract info
        Element link = doc.getElementsByClass("cuerpoRegionSup").last();
        Elements datos = link.getElementsByTag("p");

        //Get interesting info about bets
        this.totalBets=getDouble(datos.get(0).text());
        this.collection=getDouble(datos.get(1).text());
        this.jackpot=getDouble(datos.get(2).text());
        this.prizes=getDouble(datos.get(3).text());

        //Get Winner combination
        link = doc.getElementById("mainNumbers");
        datos = link.getElementsByTag("li");

        for (Element dato : datos) {
            this.addNumber(Integer.parseInt(dato.text()));
        }

        //Get Stars
        datos = doc.getElementsByClass("bolapeq");
        for (Element dato:datos) {
            this.addSmallNum(Integer.parseInt(dato.text()));
        }
    }

    public static Double getDouble (String str){
        str = str.replaceAll("[^0-9 | ^\\,]", "").replace(",",".");
        return Double.parseDouble(str);
    }
}
