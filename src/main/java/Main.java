import models.EuroMillonesModel;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;


/**
 * Created by usuario on 5/12/16.
 */


public class Main {
    public static Double getDouble (String str){
        str = str.replaceAll("[^0-9 | ^\\,]", "").replace(",",".");
        return Double.parseDouble(str);
    }
    public static void main(String[] args) throws IOException {

        // Visita la web de euromillones
        String url="http://www.loteriasyapuestas.es/es/euromillones";
        Document doc = Jsoup.connect(url).get();
        // Obtenemos la url de la web para ultimo resultado con detalles
        Element ele = doc.getElementById("lastResultsTitleLink");
        url = ele.attr("abs:href");
        doc = Jsoup.connect(url).get(); // visitamos la pagina y extraemos datos de interes
        Element link = doc.getElementsByClass("cuerpoRegionSup").last();
        Elements datos = link.getElementsByTag("p");
        EuroMillonesModel euroMillonesModel = new EuroMillonesModel();

        // Extraccion de cuerpoRegionSup
        System.out.print("Info Adicional Premios:\n");
        System.out.println("---------------------");

        //Extraccion de info sobre apuestas
        euroMillonesModel.totalBets=getDouble(datos.get(0).text());
        euroMillonesModel.collection=getDouble(datos.get(1).text());
        euroMillonesModel.jackpot=getDouble(datos.get(2).text());
        euroMillonesModel.prizes=getDouble(datos.get(3).text());

        //Extraccion de combinacion ganadora
        link = doc.getElementById("mainNumbers");
        datos = link.getElementsByTag("li");
        System.out.println("\nCombinación ganadora:");
        System.out.println("---------------------");
        for (Element dato : datos) {
            euroMillonesModel.addNumber(Integer.getInteger(dato.text().replaceAll("[^0-9 | ^\\,]", "")));
            System.out.printf("%s\n",dato.text());
        }
        System.out.println("\nEstrellas:");
        System.out.println("---------------------");
        link = doc.getElementById("stars");
        datos = link.getElementsByTag("li");
        for (Element dato:datos) {
            euroMillonesModel.addStar(Integer.getInteger(dato.text().replaceAll("[^0-9 | ^\\,]", "")));
            System.out.printf("%s\n",dato.text());
        }

        System.out.println(euroMillonesModel);
    }
}
