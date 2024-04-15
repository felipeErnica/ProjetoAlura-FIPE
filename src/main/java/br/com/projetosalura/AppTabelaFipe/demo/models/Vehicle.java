package br.com.projetosalura.AppTabelaFipe.demo.models;

import br.com.projetosalura.AppTabelaFipe.demo.models.datacollector.ModelData;
import br.com.projetosalura.AppTabelaFipe.demo.models.datacollector.VehicleData;

public class Vehicle implements IModelType  {

    private VehicleModel vehicleModel;
    private long code;
    private long year;
    private String fuelType;
    private double vehiclePrice;

    public Vehicle(VehicleData vehicleData, VehicleModel vehicleModel, String  code) {
        this.vehicleModel = vehicleModel;
        this.vehiclePrice = vehicleData.price();
        this.fuelType = vehicleData.fuel();
        this.year = vehicleData.year();
        this.code = Long.parseLong(code);
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public int getCode() {
        return 0;
    }
}
