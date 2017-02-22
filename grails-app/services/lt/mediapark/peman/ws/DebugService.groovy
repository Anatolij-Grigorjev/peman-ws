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

  def connect(String username, String password) {

    def sessionMap = [sessionId: '?']

    //tsk$session.set_session_id(tsk_session.open(:USR.NAME, :USR.PASSWORD, tsk$session.get_unit_id, :USR.NEW_PASSWORD, tsk_session.get_unlimited_life_time));
    withSql { Sql sql ->

      sql.call('{? = call tsk30.tsk_session.get_session_id() }', [Sql.VARCHAR]) { sessionId ->
        println "Get session ID: $sessionId"
        sessionMap.sessionId = sessionId as String
      }


    }


    sessionMap
  }
}
