import models.EuroMillonesModel;
import java.io.IOException;


/**
 * Created by usuario on 5/12/16.
 */


public class Main {
    public static void main(String[] args) throws IOException {

        EuroMillonesModel euroMillonesModel = new EuroMillonesModel();
        euroMillonesModel.getLastResult();
        System.out.println(euroMillonesModel);
    }
}
