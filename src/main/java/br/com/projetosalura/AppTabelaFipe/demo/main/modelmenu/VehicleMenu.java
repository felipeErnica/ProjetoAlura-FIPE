package br.com.projetosalura.AppTabelaFipe.demo.main.modelmenu;

import br.com.projetosalura.AppTabelaFipe.demo.main.MainMenu;
import br.com.projetosalura.AppTabelaFipe.demo.main.functions.CodeSelectionMenu;
import br.com.projetosalura.AppTabelaFipe.demo.main.functions.SearchMenu;
import br.com.projetosalura.AppTabelaFipe.demo.models.IModelType;
import br.com.projetosalura.AppTabelaFipe.demo.models.Vehicle;
import br.com.projetosalura.AppTabelaFipe.demo.models.VehicleModel;
import br.com.projetosalura.AppTabelaFipe.demo.models.datacollector.ModelYearData;
import br.com.projetosalura.AppTabelaFipe.demo.models.datacollector.VehicleData;
import br.com.projetosalura.AppTabelaFipe.demo.tools.AddressConstructor;
import br.com.projetosalura.AppTabelaFipe.demo.tools.ApiConsumer;
import br.com.projetosalura.AppTabelaFipe.demo.tools.Serializer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VehicleMenu implements IModelMenu {

    VehicleModel vehicleModel;
    List<Vehicle> vehicleList;

    public VehicleMenu(VehicleModel vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    @Override
    public VehicleMenu showMenu() {
        String json = ApiConsumer.getJson(AddressConstructor.getVehiclesYearApi(vehicleModel));
        List<ModelYearData> modelYearDataList = Serializer.serializeListJson(json, ModelYearData.class);

        int vehicleIndex = 0;
        vehicleList = new ArrayList<Vehicle>();

        for ( ModelYearData modelYear : modelYearDataList){
            String yearCode = modelYear.code();
            json = ApiConsumer.getJson(AddressConstructor.getVehiclesApi(vehicleModel,yearCode));
            VehicleData vehicleData = Serializer.serializeJson(json,VehicleData.class);
            String vehicleCode =  String.valueOf(vehicleModel.getCode()) + String.valueOf(vehicleIndex);
            Vehicle vehicle = new Vehicle(vehicleData,vehicleModel,vehicleCode);
            vehicleList.add(vehicle);
            vehicleIndex++;
        }

        displayVehicles();
        return this;
    }

    private void displayVehicles(){
        vehicleList.forEach(System.out::println);
        System.out.println(
                """
                
                Escolha uma opção:
                1 - Selecionar Código
                2 - Ordenar por Preço
                4 - Filtrar por Tipo de Combustível
                5 - Retornar ao Menu Principal
                
                """
        );

        String option = new Scanner(System.in).nextLine();
        switch (option) {
            case "1" -> CodeSelectionMenu.selectCode(vehicleList,this);
            case "2" ->SearchMenu.orderByPrice(vehicleList,this);
            case "3" -> SearchMenu.fuelTypeFilter(vehicleList,this);
            case "5" -> MainMenu.showMenu();
            default -> {
                System.out.println("Digite um valor válido!");
                displayVehicles();
            }
        }
    }


    @Override
    public void showNextMenu(IModelType type) {
        Vehicle vehicle = (Vehicle) type;
        System.out.println("\nValor: " + vehicle.getVehiclePrice());
        System.out.println("Marca: " + vehicle.getBrand());
        System.out.println("Modelo: " + vehicle.getModel());
        System.out.println("Ano do Modelo: " + vehicle.getYear());
        System.out.println("Combustivel: " + vehicle.getFuelType() + "\n");

        System.out.println("Escolha uma opção:");
        System.out.println("1 - Exibe Veículos");
        System.out.println("2 - Retornar ao Menu Principal");
        System.out.println("3 - Encerrar\n");

        String option = new Scanner(System.in).nextLine();
        switch (option) {
            case "1" -> displayVehicles();
            case "2" -> MainMenu.showMenu();
            case "3" -> MainMenu.finalizeApp();
            default -> {
                System.out.println("Digite um valor válido!\n");
                displayVehicles();
            }
        }
    }

    @Override
    public String getMenuName() {
        return "Veículos";
    }
}
