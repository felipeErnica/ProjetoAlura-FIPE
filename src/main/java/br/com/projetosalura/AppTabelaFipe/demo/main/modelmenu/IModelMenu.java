package br.com.projetosalura.AppTabelaFipe.demo.main.modelmenu;

import br.com.projetosalura.AppTabelaFipe.demo.models.IModelType;

public interface IModelMenu {
    IModelMenu showMenu();
    void showNextMenu(IModelType type);
    String getMenuName();
}
