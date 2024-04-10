package br.com.projetosalura.AppTabelaFipe.demo.models;

public class DataModel {

    private int code;
    private String name;

    public DataModel(String code, String name) {
        this.code = Integer.parseInt(code);
        this.name = name;
    }

}
