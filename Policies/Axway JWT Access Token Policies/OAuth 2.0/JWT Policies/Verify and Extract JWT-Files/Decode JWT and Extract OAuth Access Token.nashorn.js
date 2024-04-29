 var base64Import = new JavaImporter(com.vordel.common.base64);

 with(base64Import) {
     function invoke(msg) {

	//Get JWT from message
	var jwtBody = msg.get("var.axway.jwt.accesstoken");

	//Split JWT to get Claims
   	var jwtArray = jwtBody.split('.');

	msg.put("var.axway.jwt.arr.header", jwtArray[0]);
	msg.put("var.axway.jwt.arr.payload", jwtArray[1]);
	msg.put("var.axway.jwt.arr.signature", jwtArray[2]);

	//Decode Claims from Base64 to JSON String 
	var claimsDecoded = Decoder.decodeToString(jwtArray[1]);

	//Create JSON Object from claims
	var jsonObj = JSON.parse(claimsDecoded);

	msg.put("var.axway.oauth.accesstoken", jsonObj.access_token );
    	msg.put("var.axway.jwt.claims", claimsDecoded );


         return true;
     }

 };