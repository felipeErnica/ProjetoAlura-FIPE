package br.com.projetosalura.AppTabelaFipe.demo.tools;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.util.List;

public class Serializer {

    private static ObjectMapper objectMapper = new ObjectMapper();

    public static <T> T serializeJson (Class<T> tClass, String json) {
        try {
            return objectMapper.readValue(json,tClass);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static  List<DataCollector> serializeListJson (String json) {
        try {
            CollectionType collectionType = objectMapper.getTypeFactory().constructCollectionType(List.class, DataCollector.class);
            return objectMapper.readValue(json,collectionType);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


}
