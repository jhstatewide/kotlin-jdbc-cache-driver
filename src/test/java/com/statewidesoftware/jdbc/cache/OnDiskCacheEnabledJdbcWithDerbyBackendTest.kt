/**
 * Copyright 2016 Emmanuel Keller / QWAZR
 *
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.statewidesoftware.jdbc.cache

import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.SQLException
import java.util.*

class OnDiskCacheEnabledJdbcWithDerbyBackendTest : OnDiskCacheJdbcWithDerbyBackendTest() {
    public override fun expectedResultSetClass(): Class<out ResultSet?> {
        return CachedOnDiskResultSet::class.java
    }

    public override fun isCacheEnabled(): Boolean {
        return true
    }

    public override fun getDerbyDbName(): String {
        return "onDiskCacheEnabled"
    }

    @Throws(SQLException::class)
    public override fun getConnection(): Connection {
        val info = Properties()
        info.setProperty("cache.driver.url", "jdbc:derby:memory:$derbyDbName;create=true")
        return DriverManager.getConnection(orSetJdbcCacheUrl, info)
    }
}