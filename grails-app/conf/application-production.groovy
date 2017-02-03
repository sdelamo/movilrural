def uri = new URI(System.env.DATABASE_URL)

dataSources {
    dataSource {
        username = uri.userInfo ? uri.userInfo.split(":")[0] : ""
        password = uri.userInfo ? uri.userInfo.split(":")[1] : ""
        url = "jdbc:mysql://" + uri.host + uri.path
        properties {
            jmxEnabled = true
            initialSize = 5
            maxActive = 50
            minIdle = 5
            maxIdle = 25
            maxWait = 10000
            maxAge = 600000
            timeBetweenEvictionRunsMillis = 5000
            minEvictableIdleTimeMillis = 60000
            validationQuery = 'SELECT 1'
            validationQueryTimeout = 3
            validationInterval = 15000
            testOnBorrow = true
            testWhileIdle = true
            testOnReturn = false
            jdbcInterceptors = 'ConnectionState'
            defaultTransactionIsolation = 2 //# TRANSACTION_READ_COMMITTED
        }
    }
}