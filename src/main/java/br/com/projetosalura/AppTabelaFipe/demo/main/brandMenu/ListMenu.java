package br.com.projetosalura.AppTabelaFipe.demo.main.brandMenu;

import br.com.projetosalura.AppTabelaFipe.demo.models.Brand;

import java.util.List;

public class ListMenu {

    public static void displayListMenu(List<Brand> brandList) {
        System.out.println(
            """
            Escolha uma opção:
            1 - Selecionar Código
            2 - Pesquisar Nome da Marca
            3 - Retornar ao Menu Principal
            """
        );




    }

}
