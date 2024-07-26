/*
 * Copyright (C) 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.google.cloud.teleport.v2.source.reader.io.schema.typemapping.provider;

import com.google.cloud.teleport.v2.source.reader.io.schema.typemapping.UnifiedTypeMapping;
import com.google.cloud.teleport.v2.source.reader.io.schema.typemapping.provider.unified.UnifiedMappingProvider;
import com.google.common.collect.ImmutableMap;
import java.util.Map;
import java.util.Map.Entry;

public final class PostgreSQLMappingProvider {
  private static final ImmutableMap<String, UnifiedTypeMapping> MAPPING =
      ImmutableMap.<String, UnifiedMappingProvider.Type>builder()
          .put("BIGINT", UnifiedMappingProvider.Type.LONG)
          .put("BIGSERIAL", UnifiedMappingProvider.Type.LONG)
          .put("BIT", UnifiedMappingProvider.Type.STRING)
          .put("BIT VARYING", UnifiedMappingProvider.Type.STRING)
          .put("BOOL", UnifiedMappingProvider.Type.BOOLEAN)
          .put("BOOLEAN", UnifiedMappingProvider.Type.BOOLEAN)
          .put("BOX", UnifiedMappingProvider.Type.STRING)
          .put("BYTEA", UnifiedMappingProvider.Type.BYTES)
          .put("CHAR", UnifiedMappingProvider.Type.STRING)
          .put("CHARACTER", UnifiedMappingProvider.Type.STRING)
          .put("CHARACTER VARYING", UnifiedMappingProvider.Type.STRING)
          .put("CIDR", UnifiedMappingProvider.Type.STRING)
          .put("CIRCLE", UnifiedMappingProvider.Type.STRING)
          .put("DATE", UnifiedMappingProvider.Type.DATE)
          .put("DECIMAL", UnifiedMappingProvider.Type.NUMBER)
          .put("DOUBLE PRECISION", UnifiedMappingProvider.Type.DOUBLE)
          .put("FLOAT4", UnifiedMappingProvider.Type.FLOAT)
          .put("FLOAT8", UnifiedMappingProvider.Type.DOUBLE)
          .put("INET", UnifiedMappingProvider.Type.STRING)
          .put("INTEGER", UnifiedMappingProvider.Type.INTEGER)
          .put("INT2", UnifiedMappingProvider.Type.INTEGER)
          .put("INT4", UnifiedMappingProvider.Type.INTEGER)
          .put("INT8", UnifiedMappingProvider.Type.LONG)
          // TODO(thiagotnunes): Verify if time_interval is correct
          .put("INTERVAL", UnifiedMappingProvider.Type.TIME_INTERVAL)
          .put("JSON", UnifiedMappingProvider.Type.JSON)
          .put("JSONB", UnifiedMappingProvider.Type.JSON)
          .put("LINE", UnifiedMappingProvider.Type.STRING)
          .put("LSEG", UnifiedMappingProvider.Type.STRING)
          .put("MACADDR", UnifiedMappingProvider.Type.STRING)
          .put("MACADDR8", UnifiedMappingProvider.Type.STRING)
          .put("MONEY", UnifiedMappingProvider.Type.STRING)
          .put("NUMERIC", UnifiedMappingProvider.Type.NUMBER)
          .put("PATH", UnifiedMappingProvider.Type.STRING)
          .put("PG_LSN", UnifiedMappingProvider.Type.STRING)
          .put("PG_SNAPSHOT", UnifiedMappingProvider.Type.STRING)
          .put("POINT", UnifiedMappingProvider.Type.STRING)
          .put("POLYGON", UnifiedMappingProvider.Type.STRING)
          .put("REAL", UnifiedMappingProvider.Type.FLOAT)
          .put("SERIAL2", UnifiedMappingProvider.Type.INTEGER)
          .put("SERIAL4", UnifiedMappingProvider.Type.INTEGER)
          .put("SERIAL8", UnifiedMappingProvider.Type.LONG)
          .put("SMALLINT", UnifiedMappingProvider.Type.INTEGER)
          .put("SMALLSERIAL", UnifiedMappingProvider.Type.INTEGER)
          .put("TEXT", UnifiedMappingProvider.Type.STRING)
          .put("TIME", UnifiedMappingProvider.Type.TIME)
          .put("TIME WITHOUT TIME ZONE", UnifiedMappingProvider.Type.TIME)
          .put("TIMESTAMP", UnifiedMappingProvider.Type.TIMESTAMP)
          .put("TIMESTAMP WITHOUT TIME ZONE", UnifiedMappingProvider.Type.TIMESTAMP)
          .put("TIMESTAMPTZ", UnifiedMappingProvider.Type.TIMESTAMP_WITH_TIME_ZONE)
          .put("TIMESTAMP WITH TIME ZONE", UnifiedMappingProvider.Type.TIMESTAMP_WITH_TIME_ZONE)
          .put("TIMETZ", UnifiedMappingProvider.Type.TIME_WITH_TIME_ZONE)
          .put("TIME WITH TIME ZONE", UnifiedMappingProvider.Type.TIME_WITH_TIME_ZONE)
          .put("TSQUERY", UnifiedMappingProvider.Type.STRING)
          .put("TSVECTOR", UnifiedMappingProvider.Type.STRING)
          .put("TXID_SNAPSHOT", UnifiedMappingProvider.Type.STRING)
          .put("UUID", UnifiedMappingProvider.Type.STRING)
          .put("VARBIT", UnifiedMappingProvider.Type.STRING)
          .put("VARCHAR", UnifiedMappingProvider.Type.STRING)
          .put("XML", UnifiedMappingProvider.Type.STRING)
          .build()
          .entrySet()
          .stream()
          .map(e -> Map.entry(e.getKey(), UnifiedMappingProvider.getMapping(e.getValue())))
          .collect(ImmutableMap.toImmutableMap(Entry::getKey, Entry::getValue));

  public static ImmutableMap<String, UnifiedTypeMapping> getMapping() {
    return MAPPING;
  }

  private PostgreSQLMappingProvider() {}
}
