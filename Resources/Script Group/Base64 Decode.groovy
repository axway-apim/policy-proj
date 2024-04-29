import java.util.Base64;
import java.nio.charset.StandardCharsets;

def invoke(msg)
{
    def base64DecodedData = Base64.getDecoder().decode(msg.get("data.base64"));
    msg.put("data.decoded", new String(base64DecodedData, StandardCharsets.UTF_8));
    return true;
}