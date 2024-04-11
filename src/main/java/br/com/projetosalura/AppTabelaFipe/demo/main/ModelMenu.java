package br.com.projetosalura.AppTabelaFipe.demo.main;

import br.com.projetosalura.AppTabelaFipe.demo.models.Brand;
import br.com.projetosalura.AppTabelaFipe.demo.models.ModelList;
import br.com.projetosalura.AppTabelaFipe.demo.models.VehicleModel;
import br.com.projetosalura.AppTabelaFipe.demo.tools.AddressConstructor;
import br.com.projetosalura.AppTabelaFipe.demo.tools.ApiConsumer;
import br.com.projetosalura.AppTabelaFipe.demo.tools.DataCollector;
import br.com.projetosalura.AppTabelaFipe.demo.tools.Serializer;

import javax.swing.*;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ModelMenu {

    private List<VehicleModel> modelList;

    public ModelMenu(Brand brand) {
        String json = ApiConsumer.getJson(AddressConstructor.getModelsApi(brand));;
        ModelList models = Serializer.serializeJson(json, ModelList.class);
        List<VehicleModel> listModel = models.modelList().stream()
                .map(d -> new VehicleModel(d,brand))
                .sorted()
                .toList();
    }

    public void displayModels(){
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
            case "1": selectCode();
            case "2": searchModel();
            case "3": MainMenu.showMenu();
            default:
                System.out.println("Digite um valor válido!");
                displayModels();
        }
    }

    private void selectCode() {
        System.out.println("Digite o Código:");
        int code = new Scanner(System.in).nextInt();

        Optional<VehicleModel> modelOptional = modelList.stream()
                .filter(b -> code == b.getModelCode())
                .findFirst();
        if (modelOptional.isEmpty()){
            searchNotFound();
        } else {
            VehicleModel model = modelOptional.get();
        }

    }

    private void searchModel() {
        System.out.println("Digite o que deseja pesquisar:");
        String search = new Scanner(System.in).nextLine().toUpperCase();
        List<VehicleModel> filteredList = modelList.stream()
                .filter(m -> m.getModelName().toUpperCase().contains(search))
                .sorted()
                .toList();

        if (filteredList.isEmpty()) {
            searchNotFound();
        } else {
            displayModelsFiltered(filteredList);
        }
    }

    private void displayModelsFiltered(List<VehicleModel> filteredList) {
        filteredList.forEach(System.out::println);
        System.out.println(
                """
                
                Escolha uma opção:
                1 - Selecionar Código
                2 - Mostrar todas os Modelos
                3 - Retornar ao Menu Principal
                """
        );

        String option = new Scanner(System.in).nextLine();
        switch (option) {
            case "1": selectCode();
            case "2": displayModels();
            case "3": MainMenu.showMenu();
            default:
                System.out.println("Digite um valor válido!");
                displayModelsFiltered(filteredList);
        }
    }

    private void searchNotFound() {
        System.out.println("Não foi possível encontrar este modelo!");
        System.out.println(
                """
                Escolha uma opção:
                1 - Mostrar Modelos
                2 - Retornar ao Menu Principal
                """
        );

        String option = new Scanner(System.in).nextLine();
        switch (option) {
            case "1": displayModels();
            case "2": MainMenu.showMenu();
            default:
                System.out.println("Digite um valor válido!");
                searchNotFound();
        }
    }

}
