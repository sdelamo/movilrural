package com.softamo.movilrural.fixtures

import org.testcontainers.containers.MySQLContainer

class MySQL {

    static MySQLContainer mysqlContainer

    static init() {
        if (mysqlContainer == null) {
            mysqlContainer = new MySQLContainer()
                .withDatabaseName("movilrural")
                .withUsername("foo")
                .withPassword("secret")
            mysqlContainer.start()
            populateSystemProperties(mysqlContainer)
        }
    }

    static populateSystemProperties(MySQLContainer mysqlContainer) {
        String jdbcUrl = mysqlContainer.jdbcUrl + '?useSSL=false'
        System.setProperty("dataSource.url", jdbcUrl)
        System.setProperty("dataSource.username", mysqlContainer.username)
        System.setProperty("dataSource.password", mysqlContainer.password)
    }

    static void destroy(MySQLContainer mySQLContainer) {
        if (mySQLContainer != null) {
            mySQLContainer.stop()
        }
    }
}

