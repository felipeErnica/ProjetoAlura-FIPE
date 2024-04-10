package br.com.projetosalura.AppTabelaFipe.demo.tools;

import com.fasterxml.jackson.annotation.JsonAlias;

public record DataCollector(@JsonAlias("codigo") String code,
                            @JsonAlias("nome") String name
                          ) {
}
