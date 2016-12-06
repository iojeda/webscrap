import models.BonoLotoModel;
import models.EuroMillonesModel;
import models.GordoPrimitivaModel;
import models.PrimitivaModel;

import java.io.IOException;


/**
 * Created by usuario on 5/12/16.
 */


public class Main {
    public static void main(String[] args) throws IOException {

        EuroMillonesModel euroMillonesModel = new EuroMillonesModel();
        BonoLotoModel bonoLotoModel = new BonoLotoModel();
        GordoPrimitivaModel gordoPrimitivaModel = new GordoPrimitivaModel();
        PrimitivaModel primitivaModel = new PrimitivaModel();
        euroMillonesModel.getLastResult();
        bonoLotoModel.getLastResult();
        gordoPrimitivaModel.getLastResult();
        primitivaModel.getLastResult();
        System.out.println(euroMillonesModel);
        System.out.println(bonoLotoModel);
        System.out.println(gordoPrimitivaModel);
        System.out.println(primitivaModel);
    }
}
