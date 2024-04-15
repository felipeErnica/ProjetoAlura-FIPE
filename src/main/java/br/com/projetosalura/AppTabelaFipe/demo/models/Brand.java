package br.com.projetosalura.AppTabelaFipe.demo.models;

import br.com.projetosalura.AppTabelaFipe.demo.models.datacollector.BrandData;
import org.jetbrains.annotations.NotNull;

public class Brand implements Comparable<Brand>,IModelType {
    private int code;
    private String name;
    private String vehicleType;

    public Brand(BrandData data, String vehicleType) {
        this.code = Integer.parseInt(data.code());
        this.name = data.brand();
        this.vehicleType = vehicleType;
    }

    public String getType() {
        return this.vehicleType;
    }

    public int getCode() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.code + " - " + this.name;
    }

    @Override
    public int compareTo(@NotNull Brand o) {
        return Integer.compare(this.code, o.getCode());
    }

}
