package br.com.projetosalura.AppTabelaFipe.demo.tools;

import br.com.projetosalura.AppTabelaFipe.demo.models.Brand;
import br.com.projetosalura.AppTabelaFipe.demo.models.VehicleModel;


public class AddressConstructor {

    private static final String MAIN_BODY = "https://parallelum.com.br/fipe/api/v1/";

    public static String getBrandsApi(String vehicleType) {
        return MAIN_BODY + vehicleType + "/marcas/";
    }

    public static String getModelsApi(Brand brand) {
        return MAIN_BODY + brand.getType() + "/marcas/" + brand.getCode() + "/modelos";
    }

    public static String getVehiclesApi(VehicleModel vehicleModel) {
        return MAIN_BODY + vehicleModel.getType() +"/marcas/" + vehicleModel.getBrandCode() +
                "/modelos/" + vehicleModel.getModelCode() + "/anos" ;
    }

}
