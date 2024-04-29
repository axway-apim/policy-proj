def invoke(msg)         {            
     def headers = msg.get("http.headers");
     def newHeader = headers.getClass().newInstance();
     newHeader.setHeader("ASE-Token", msg.get("ASE-Token"));
     if(msg.get("cookie.PISESSIONID.value") != null) {
          newHeader.setHeader("Cookie", "PISESSIONID="+msg.get("cookie.PISESSIONID.value"));
     }
     msg.put("newHeader", newHeader);
     return true;  
}