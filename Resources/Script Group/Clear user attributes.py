def invoke(msg): 
    userProperties = msg.get("attribute.lookup.list")
    if userProperties == None:
        return True
    userProperties.clear()
    return True