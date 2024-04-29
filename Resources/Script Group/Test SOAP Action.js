function invoke(msg) 
{ 
    var httpHeaders = msg.get("http.headers");
    var action = httpHeaders.get("SOAPAction");
    return action == "test";
}