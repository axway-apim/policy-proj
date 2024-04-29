import com.vordel.mime.Body;
import com.vordel.trace.Trace;
import java.io.ByteArrayOutputStream;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.text.DecimalFormat;

def invoke(msg)	{
	int FAILURE_CODE = -1;
	int SUCCESS_CODE = 0;
	
	String[] productMap = new String[6];
	productMap[0] = "Joe";
	productMap[1] = "Bill";
	productMap[2] = "Robin";
	productMap[3] = "Nicolas";
	productMap[4] = "Franck";
	productMap[5] = "Mark";
	
	StringBuffer response = new StringBuffer(); 
	
	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	Body body = msg.get("content.body");
	body.write(baos, 0);
	String payload = new String(baos.toByteArray());
	String soapVersion = msg.get("soap.version");
	String method = msg.get("soap.request.method");
	msg.put("response", "<Error/>");
	
	// Set root tag with appropriate version 
	response.append("<soapenv:Envelope xmlns:soapenv=\"" + soapVersion + "\" xmlns:ban=\"http://axway.com/BankingServices/\">");
	response.append("<soapenv:Header/>");
	response.append("<soapenv:Body>");
	
	if ("FindAccountId".equals(method)) {
		int result = FAILURE_CODE;
		String AccountName = "";
		String token = ":AccountName>";
		int beginIndex = payload.indexOf(token) + token.length();
		int lastIndex = payload.indexOf("<", beginIndex);
		if (beginIndex >=0 && lastIndex>=0) {
			AccountName = payload.substring(beginIndex, lastIndex);
		}
		
		
		for (int i=0; i < productMap.length; i++){
			if (AccountName.startsWith(productMap[i])){
				result = i;
				break;
			}
		}
		response.append("<ban:FindAccountIdResponse>");
        response.append("<ban:FindAccountIdResult>"+result+"</ban:FindAccountIdResult>");
		response.append("</ban:FindAccountIdResponse>");
	} else if ("GetAccountName".equals(method)) {
		String AccountName = "";
		
		String token = ":AccountID>";
		int beginIndex = payload.indexOf(token) + token.length();
		int lastIndex = payload.indexOf("<", beginIndex);
		
		if (beginIndex >=0 && lastIndex>=0) {
			AccountName = payload.substring(beginIndex, lastIndex);
			int AccountID = -1;
			
			try {
				AccountID = Integer.parseInt(AccountName);
				if (AccountID >= 0 && AccountID < productMap.size()) {
					AccountName = productMap[AccountID];
				} else {
					AccountName = "";
				}
			} catch (Exception e) {
				return false;
			}
			
			response.append("<ban:GetAccountNameResponse>");
			response.append("<ban:GetAccountNameResult>" + AccountName + "</ban:GetAccountNameResult>");
			response.append("</ban:GetAccountNameResponse>");
		} else {
			Trace.info("*** return false");
			return false;
		}
	} else if ("AccountBalance".equals(method)) {
		DecimalFormat df = new DecimalFormat("####.##");
		
		response.append("<ban:AccountBalanceResponse>");
		response.append("<ban:AccountBalanceResult>" + df.format(Math.random()*500.0) + "</ban:AccountBalanceResult>");
		response.append("</ban:AccountBalanceResponse>");
		
	} else if ("testTimeout".equals(method)) {
		DecimalFormat df = new DecimalFormat("####.##");
		String AccountName = "";
		
		String token = ":AccountID>";
		int beginIndex = payload.indexOf(token) + token.length();
		int lastIndex = payload.indexOf("<", beginIndex);
		
		if (beginIndex >=0 && lastIndex>=0) {
			AccountName = payload.substring(beginIndex, lastIndex);
			int AccountID = -1;
			
			try {
				AccountID = Integer.parseInt(AccountName);
				if (AccountID >= 0 && AccountID < productMap.size()) {
					AccountName = productMap[AccountID];
				} else {
					AccountName = "";
				}
			} catch (Exception e) {
				return false;
			}
			
			Thread.sleep(AccountID*1000);
			
			response.append("<ban:testTimeoutResponse>");
			response.append("<ban:testTimeoutResult>" + df.format(Math.random()*500.0) + "</ban:testTimeoutResult>");
			response.append("</ban:testTimeoutResponse>");
		}
	} else {
		return false;
	}

	response.append("</soapenv:Body>");
	response.append("</soapenv:Envelope>");
	
	msg.put("response", response);
	
	return true;
}