package com.example.springdatacassandraobservability;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.core.cql.keyspace.CreateKeyspaceSpecification;
import org.springframework.data.cassandra.core.cql.keyspace.KeyspaceOption;

import java.util.List;

@Configuration
public class CassandraConfiguration extends AbstractCassandraConfiguration {

	@Override
	protected List<CreateKeyspaceSpecification> getKeyspaceCreations() {
		return List.of(CreateKeyspaceSpecification.createKeyspace(getKeyspaceName()) //
				.ifNotExists() //
				.with(KeyspaceOption.DURABLE_WRITES, true) //
				.withSimpleReplication());
	}

	@Override
	public SchemaAction getSchemaAction() {
		return SchemaAction.CREATE_IF_NOT_EXISTS;
	}

	@Override
	protected String getKeyspaceName() {
		return "TEST";
	}

	@Override
	protected String getLocalDataCenter() {
		return "datacenter1";
	}
}
