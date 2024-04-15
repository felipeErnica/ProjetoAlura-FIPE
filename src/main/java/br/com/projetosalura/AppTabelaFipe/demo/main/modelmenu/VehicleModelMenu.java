package br.com.projetosalura.AppTabelaFipe.demo.main.modelmenu;

import br.com.projetosalura.AppTabelaFipe.demo.main.functions.CodeSelectionMenu;
import br.com.projetosalura.AppTabelaFipe.demo.main.MainMenu;
import br.com.projetosalura.AppTabelaFipe.demo.main.functions.SearchMenu;
import br.com.projetosalura.AppTabelaFipe.demo.models.Brand;
import br.com.projetosalura.AppTabelaFipe.demo.models.IModelType;
import br.com.projetosalura.AppTabelaFipe.demo.models.VehicleModel;
import br.com.projetosalura.AppTabelaFipe.demo.models.datacollector.ModelList;
import br.com.projetosalura.AppTabelaFipe.demo.tools.AddressConstructor;
import br.com.projetosalura.AppTabelaFipe.demo.tools.ApiConsumer;
import br.com.projetosalura.AppTabelaFipe.demo.tools.Serializer;

import java.util.List;
import java.util.Scanner;

public class VehicleModelMenu implements IModelMenu {

    private List<VehicleModel> modelList;
    private Brand brand;

    public VehicleModelMenu(Brand brand) {
        this.brand = brand;
    }
    @Override
    public VehicleModelMenu showMenu() {
        String json = ApiConsumer.getJson(AddressConstructor.getModelsApi(brand));;
        ModelList models = Serializer.serializeJson(json, ModelList.class);
        modelList = models.modelList().stream()
                .map(m -> new VehicleModel(m,brand))
                .toList();
        displayModels();
        return this;
    }

    @Override
    public void showNextMenu(IModelType type) {
        VehicleModel vehicleModel = (VehicleModel) type;
        VehicleMenu vehicleMenu =  new VehicleMenu(vehicleModel).showMenu();
    }

    @Override
    public String getMenuName() {
        return "Modelos";
    }

    private void displayModels(){
        modelList.forEach(System.out::println);
        System.out.println(
                """
                
                Escolha uma opção:
                1 - Selecionar Código
                2 - Pesquisar Nome do Modelo
                3 - Retornar ao Menu Principal
                
                """
        );

        String option = new Scanner(System.in).nextLine();
        switch (option) {
            case "1" -> CodeSelectionMenu.selectCode(modelList,this);
            case "2" -> SearchMenu.search(modelList,this);
            case "3" -> {
                MainMenu.showMenu();
                break;
            }
            default -> {
                System.out.println("Digite um valor válido!");
                displayModels();
            }
        }
    }



}
