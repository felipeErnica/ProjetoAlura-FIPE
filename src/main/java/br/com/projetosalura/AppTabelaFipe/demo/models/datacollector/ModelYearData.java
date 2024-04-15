package br.com.projetosalura.AppTabelaFipe.demo.models.datacollector;

import com.fasterxml.jackson.annotation.JsonAlias;

public record ModelYearData(@JsonAlias("codigo") String code,
                            @JsonAlias("nome") String brand) {
}
