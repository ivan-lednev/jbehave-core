package org.jbehave.core.configuration;

import static org.apache.commons.lang3.StringUtils.isEmpty;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.jbehave.core.model.ExamplesTableProperties;
import org.jbehave.core.steps.ParameterConverters;

public class ExamplesTablePropertiesFactory {
	
	private final ParameterConverters parameterConverters;
	
	public ExamplesTablePropertiesFactory(ParameterConverters parameterConverters) {
		this.parameterConverters = parameterConverters;
	}
	
	public ExamplesTableProperties createExamplesTableProperties(String propertiesAsString,
			String defaultHeaderSeparator, String defaultValueSeparator, String defaultIgnorableSeparator) {
		return new ExamplesTableProperties(parseProperties(propertiesAsString), propertiesAsString,
				defaultHeaderSeparator, defaultValueSeparator, defaultIgnorableSeparator);
	}
	
    private Map<String, String> parseProperties(String propertiesAsString) {
        Map<String, String> result = new LinkedHashMap<>();
        if (!isEmpty(propertiesAsString)) {
            for (String propertyAsString : propertiesAsString.split("(?<!\\\\),")) {
                String[] property = StringUtils.split(propertyAsString, "=", 2);
                String convertedValue = StringUtils.replace(property[1], "\\,", ",").trim();
                convertedValue = (String) parameterConverters.convert(convertedValue, String.class);
                result.put(property[0].trim(), convertedValue);
//                result.put(property[0].trim(), StringUtils.replace(property[1], "\\,", ",").trim());
             }
        }
        return result;
    }
}
