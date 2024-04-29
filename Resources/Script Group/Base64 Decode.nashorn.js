var base64Import = new JavaImporter(java.util.Base64, java.nio.charset);

with(base64Import){
    function invoke(msg)
    {
        var data = msg.get("data.base64");
        var base64DecodedData = Base64.getDecoder().decode(data);
        var dataString = new java.lang.String(base64DecodedData, StandardCharsets.UTF_8);
        msg.put("data.decoded", dataString);
        return true;
    }
};