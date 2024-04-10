package br.com.projetosalura.AppTabelaFipe.demo.models;

import br.com.projetosalura.AppTabelaFipe.demo.tools.DataCollector;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class Brand extends DataModel implements Comparable<Brand> {
    private int code;
    private String name;

    private VehicleType vehicleType;

    public Brand(String code, String name) {
        super(code, name);
    }

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

    @Override
    public int compareTo(@NotNull Brand o) {
        return Integer.compare(this.code, o.getBrandCode());
    }

}
