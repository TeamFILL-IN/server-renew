package com.teamfillin.fillin.infra.datasource;

import static com.teamfillin.fillin.infra.datasource.Constants.*;

import javax.sql.DataSource;
import javax.transaction.NotSupportedException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.teamfillin.fillin.infra.SeperatedProfileConfigurable;

@Configuration
public class DataSourceConfiguration implements SeperatedProfileConfigurable<DataSource> {
	@Override
	@Primary
	@Bean(DATA_SOURCE_BEAN)
	public DataSource embedded() {
		return H2Factory.embeddedDatabaseFactory().getDatabase();
	}

	@Override
	@Primary
	@Bean(DATA_SOURCE_BEAN)
	public DataSource remote() throws NotSupportedException {
		throw new NotSupportedException("not support remote datasource now.");
	}
}
