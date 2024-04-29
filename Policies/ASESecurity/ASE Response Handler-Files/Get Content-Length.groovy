import com.vordel.trace.Trace;

def invoke(msg)        
{        
    def content = msg.get("content.body");
    if (content != null) {
       msg.put("content.length",content.getContentLength(0));
    }    
    return true;         
}
