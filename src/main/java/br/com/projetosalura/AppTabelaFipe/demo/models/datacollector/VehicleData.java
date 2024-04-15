package br.com.projetosalura.AppTabelaFipe.demo.models.datacollector;

import com.fasterxml.jackson.annotation.JsonAlias;

public record VehicleData(@JsonAlias("Valor") double price,
                          @JsonAlias("AnoModelo") long year,
                          @JsonAlias("Combustivel") String fuel) {
}
