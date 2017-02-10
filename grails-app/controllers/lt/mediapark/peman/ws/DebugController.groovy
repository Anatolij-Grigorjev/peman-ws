package lt.mediapark.peman.ws

import grails.converters.JSON

class DebugController {

   static allowedMethods = [
     'GET'
   ]


  def debugService

  def index = {
    if (params.id) {
      render debugService.testConnection(params.id as Long) as JSON
    } else {
      render (204) as JSON
    }
  }
}
