package br.com.projetosalura.AppTabelaFipe.demo.tools;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.util.List;

public class Serializer {

    private static ObjectMapper objectMapper = new ObjectMapper();

    public static <T> T serializeJson(String json,Class<T> tClass) {
        try {
            return objectMapper.readValue(json, tClass);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static <R> List<R> serializeListJson(String json,Class<R> recordClass) {
        CollectionType collectionType = objectMapper.getTypeFactory().constructCollectionType(List.class, recordClass);
        try {
            return objectMapper.readValue(json,collectionType);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


}
