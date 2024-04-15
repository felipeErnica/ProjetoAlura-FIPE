package br.com.projetosalura.AppTabelaFipe.demo.main.functions;

import br.com.projetosalura.AppTabelaFipe.demo.main.modelmenu.IModelMenu;
import br.com.projetosalura.AppTabelaFipe.demo.models.IModelType;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class CodeSelectionMenu {

    public static <T extends IModelType> void selectCode(List<T> menuList, IModelMenu menu) {
        System.out.println("\nDigite o Código:");
        int code = new Scanner(System.in).nextInt();

        Optional<T> modelOptional = menuList.stream()
                .filter(b -> code == b.getCode())
                .findFirst();
        if (modelOptional.isEmpty()){
            SearchNotFoundResponse.showOptions(menu);
        } else {
            T model = modelOptional.get();
            menu.showNextMenu(model);
        }
    }


}
