from java.lang import Boolean
def invoke(msg):
    accessToken = msg.get("oauth.client.accesstoken")
    refreshToken = msg.get("oauth.client.refreshtoken")
    if accessToken:
        msg.put("authorized", Boolean.TRUE)
        msg.put("expired", Boolean.FALSE)
    elif refreshToken:
        msg.put("authorized", Boolean.FALSE)
        msg.put("expired", Boolean.TRUE)
    else:
        msg.put("authorized", Boolean.FALSE)
        msg.put("expired", Boolean.FALSE)

    return True

