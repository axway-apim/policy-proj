import com.vordel.mime.HeaderSet;
import com.vordel.mime.Body;

def invoke(msg)
{
	HeaderSet headers = msg.get("requestheaders");
	Body messagebody = msg.get("contentbody");
	msg.put("http.headers", headers);
	msg.put("content.body", messagebody);

	return true;         
}