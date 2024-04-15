package br.com.projetosalura.AppTabelaFipe.demo.main.functions;

import br.com.projetosalura.AppTabelaFipe.demo.main.MainMenu;
import br.com.projetosalura.AppTabelaFipe.demo.main.modelmenu.IModelMenu;

import java.util.Scanner;

public class SearchNotFoundResponse {
    public static void showOptions(IModelMenu menu) {
        System.out.println("\nNão foi possível encontrar esta pesquisa!");
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Mostrar " + menu.getMenuName() );
        System.out.println("2 - Retornar ao Menu Principal\n");

        String option = new Scanner(System.in).nextLine();
        switch (option) {
            case "1"-> menu.showMenu();
            case "2"-> MainMenu.showMenu();
            default-> {
                System.out.println("Digite um valor válido!");
                showOptions(menu);
            }
        }
    }

}
