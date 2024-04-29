def invoke(msg) 
{ 
    def userProperties = msg.get("attribute.lookup.list");

    if (userProperties == null) {
        userProperties = new java.util.HashMap();
        msg.put("attribute.lookup.list", userProperties);
    }
    def role = userProperties.get("role");       
    return role == "Manager";        
}
