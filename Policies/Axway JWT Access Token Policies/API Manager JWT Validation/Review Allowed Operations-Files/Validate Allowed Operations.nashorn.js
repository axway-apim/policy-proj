function invoke(msg)    {        

		var jwtToken = msg.get("axway.json.jwt.token");
		var jwtTokenJSON = JSON.parse( jwtToken );

		var apiName = msg.get("api.name");
		var resourceName = msg.get("api.method.name");
		var httpMethod = msg.get("http.request.verb");
		
		var allowedAPIListJSON = jwtTokenJSON.jwt_token.partner_allowed_apis;
		var errorMessage = "";

		var i,j,k;

		//Validate API
		errorMessage = "API not Allowed by JWT Token";
		for (i in allowedAPIListJSON) {    
						
			if (allowedAPIListJSON[i].apiName == apiName){
					var apiResources = allowedAPIListJSON[i].apiResources;
			
					//Validate Resource
					errorMessage = "Resource not Allowed by JWT Token";
					for (j in apiResources){						  							
							if (apiResources[j].resourceName == resourceName){								

								//Validate HTTP Method
								errorMessage = "HTTP Method not Allowed by JWT Token"
								for (k in apiResources[j].httpMethods){

									if(apiResources[j].httpMethods[k] == httpMethod){
										msg.put("axway.validation.error", "");
										return true;
									}
								}
							}
					}          
			}

		}
		msg.put("axway.validation.error", errorMessage);
		return false;				

}
