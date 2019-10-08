package org.jbehave.core.model;

public class ExamplesTablePropertiesFactory {
	
	public ExamplesTableProperties createExamplesTableProperties(String propertiesAsString, String headerSeparator,
			String valueSeparator, String ignorableSeparator) {
		String resolvedProperties = resolveProperties(propertiesAsString);
		return new ExamplesTableProperties(resolvedProperties, headerSeparator,
                valueSeparator, ignorableSeparator);
	}
	
	private String resolveProperties(String propertiesAsString) {
		return "";
	}
}
