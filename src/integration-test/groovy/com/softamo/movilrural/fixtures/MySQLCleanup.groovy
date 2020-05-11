package com.softamo.movilrural.fixtures

import org.spockframework.runtime.extension.AbstractGlobalExtension

class MySQLCleanup extends AbstractGlobalExtension {

    @Override
    void stop() {
        MySQL.destroy(MySQL.mysqlContainer)
    }
}
