var base64Import = new JavaImporter(java.util.Base64, java.nio.charset);

with(base64Import){
    function invoke(msg)
    {
        var data = msg.get("data");
        var base64EncodedData = Base64.getEncoder().encodeToString(data.getBytes(StandardCharsets.UTF_8));
        msg.put("data.base64", base64EncodedData);
        return true;
    }
};