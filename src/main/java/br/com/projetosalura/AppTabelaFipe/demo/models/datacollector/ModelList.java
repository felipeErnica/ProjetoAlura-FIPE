package br.com.projetosalura.AppTabelaFipe.demo.models.datacollector;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ModelList(@JsonAlias("modelos") List<ModelData> modelList) {
}
