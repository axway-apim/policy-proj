function invoke(msg) 
{ 
    var userProperties = msg.get("attribute.lookup.list");

    if (userProperties == null) {
      userProperties = new java.util.HashMap();
      msg.put("attribute.lookup.list", userProperties);
    }
    var role = userProperties.get("role");       
    return role == "Manager";        
}
