def invoke(msg) 
{ 
    def httpHeaders = msg.get("http.headers");
    def action = httpHeaders.get("SOAPAction");
    return action == "test";
}