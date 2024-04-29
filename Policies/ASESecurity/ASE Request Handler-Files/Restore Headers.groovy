def invoke(msg){
        msg.put("http.headers", msg.get("origHeaders"));
	return true;
}