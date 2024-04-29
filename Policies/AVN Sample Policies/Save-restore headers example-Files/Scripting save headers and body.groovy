import com.vordel.mime.HeaderSet;
import com.vordel.mime.Body;

def invoke(msg)
{
	HeaderSet headers = msg.get("http.headers");
	Body messagebody = msg.get("content.body");
	msg.put("requestheaders", headers);
	msg.put("contentbody", messagebody);

	return true;         
}