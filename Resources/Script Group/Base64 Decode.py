from java.util import Base64
from java.nio.charset import StandardCharsets
from java.lang import String

def invoke(msg):
    base64EncodedData = msg.get("data.base64")
    if base64EncodedData is not None:
        dataDecoded = Base64.getDecoder().decode(base64EncodedData)
        dataString = String(dataDecoded, StandardCharsets.UTF_8)
        msg.put("data.decoded", dataString)
    return True