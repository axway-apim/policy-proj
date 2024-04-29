def invoke(msg) 
{ 
    def userProperties = msg.get("attribute.lookup.list");

    if (userProperties == null)
        return true;
    userProperties.remove("role");       
    return true;         
}