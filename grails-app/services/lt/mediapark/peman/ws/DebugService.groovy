package lt.mediapark.peman.ws

import grails.transaction.Transactional
import groovy.sql.Sql

@Transactional
class DebugService {


  def testConnection(Long kliId) {

    withSql { Sql sql ->
      sql.rows("SELECT * FROM BS_KLI WHERE KLI_ID = :kliId", [kliId: kliId])
    }

  }
}
