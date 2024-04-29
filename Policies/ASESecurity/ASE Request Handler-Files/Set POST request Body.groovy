def invoke(msg){
	def httpHeaders = msg.get("http.headers");
        def authVal = httpHeaders.get("authorization");
        httpHeaders.remove("authorization");
        def strHeaders = '{"source_ip": "'+ msg.get("sourceIP") + '", "source_port": "'+  msg.get("message.source")+'", "method": "' +msg.get("http.request.verb")+ '", "url": "' +msg.get("http.request.uri")+'",';
	strHeaders = strHeaders+'"headers": [';
        
	def headerNames = httpHeaders.getNames();     
	while (headerNames.hasNext()){
                def key = headerNames.next().replaceAll("\"", "\\\\\"");
		def value = httpHeaders.get(key).replaceAll("\"", "\\\\\"");
		strHeaders = strHeaders + '{"' + key + '" : "' + value +'"}' ;
		if(headerNames.hasNext()){
    			strHeaders = strHeaders + ","; 
		}
	}
	
	if(msg.get("content.length") != null){
		strHeaders = strHeaders+"," + '{"Content-Length" : "' + msg.get("content.length") +'"}' ;
	}
         if(msg.get("content.type") != null){
                strHeaders = strHeaders+"," + '{"Content-type" : "' + msg.get("content.type") +'"}' ;
	}
	if(msg.get("content.connection") != null){
		strHeaders = strHeaders+"," + '{"Connection" : "' + msg.get("http.connection") +'"}' ;
	}
	if(msg.get("content.transferencoding") != null){
		strHeaders = strHeaders+"," + '{"Transfer-Encoding" : "' + msg.get("http.transferencoding") +'"}' ;
	}
        def token = msg.get("accesstoken")
        if ( token != null  && token.getValue() != null) {
           strHeaders = strHeaders + "," +'{"Authorization" : "Bearer ' + token.getValue() +'"}' ;
        } else if ( authVal != null ) {
            strHeaders = strHeaders + "," +'{"Authorization" : "' +  authVal +'"}' ;
        }

	strHeaders = strHeaders +']';
        def authn = msg.get("accesstoken.authn");
        if(authn != null) {
           def username = authn.getUserAuthentication();
           if( username !=null) {
              username = username.replaceAll("\"", "\\\\\"");
              strHeaders = strHeaders +',"user_info": [{ "username": "' + username + '"';
              if(authn.getAuthorizationRequest() != null) {
                def params = authn.getAuthorizationRequest().getParameters();
                params.each{ k, v -> 
                     if ( k != null && v != null ) {
                       def key = k.replaceAll("\"", "\\\\\"");
		       def value = v.replaceAll("\"", "\\\\\"");
                       strHeaders = strHeaders + ',"' + key + '" : "' + value +'"';
                    }
                }
                def additionalinfo = msg.get("accesstoken").getAdditionalInformation();
                additionalinfo.each{ k, v -> 
                    if ( k != null && v != null ) {
                       def key = k.replaceAll("\"", "\\\\\"");
		       def value = v.replaceAll("\"", "\\\\\"");
                       strHeaders = strHeaders + ',"' + key + '" : "' + value +'"';
                    }
                }
              }
             strHeaders = strHeaders +'}]';
          }
        }
        strHeaders = strHeaders +'}';
        msg.put("ASEPostBody", strHeaders);
        if(authVal != null ) {
             httpHeaders.setHeader("authorization", authVal);
        }
       return true;
}