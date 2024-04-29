def invoke(msg): 
    userProperties = msg.get("attribute.lookup.list")
    if (userProperties == null)
        return True
    userProperties.remove("role")
    return True