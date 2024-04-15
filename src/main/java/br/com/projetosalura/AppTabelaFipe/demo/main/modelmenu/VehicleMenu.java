package br.com.projetosalura.AppTabelaFipe.demo.main.modelmenu;

import br.com.projetosalura.AppTabelaFipe.demo.models.IModelType;
import br.com.projetosalura.AppTabelaFipe.demo.models.VehicleModel;

public class VehicleMenu implements IModelMenu{

    VehicleModel vehicleModel;

    public VehicleMenu(VehicleModel vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    @Override
    public VehicleMenu showMenu() {
        return null;
    }
    @Override
    public void showNextMenu(IModelType type) {

    }

    @Override
    public String getMenuName() {
        return null;
    }
}
