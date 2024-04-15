package br.com.projetosalura.AppTabelaFipe.demo.main.functions;

import br.com.projetosalura.AppTabelaFipe.demo.main.MainMenu;
import br.com.projetosalura.AppTabelaFipe.demo.main.modelmenu.IModelMenu;
import br.com.projetosalura.AppTabelaFipe.demo.models.IModelType;
import java.util.List;
import java.util.Scanner;

public class SearchMenu {

    private static List<?> filteredList;
    private static IModelMenu modelMenu;

    public static <T extends IModelType> void search(List<T> searchableList, IModelMenu menu) {
        System.out.println("Digite o que deseja pesquisar:");
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
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Selecionar Código");
        System.out.println("2 - Mostrar " + modelMenu.getMenuName());
        System.out.println("3 - Retornar ao Menu Principal");


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
}
