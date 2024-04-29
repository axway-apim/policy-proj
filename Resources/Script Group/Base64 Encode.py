from java.util import Base64
from java.lang import String
from java.nio.charset import StandardCharsets


def invoke(msg):
    data = msg.get("data")
    if data is not None:
        dataEncoded = Base64.getEncoder().encodeToString(String(data).getBytes(StandardCharsets.UTF_8))
        msg.put("data.base64", dataEncoded)
    return True