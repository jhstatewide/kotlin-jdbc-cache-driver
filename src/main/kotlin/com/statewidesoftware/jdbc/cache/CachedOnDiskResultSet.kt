package com.statewidesoftware.jdbc.cache/*
 * Copyright 2016-2017 Emmanuel Keller / QWAZR
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.io.DataInputStream
import java.io.FileInputStream
import java.io.IOException
import java.nio.file.Path
import java.util.zip.GZIPInputStream
import kotlin.jvm.Throws

/**
 * Uses disk persistence for caching
 */
internal class CachedOnDiskResultSet @Throws(IOException::class) constructor(statement: CachedStatement<*>?, resultSetPath: Path) : CachedResultSet(
    statement, DataInputStream(
        GZIPInputStream(FileInputStream(resultSetPath.toFile()))
    )
)