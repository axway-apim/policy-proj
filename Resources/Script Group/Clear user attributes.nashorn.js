function invoke(msg) {

    var userProperties = msg.get("attribute.lookup.list");

    if (userProperties == null)
        return true;

    userProperties.clear();
    return true;
}