importPackage(Packages.java.util);
importPackage(Packages.java.nio.charset);

function invoke(msg)
{
    var data = msg.get("data");
    var base64EncodedData = Base64.getEncoder().encodeToString(data.getBytes(StandardCharsets.UTF_8));
    msg.put("data.base64", base64EncodedData);
    return true;
}