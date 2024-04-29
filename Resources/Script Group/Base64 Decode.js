importPackage(Packages.java.util);
importPackage(Packages.java.nio.charset);

function invoke(msg)
{
    var data = msg.get("data.base64");
    var base64DecodedData = Base64.getDecoder().decode(data);
    var dataString = new java.lang.String(base64DecodedData, StandardCharsets.UTF_8);
    msg.put("data.decoded", dataString);
    return true;
}