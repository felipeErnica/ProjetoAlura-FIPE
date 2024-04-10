package br.com.projetosalura.AppTabelaFipe.demo.models;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

public class VehicleModel {

    private int code;
    private String model;
    private VehicleType vehicleType;
    private Brand brand;
    private List<Vehicle> vehicleList;

    public String getType() {
        return vehicleType.getType();
    }

    public int getBrandCode() {
        return brand.getBrandCode();
    }

    public int getModelCode() {
        return code;
    }


}
