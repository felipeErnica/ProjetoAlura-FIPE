package br.com.projetosalura.AppTabelaFipe.demo.models;

import br.com.projetosalura.AppTabelaFipe.demo.models.datacollector.ModelData;
import org.jetbrains.annotations.NotNull;

public class VehicleModel implements Comparable<VehicleModel>, IModelType  {

    private int modelCode;
    private String model;
    private Brand brand;

    public VehicleModel(ModelData modelData, Brand brand) {
        this.modelCode = modelData.code();
        this.model = modelData.modelName();
        this.brand = brand;
    }

    public String getType(){
        return brand.getType();
    }

    public long getBrandCode() {return brand.getCode();}
    public String getBrandName(){return brand.getName();}

    public String toString() {
        return this.modelCode + " - " + this.model;
    }

    public int compareTo(@NotNull VehicleModel o) {return Integer.compare(this.modelCode, o.modelCode);}

    @Override
    public String getName() {return this.model;}

    @Override
    public long getCode() {return this.modelCode;}
}
