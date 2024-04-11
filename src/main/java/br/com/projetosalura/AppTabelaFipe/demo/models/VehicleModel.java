package br.com.projetosalura.AppTabelaFipe.demo.models;

import br.com.projetosalura.AppTabelaFipe.demo.tools.DataCollector;
import com.fasterxml.jackson.annotation.JsonAlias;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class VehicleModel implements Comparable<VehicleModel> {

    private int code;
    private String model;
    private Brand brand;

    public VehicleModel(DataCollector dataCollector,Brand brand) {
        this.model = dataCollector.name();
        this.code = Integer.parseInt(dataCollector.code());
        this.brand = brand;
    }

    public String getType() {
        return brand.getType();
    }

    public int getBrandCode() {
        return brand.getBrandCode();
    }

    public int getModelCode() {
        return code;
    }

    public String getModelName() {
        return model;
    }

    public String toString() {
        return this.code + " - " + this.model;
    }

    public int compareTo(@NotNull VehicleModel o) {
        return Integer.compare(this.code, o.getBrandCode());
    }
}
