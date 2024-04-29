import java.util.Base64;
import java.nio.charset.StandardCharsets;

def invoke(msg)
{
    def data = msg.get("data");
    def base64EncodedData = Base64.getEncoder().encodeToString(data.getBytes(StandardCharsets.UTF_8));
    msg.put("data.base64", base64EncodedData);
    return true;
}