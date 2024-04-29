def invoke(msg)         {            
     def headers = msg.get("http.headers");
     def newHeader = headers.getClass().newInstance();
     newHeader.setHeader("ASE-Token", msg.get("ASE-Token"));
     msg.put("newHeader", newHeader);
     return true;  
}