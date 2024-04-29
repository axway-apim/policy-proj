import com.vordel.mime.XMLBody;

def invoke(msg)        
{ 
    def doc = XMLBody.getDocument(msg);
    return true;         
}