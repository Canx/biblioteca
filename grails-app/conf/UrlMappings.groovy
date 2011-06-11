class UrlMappings {

	static mappings = {
    "/book/" {
        controller = "libro"
    }

    "/user/" {
        controller = "usuario"
    }

    "/operation/" {
        controller = "operacion"
    }

    "/fine/" {
        controller = "multa"
    }

    "/$controller/$id?" {
        constraints {
            id(matches:/\d*/)
        }
        action = "show"
    }
		"/$controller/$action?/$id?"{
			constraints {
        id(matches:/\d*/)
			}
		}

		"/"(view:"/index")
		"500"(view:'/error')
	}
}
