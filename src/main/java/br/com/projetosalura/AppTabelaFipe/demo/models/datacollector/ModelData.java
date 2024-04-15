package br.com.projetosalura.AppTabelaFipe.demo.models.datacollector;

import com.fasterxml.jackson.annotation.JsonAlias;

public record ModelData(@JsonAlias("codigo") int code,
                        @JsonAlias("nome") String modelName) {
}
