package br.com.projetosalura.AppTabelaFipe.demo.main;

import br.com.projetosalura.AppTabelaFipe.demo.main.modelmenu.BrandMenu;

import java.util.Scanner;

public class MainMenu {

    public static void showMenu() {
        System.out.println("""
            
            Selecione um Tipo de Veículo:
            1 - Carros
            2 - Motos
            3 - Caminhões
            4 - Sair
            """);
        String option = new Scanner(System.in).nextLine();

        BrandMenu brandMenu;

        switch (option) {
            case "1" -> brandMenu = new BrandMenu("carros").showMenu();
            case "2" -> brandMenu = new BrandMenu("motos").showMenu();
            case "3"-> brandMenu = new BrandMenu("caminhoes").showMenu();
            case "4"-> finalizeApp();
            default-> System.out.println("Digite um valor válido!");
        }

    }

    public static void finalizeApp(){
        System.out.println("Obrigado!");
    }

}
