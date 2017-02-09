dataSource {
  dbCreate = '' //NEVER ALTER THE DB!!!
  pooled = true
  jmxExport = true
  pooled = true
  dialect = org.hibernate.dialect.Oracle10gDialect
  driverClassName = 'oracle.jdbc.OracleDriver'
  username = 'sbs_mgr01g'
  password = 'sbs'
}
hibernate {
  cache.use_second_level_cache = true
  cache.use_query_cache = false
//    cache.region.factory_class = 'org.hibernate.cache.SingletonEhCacheRegionFactory' // Hibernate 3
  cache.region.factory_class = 'org.hibernate.cache.ehcache.SingletonEhCacheRegionFactory' // Hibernate 4
  singleSession = true // configure OSIV singleSession mode
  flush.mode = 'manual' // OSIV session flush mode outside of transactional context
}
//<entry key="apex.db.connectionType">basic</entry>
//<entry key="apex.db.hostname">192.168.90.17</entry>
//<entry key="apex.db.port">1521</entry>
//<entry key="apex.db.sid">ksp1</entry>
//<entry key="apex.db.servicename"/>
//<entry key="apex.db.tnsAliasName"/>
//<entry key="apex.db.tnsDirectory"/>
//<entry key="apex.db.customURL"/>
//<entry key="apex.jdbc.DriverType">thin</entry>
// environment specific settings
environments {
  development {
    dataSource {
      url = 'jdbc:oracle:thin:@88.119.152.153:1521:sbs1'
    }
  }
  test {
    dataSource {
      url = 'jdbc:oracle:thin:@192.168.90.16:1521:sbs1'
    }
  }
  production {
    dataSource {
      url = 'jdbc:oracle:thin:@192.168.90.57:1521:sbs1'
      properties {
        // See http://grails.org/doc/latest/guide/conf.html#dataSource for documentation
        jmxEnabled = true
        initialSize = 5
        maxActive = 50
        minIdle = 5
        maxIdle = 25
        maxWait = 10000
        maxAge = 10 * 60000
        timeBetweenEvictionRunsMillis = 5000
        minEvictableIdleTimeMillis = 60000
        validationQuery = "SELECT 1"
        validationQueryTimeout = 3
        validationInterval = 15000
        testOnBorrow = true
        testWhileIdle = true
        testOnReturn = false
        jdbcInterceptors = "ConnectionState"
        defaultTransactionIsolation = java.sql.Connection.TRANSACTION_READ_COMMITTED
      }
    }
  }
}
