package br.com.projetosalura.AppTabelaFipe.demo.main.modelmenu;

import br.com.projetosalura.AppTabelaFipe.demo.main.MainMenu;
import br.com.projetosalura.AppTabelaFipe.demo.main.functions.CodeSelectionMenu;
import br.com.projetosalura.AppTabelaFipe.demo.main.functions.SearchMenu;
import br.com.projetosalura.AppTabelaFipe.demo.models.Brand;
import br.com.projetosalura.AppTabelaFipe.demo.models.IModelType;
import br.com.projetosalura.AppTabelaFipe.demo.models.datacollector.BrandData;
import br.com.projetosalura.AppTabelaFipe.demo.tools.AddressConstructor;
import br.com.projetosalura.AppTabelaFipe.demo.tools.ApiConsumer;
import br.com.projetosalura.AppTabelaFipe.demo.tools.Serializer;

import java.util.List;
import java.util.Scanner;

public class BrandMenu implements IModelMenu {

    private List<Brand> brandList;
    private String vehicleType;

    public BrandMenu(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    @Override
    public BrandMenu showMenu() {
        String json = ApiConsumer.getJson(AddressConstructor.getBrandsApi(vehicleType));
        List<BrandData> brandDataList = Serializer.serializeListJson(json,BrandData.class);
        this.brandList = brandDataList.stream().map(b -> new Brand(b,vehicleType)).toList();
        displayBrands();
        return this;
    }

    private void displayBrands (){
        brandList.forEach(System.out::println);
        System.out.println(
                """
                
                Escolha uma opção:
                1 - Selecionar Código
                2 - Pesquisar Nome da Marca
                3 - Retornar ao Menu Principal
                
                """
        );

        String option = new Scanner(System.in).nextLine();
        switch (option) {
            case "1" -> CodeSelectionMenu.selectCode(brandList,this);
            case "2" -> SearchMenu.search(brandList,this);
            case "3" -> MainMenu.showMenu();
            default -> {
                System.out.println("Digite um valor válido!");
                displayBrands();
            }
        }
    }

    @Override
    public  void showNextMenu(IModelType type) {
        Brand brand = (Brand) type;
        VehicleModelMenu modelMenu = new VehicleModelMenu(brand).showMenu();
    }

    @Override
    public String getMenuName() {
        return "Marcas";
    }
}

