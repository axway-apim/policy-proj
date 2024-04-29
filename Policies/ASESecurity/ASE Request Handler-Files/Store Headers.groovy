def invoke(msg){
	def httpHeaders = msg.get("http.headers");
        msg.put("origHeaders", httpHeaders );
        return true;
}