package com.sgenlecroyant.spring.security.util;

import java.io.IOException;
import java.time.ZoneId;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class DateSerializer extends JsonSerializer<Date>{

	@Override
	public void serialize(Date value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		String formattedDate = value.toInstant().atZone(ZoneId.systemDefault()).format(Constants.getDateTimeFormatter());
		gen.writeString(formattedDate);
	}

}
