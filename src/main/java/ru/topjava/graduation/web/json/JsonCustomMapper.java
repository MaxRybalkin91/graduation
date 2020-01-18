package ru.topjava.graduation.web.json;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

public class JsonCustomMapper extends ObjectMapper {

    private static final Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();

    private JsonCustomMapper() {
        registerModule(new Hibernate5Module());
        builder.visibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.NONE);
        builder.visibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        builder.serializationInclusion(JsonInclude.Include.NON_NULL);
    }

    public static Jackson2ObjectMapperBuilder getMapper() {
        return builder;
    }
}