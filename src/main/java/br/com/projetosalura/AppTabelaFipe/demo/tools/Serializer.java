package br.com.projetosalura.AppTabelaFipe.demo.tools;

import br.com.projetosalura.AppTabelaFipe.demo.models.DataModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.util.List;

public class Serializer   {

    private static ObjectMapper objectMapper = new ObjectMapper();

    public static <T> T serializeJson(String json,Class<T> tClass) {
        try {
            return objectMapper.readValue(json, tClass);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static  <T extends DataModel> List<T> serializeListJson(String json) {
        try {
            CollectionType collectionType = objectMapper.getTypeFactory().constructCollectionType(List.class, DataCollector.class);
            List<DataCollector> serializedListJson = objectMapper.readValue(json,collectionType);
            return serializedListJson.stream().map(d -> (T) new DataModel(d.code(), d.name())).toList();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


}
