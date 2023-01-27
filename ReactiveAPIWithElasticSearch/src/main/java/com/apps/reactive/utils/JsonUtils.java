
package com.apps.reactive.utils;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.log4j.Logger;

import java.io.IOException;

/**
 * 
 * @author Tenzin Dawa
 *
 */
public class JsonUtils {
    private JsonUtils() {
    }

    private static final Logger LOGGER = Logger.getLogger(JsonUtils.class);

    /**
     * 
     * @param objectToConvert
     * @return
     */
    public static String toString(Object objectToConvert) {
        String output = null;
        try {
            final ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
            output = objectMapper.writeValueAsString(objectToConvert);
        } catch (JsonProcessingException e) {
            LOGGER.error(e.getLocalizedMessage());
        }
        return output;
    }

    public static <T> T getObject(String jsonString, Class<T> type) throws IOException {
        final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
        OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return OBJECT_MAPPER.readValue(jsonString, type);
    }
}
