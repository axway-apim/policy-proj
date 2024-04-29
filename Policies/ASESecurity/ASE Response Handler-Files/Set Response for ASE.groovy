def invoke(msg){
        def key="";
        def value="";
	def httpHeaders = msg.get("http.headers");
        msg.put("origHeaders", httpHeaders);
        def headerNames = httpHeaders.getNames();  
        msg.put("BackendResponseCode", msg.get("http.response.status"));   
	def strHeaders = '{ "response_code": "'+msg.get("http.response.status") + '", "response_status": "'+ msg.get("http.response.info") + '", "http_version": "' +msg.get("http.response.version")+'", ';
	strHeaders = strHeaders + '"headers": [';
	while  (headerNames.hasNext()){
		key = headerNames.next().replaceAll("\"", "\\\\\"");
		value = httpHeaders.get(key).replaceAll("\"", "\\\\\"");
		strHeaders = strHeaders + '{"' + key + '" : "' + value +'"}' ;
		if(headerNames.hasNext()){
    			strHeaders = strHeaders + ","; 
		}
	}
	if(msg.get("content.length") != null) {
		strHeaders = strHeaders+"," + '{"Content-Length" : "' + msg.get("content.length") +'"}' ;
	}
        if(msg.get("content.type") != null){
                strHeaders = strHeaders+"," + '{"Content-type" : "' + msg.get("content.type") +'"}' ;
	}
	if(msg.get("content.connection") != null){
		strHeaders = strHeaders+"," + '{"Connection" : "' + msg.get("http.connectione") +'"}' ;
	}
	if(msg.get("content.transferencoding") != null){
		strHeaders = strHeaders+"," + '{"Transfer-Encoding" : "' + msg.get("http.transferencoding") +'"}' ;
	}
	
	
	strHeaders = strHeaders + '] }';
	msg.put("ASEResponse", strHeaders);
       return true;
}