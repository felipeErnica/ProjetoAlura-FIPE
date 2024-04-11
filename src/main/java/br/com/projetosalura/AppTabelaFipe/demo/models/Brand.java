package br.com.projetosalura.AppTabelaFipe.demo.models;

import br.com.projetosalura.AppTabelaFipe.demo.tools.DataCollector;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class Brand implements Comparable<Brand> {
    private int code;
    private String name;
    private String vehicleType;

    public Brand(String code, String name, String vehicleType) {
        this.code = Integer.parseInt(code);
        this.name = name;
    }

    public String getType() {
        return this.vehicleType;
    }

    public int getBrandCode() {
        return this.code;
    }

    public String getBrandName() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.code + " - " + this.name;
    }

    @Override
    public int compareTo(@NotNull Brand o) {
        return Integer.compare(this.code, o.getBrandCode());
    }

}
