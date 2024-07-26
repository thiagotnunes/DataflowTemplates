package com.google.cloud.teleport.v2.source.reader.io.jdbc.iowrapper.config.defaults;

import com.google.cloud.teleport.v2.source.reader.io.jdbc.dialectadapter.DialectAdapter;
import com.google.cloud.teleport.v2.source.reader.io.jdbc.dialectadapter.postgresql.PostgreSQLDialectAdapter;
import com.google.cloud.teleport.v2.source.reader.io.jdbc.dialectadapter.postgresql.PostgreSQLDialectAdapter.PostgreSQLVersion;
import com.google.cloud.teleport.v2.source.reader.io.jdbc.rowmapper.JdbcValueMappingsProvider;
import com.google.cloud.teleport.v2.source.reader.io.jdbc.rowmapper.provider.PostgreSQLJdbcValueMappings;
import com.google.cloud.teleport.v2.source.reader.io.schema.typemapping.UnifiedTypeMapper;
import com.google.common.collect.ImmutableList;
import org.apache.beam.sdk.util.FluentBackoff;

public class PostgreSQLConfigDefaults {
    public static final UnifiedTypeMapper.MapperType DEFAULT_POSTGRESQL_SCHEMA_MAPPER_TYPE = UnifiedTypeMapper.MapperType.POSTGRESQL;
    public static final DialectAdapter DEFAULT_POSTGRESQL_DIALECT_ADAPTER =
            new PostgreSQLDialectAdapter(PostgreSQLVersion.DEFAULT);
    public static final JdbcValueMappingsProvider DEFAULT_POSTGRESQL_VALUE_MAPPING_PROVIDER =
            new PostgreSQLJdbcValueMappings();

    // TODO(thiagotnunes)
    public static final String DEFAULT_POSTGRESQL_CONNECTION_PROPERTIES =
            "maxTotal=160;maxpoolsize=160;maxIdle=160;minIdle=160"
                    + ";wait_timeout=57600"
                    + ";interactive_timeout=57600"
                    + ";idletimeout=3600"
                    + ";maxwaittime=600_000"
                    + ";maxWaitMillis=600_000"
                    + ";maxConnLifetimeMillis=600_000"
                    + ";testOnCreate=true;testOnBorrow=true;testOnReturn=true;testWhileIdle=true";

    public static final Long DEFAULT_POSTGRESQL_MAX_CONNECTIONS = 160L;

    public static final boolean DEFAULT_POSTGRESQL_AUTO_RECONNECT = true;

    public static final long DEFAULT_POSTGRESQL_RECONNECT_ATTEMPTS = 10L;
    public static final FluentBackoff DEFAULT_POSTGRESQL_SCHEMA_DISCOVERY_BACKOFF = FluentBackoff.DEFAULT;

    /**
     * Default Initialization Sequence for the JDBC connection.
     */
    // correct.
    public static final ImmutableList<String> DEFAULT_POSTGRESQL_INIT_SEQ =
            ImmutableList.of("SET TIME ZONE 'UTC'");

    private PostgreSQLConfigDefaults() {}
}
