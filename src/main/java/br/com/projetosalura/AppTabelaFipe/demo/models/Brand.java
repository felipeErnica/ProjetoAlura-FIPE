package br.com.projetosalura.AppTabelaFipe.demo.models;

import br.com.projetosalura.AppTabelaFipe.demo.models.datacollector.BrandData;
import org.jetbrains.annotations.NotNull;

public class Brand implements Comparable<Brand>,IModelType {
    private long brandCode;
    private String brand;
    private String vehicleType;

    public Brand(BrandData data, String vehicleType) {
        this.brandCode = Integer.parseInt(data.code());
        this.brand = data.brand();
        this.vehicleType = vehicleType;
    }

    public String getType() {
        return this.vehicleType;
    }

    public long getCode() {
        return this.brandCode;
    }

    public String getName() {
        return this.brand;
    }

    @Override
    public String toString() {
        return this.brandCode + " - " + this.brand;
    }

    @Override
    public int compareTo(@NotNull Brand o) {
        return Long.compare(this.brandCode, o.getCode());
    }

}
