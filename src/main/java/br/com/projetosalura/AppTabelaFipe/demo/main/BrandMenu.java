package br.com.projetosalura.AppTabelaFipe.demo.main;

import br.com.projetosalura.AppTabelaFipe.demo.models.Brand;
import br.com.projetosalura.AppTabelaFipe.demo.tools.AddressConstructor;
import br.com.projetosalura.AppTabelaFipe.demo.tools.ApiConsumer;
import br.com.projetosalura.AppTabelaFipe.demo.tools.Serializer;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class BrandMenu {

    private List<Brand> brandList;

    public BrandMenu(String vehicleType) {
        String json = ApiConsumer.getJson(AddressConstructor.getBrandsApi(vehicleType));;
        this.brandList = Serializer.serializeListJson(json).stream()
                .map(d -> new Brand(d.code(), d.name(),vehicleType))
                .sorted()
                .toList();
    }

    public void displayBrands (){
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
            case "1": selectCode();
            case "2": searchBrand();
            case "3": MainMenu.showMenu();
            default:
                System.out.println("Digite um valor válido!");
                displayBrands();
        }
    }

    private void selectCode() {
        System.out.println("Digite o Código:");
        int code = new Scanner(System.in).nextInt();

        Optional<Brand> optionalBrand = brandList.stream()
                .filter(b -> code == b.getBrandCode())
                .findFirst();
        if (optionalBrand.isEmpty()){
            searchNotFound();
        } else {
            Brand brand = optionalBrand.get();
            ModelMenu modelMenu = new ModelMenu(brand);
            modelMenu.displayModels();
        }

    }

    private void searchBrand() {
        System.out.println("Digite o que deseja pesquisar:");
        String search = new Scanner(System.in).nextLine().toUpperCase();
        List<Brand> filteredList = brandList.stream()
                .filter(b -> b.getBrandName().toUpperCase().contains(search))
                .sorted()
                .toList();

        if (filteredList.isEmpty()) {
            searchNotFound();
        } else {
            displayBandsFiltered(filteredList);
        }
    }

    private void displayBandsFiltered(List<Brand> filteredList) {
        filteredList.forEach(System.out::println);
        System.out.println(
                """
                
                Escolha uma opção:
                1 - Selecionar Código
                2 - Mostrar todas as Marcas
                3 - Retornar ao Menu Principal
                """
        );

        String option = new Scanner(System.in).nextLine();
        switch (option) {
            case "1": selectCode();
            case "2": displayBrands();
            case "3": MainMenu.showMenu();
            default:
                System.out.println("Digite um valor válido!");
                displayBandsFiltered(filteredList);
        }
    }

    private void searchNotFound() {
        System.out.println("Não foi possível encontrar esta marca!");
        System.out.println(
                """
                Escolha uma opção:
                1 - Mostrar Marcas
                2 - Retornar ao Menu Principal
                """
        );

        String option = new Scanner(System.in).nextLine();
        switch (option) {
            case "1": displayBrands();
            case "2": MainMenu.showMenu();
            default:
                System.out.println("Digite um valor válido!");
                searchNotFound();
        }
    }

}

