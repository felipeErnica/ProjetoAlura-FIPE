package br.com.projetosalura.AppTabelaFipe.demo.tools;

import br.com.projetosalura.AppTabelaFipe.demo.models.Brand;
import br.com.projetosalura.AppTabelaFipe.demo.models.VehicleModel;
import br.com.projetosalura.AppTabelaFipe.demo.models.VehicleType;


public class AddressConstructor {

    private static final String MAIN_BODY = "https://parallelum.com.br/fipe/api/v1/";

    public static String getBrandsApi(VehicleType vehicleType) {
        return MAIN_BODY + vehicleType.getType() + "/marcas/";
    }

    public static String getModelsApi(Brand brand) {
        return MAIN_BODY + brand.getType() + "/marcas/" + brand.getBrandCode() + "/modelos";
    }

    public static String getVehiclesApi(VehicleModel vehicleModel) {
        return MAIN_BODY + vehicleModel.getType() +"/marcas/" + vehicleModel.getBrandCode() +
                "/modelos/" + vehicleModel.getModelCode() + "/anos" ;
    }

}
