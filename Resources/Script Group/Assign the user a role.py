from java.util import HashMap

def invoke(msg): 
    userProperties = msg.get("attribute.lookup.list")
    if userProperties == None:
        userProperties = HashMap()
        msg.put("attribute.lookup.list", userProperties)
    userProperties.put("role", "Manager")
    return True