class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }
        "/test/$id" (controller: 'debug', action: 'index')
        "/"(controller: 'debug', action: 'index')
        "500"(view:'/error')
	}
}
