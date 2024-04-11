package br.com.projetosalura.AppTabelaFipe.demo.main;

import java.util.Scanner;

public class MainMenu {

    public static void showMenu() {
        System.out.println("""
            
            "Selecione um Tipo de Veículo:"
            1 - Carros
            2 - Motos
            3 - Caminhões
            4 - Sair
            """);
        String option = new Scanner(System.in).nextLine();

        BrandMenu brandMenu;

        switch (option) {
            case "1":
                brandMenu =  new BrandMenu("carros");
                brandMenu.displayBrands();
                break;
            case "2":
                brandMenu =  new BrandMenu("motos");
                brandMenu.displayBrands();
                break;
            case "3":
                brandMenu =  new BrandMenu("caminhoes");
                brandMenu.displayBrands();
                break;
            case "4":
                break;
            default: System.out.println("Digite um valor válido!");
        }

    }

}
