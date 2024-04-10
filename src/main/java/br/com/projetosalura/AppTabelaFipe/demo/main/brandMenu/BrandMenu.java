package br.com.projetosalura.AppTabelaFipe.demo.main.brandMenu;

import br.com.projetosalura.AppTabelaFipe.demo.models.Brand;
import br.com.projetosalura.AppTabelaFipe.demo.tools.DataCollector;
import br.com.projetosalura.AppTabelaFipe.demo.models.VehicleType;
import br.com.projetosalura.AppTabelaFipe.demo.tools.AddressConstructor;
import br.com.projetosalura.AppTabelaFipe.demo.tools.ApiConsumer;
import br.com.projetosalura.AppTabelaFipe.demo.tools.Serializer;

import java.util.List;

public class BrandMenu {
    public static void displayBrands (VehicleType vehicleType){

        String json = ApiConsumer.getJson(AddressConstructor.getBrandsApi(vehicleType));
        List<Brand> brandList = Serializer.serializeListJson(json);

        ListMenu.displayListMenu(brandList);
    }
}
