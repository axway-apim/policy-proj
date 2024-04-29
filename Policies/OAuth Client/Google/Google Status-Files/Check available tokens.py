from java.lang import Boolean
def invoke(msg):
    accessToken = msg.get("oauth.client.accesstoken")
    if accessToken:
        msg.put("authorized", Boolean.TRUE)
    else:
        msg.put("authorized", Boolean.FALSE)

    return True
