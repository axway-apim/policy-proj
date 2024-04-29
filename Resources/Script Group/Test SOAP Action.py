def invoke(msg):
    httpHeaders = msg.get("http.headers")
    action = httpHeaders.get("SOAPAction")
    if action != None:
        return action.equals("test")
    return False