package br.com.projetosalura.AppTabelaFipe.demo.models;

import br.com.projetosalura.AppTabelaFipe.demo.tools.DataCollector;

import java.util.List;

public class Brand  {

    private int code;
    private String name;

    public Brand(DataCollector dataCollector, VehicleType vehicleType) {
        this.code = Integer.parseInt(dataCollector.code());
        this.name = dataCollector.name();
        this.vehicleType = vehicleType;
    }

    private VehicleType vehicleType;

    public String getType() {
        return vehicleType.getType();
    }

    private List<VehicleModel> modelList;

    public int getBrandCode() {
        return this.code;
    }

    @Override
    public String toString() {
        return this.code + " - " + this.name;
    }

}
