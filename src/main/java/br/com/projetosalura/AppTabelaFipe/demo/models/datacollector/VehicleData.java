package br.com.projetosalura.AppTabelaFipe.demo.models.datacollector;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record VehicleData(@JsonAlias("Valor") String price,
                          @JsonAlias("AnoModelo") long year,
                          @JsonAlias("Combustivel") String fuel) {
}
