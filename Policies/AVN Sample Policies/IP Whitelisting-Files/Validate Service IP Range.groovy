import com.vordel.trace.Trace;
import java.net.InetSocketAddress; 
import org.springframework.security.web.util.matcher.IpAddressMatcher; 
import com.vordel.circuit.InvocationEngine;

def invoke(msg)        
{   
    def ipRange = msg.get("IpRange"); 
    if (ipRange) {
        def clientIP = msg.get("http.request.clientaddr").getAddress().getHostAddress();
        IpAddressMatcher matcher = new IpAddressMatcher(ipRange); 
        return matcher.matches(clientIP); 
    }
    return true;
}

