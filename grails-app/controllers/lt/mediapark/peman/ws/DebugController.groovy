package lt.mediapark.peman.ws

import grails.converters.JSON

class DebugController {

   static allowedMethods = [
     'GET', 'POST'
   ]


  def debugService

  def index = {
    if (params.id) {
      render debugService.testConnection(params.id as Long) as JSON
    } else {
      render ([msg: 'no comment']) as JSON
    }
  }

  def auth = {
    def json = request.JSON
    if (json.username && json.password) {

      render debugService.connect(json.username as String, json.password as String) as JSON

    } else {
      render ([msg: 'no creds!']) as JSON
    }
  }
}
