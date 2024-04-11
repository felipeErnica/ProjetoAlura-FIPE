package br.com.projetosalura.AppTabelaFipe.demo.models;

import br.com.projetosalura.AppTabelaFipe.demo.tools.DataCollector;
import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

public record ModelList(@JsonAlias("modelos") List<DataCollector> modelList) {
}
