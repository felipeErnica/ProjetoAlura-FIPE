package br.com.projetosalura.AppTabelaFipe.demo.models;

import br.com.projetosalura.AppTabelaFipe.demo.models.datacollector.ModelData;
import org.jetbrains.annotations.NotNull;

public class VehicleModel implements Comparable<VehicleModel>,IModelType  {

    private int code;
    private String model;
    private Brand brand;

    public VehicleModel(int code, String model, Brand brand) {
        this.code = code;
        this.model = model;
        this.brand = brand;
    }

    public String getType() {
        return brand.getType();
    }

    public int getBrandCode() {
        return brand.getCode();
    }

    public int getModelCode() {
        return code;
    }

    public String toString() {
        return this.code + " - " + this.model;
    }

    public int compareTo(@NotNull VehicleModel o) {
        return Integer.compare(this.code, o.getBrandCode());
    }

    @Override
    public String getName() {
        return this.model;
    }

    @Override
    public int getCode() {
        return this.code;
    }
}
