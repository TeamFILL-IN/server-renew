package com.teamfillin.fillin.infra.datasource;

import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseFactory;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

class H2Factory {
	static EmbeddedDatabaseFactory embeddedDatabaseFactory() {
		EmbeddedDatabaseFactory embeddedDatabaseFactory = new EmbeddedDatabaseFactory();

		// embeddedDatabaseFactory.setDatabaseName(h2Properties.getDbName());
		embeddedDatabaseFactory.setDatabaseType(EmbeddedDatabaseType.H2);
		return embeddedDatabaseFactory;
	}
}
