import org.springframework.context.ApplicationContext
import groovy.sql.Sql


class BootStrap {

    ApplicationContext applicationContext
    def grailsApplication

    def dataSource
    def theSql

    def init = { servletContext ->

      theSql = new Sql(dataSource)

      grailsApplication.serviceClasses.each { clazz ->

        clazz.metaClass.withSql = doWithSql.curry(theSql)
      }
    }

    private doWithSql = { Sql sql, Closure actions ->
      if (sql && actions)
        actions(sql)
      else
        null
    }

    def destroy = {
    }
}
