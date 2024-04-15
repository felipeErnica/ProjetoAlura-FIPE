package br.com.projetosalura.AppTabelaFipe.demo.models;

import br.com.projetosalura.AppTabelaFipe.demo.models.datacollector.VehicleData;
import org.jetbrains.annotations.NotNull;

public class Vehicle implements IModelType,Comparable<Vehicle>  {

    private VehicleModel vehicleModel;
    private long code;
    private long year;
    private String fuelType;
    private double vehiclePrice;

    public Vehicle(VehicleData vehicleData, VehicleModel vehicleModel, String  code) {
        this.vehicleModel = vehicleModel;

        this.vehiclePrice = Double.parseDouble(vehicleData.price()
                .replace("R$ ","")
                .replace(".","")
                .replace(",",".")
        );

        this.fuelType = vehicleData.fuel();
        this.year = vehicleData.year();
        this.code = Long.parseLong(code);
    }

    public String getFuelType() {
        return fuelType;
    }

    public String getVehiclePrice() {
        return "R$ " + vehiclePrice;
    }

    public String getBrand() {
        return vehicleModel.getBrandName();
    }

    public long getYear(){
        return this.year;
    }

    public String getModel() {
        return vehicleModel.getName();
    }

    @Override
    public String toString() {
        return this.code + " - " + vehicleModel.getName() + " (" + this.year + ")" + " - " + this.fuelType;
    }

    public long getModelCode() {
        return vehicleModel.getCode();
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public long getCode() {
        return this.code;
    }

    @Override
    public int compareTo(@NotNull Vehicle o) {
       return Long.compare(this.code,o.getCode());
    }
}
