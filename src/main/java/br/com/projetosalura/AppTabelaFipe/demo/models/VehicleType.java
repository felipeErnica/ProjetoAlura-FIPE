package br.com.projetosalura.AppTabelaFipe.demo.models;

import java.util.List;

public class VehicleType  {

    private String type;

    public void chooseType(int type){

        switch (type) {
            case 1: this.type = "carros";
            case 2: this.type = "motos";
            case 3: this.type = "caminhoes";
        }

    }

    public String getType() {
        return type;
    }




}
