 var imports = new JavaImporter(com.vordel.common.base64, java.time.Instant);

 with(imports) {
     function invoke(msg) {

	var expTime = msg.get("expires");
	var instant = Instant.now();
	var msgTime = instant.getEpochSecond();
	
	// Check to token validity -- Expiration
	if (expTime < msgTime) {
		Trace.error("Token has expired");
		return false;
	}
        msg.put("okta.oauth.active",true);
	return true;
     }
 };
