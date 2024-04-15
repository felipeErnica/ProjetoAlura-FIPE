package br.com.projetosalura.AppTabelaFipe.demo.main.functions;

import br.com.projetosalura.AppTabelaFipe.demo.main.MainMenu;
import br.com.projetosalura.AppTabelaFipe.demo.main.modelmenu.IModelMenu;
import br.com.projetosalura.AppTabelaFipe.demo.main.modelmenu.VehicleMenu;
import br.com.projetosalura.AppTabelaFipe.demo.models.IModelType;
import br.com.projetosalura.AppTabelaFipe.demo.models.Vehicle;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class SearchMenu {

    private static List<?> filteredList;
    private static IModelMenu modelMenu;

    public static <T extends IModelType> void search(List<T> searchableList, IModelMenu menu) {
        System.out.println("\nDigite o que deseja pesquisar:");
        String search = new Scanner(System.in).nextLine().toUpperCase();
        modelMenu = menu;
        filteredList = searchableList.stream()
                .filter(t -> t.getName().toUpperCase().contains(search))
                .sorted()
                .toList();

        if (filteredList.isEmpty()) {
            SearchNotFoundResponse.showOptions(menu);
        } else {
            displayFilteredList();
        }
    }

    private static  <T extends IModelType> void displayFilteredList() {
        filteredList.forEach(System.out::println);
        System.out.println("\nEscolha uma opção:");
        System.out.println("1 - Selecionar Código");
        System.out.println("2 - Mostrar " + modelMenu.getMenuName());
        System.out.println("3 - Retornar ao Menu Principal\n");


        String option = new Scanner(System.in).nextLine();
        switch (option) {
            case "1"-> {
                List<T> castedList = (List<T>) filteredList;
                CodeSelectionMenu.selectCode(castedList, modelMenu);
            }
            case "2"-> modelMenu.showMenu();
            case "3"-> MainMenu.showMenu();
            default-> {
                System.out.println("Digite um valor válido!");
                displayFilteredList();
            }
        }
    }

    public static void fuelTypeFilter (List<Vehicle> searchableList, VehicleMenu menu) {
        modelMenu = menu;
        System.out.println("\nEscolha uma opção:");
        System.out.println("1 - Gasolina");
        System.out.println("2 - Diesel");
        System.out.println("3 - Etanol\n");

        String option = new Scanner(System.in).nextLine();

        switch (option) {
            case "1" -> {
                filteredList = searchableList.stream()
                        .filter(v -> v.getFuelType().equals("Gasolina"))
                        .toList();
            }
            case "2" -> {
                filteredList = searchableList.stream()
                        .filter(v -> v.getFuelType().equals("Diesel"))
                        .toList();
            }

            case "3" -> {
                filteredList = searchableList.stream()
                        .filter(v -> v.getFuelType().equals("Etanol"))
                        .toList();
            }
            default -> {
                System.out.println("Digite um valor válido!");
                fuelTypeFilter(searchableList, menu);
            }
        }

        if (filteredList.isEmpty()) {
            SearchNotFoundResponse.showOptions(menu);
        } else {
            displayFilteredList();
        }
    }

    public static void orderByPrice (List<Vehicle> searchableList, VehicleMenu menu) {
        modelMenu = menu;
        System.out.println("\nEscolha uma opção:");
        System.out.println("1 - Ordenar por Mais Caro");
        System.out.println("2 - Ordenar por Mais Barato\n");

        String option = new Scanner(System.in).nextLine();

        switch (option) {
            case "1" -> {
                filteredList = searchableList.stream()
                        .sorted(Comparator.comparing(Vehicle::getVehiclePrice).reversed())
                        .toList();
            }
            case "2" -> {
                filteredList = searchableList.stream()
                        .sorted(Comparator.comparing(Vehicle::getVehiclePrice))
                        .toList();
            }
            default -> {
                System.out.println("Digite um valor válido!");
                fuelTypeFilter(searchableList, menu);
            }
        }
        displayFilteredList();
    }
}
