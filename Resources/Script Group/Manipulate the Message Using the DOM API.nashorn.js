// This function moves the <enc:ReferenceList> to be before the <dsig:Signature> node.
// This script is useful for WSE 3.0 (.NET) integration when a message that it signed, then
// encrypted is required. When you run the signature generation filter, then the encryption
// filter, the <enc:ReferenceList> will be placed after the <dsig:Signature>. WSE 3.0 requires
// it to be placed before the <dsig:Signature>.
// This function uses the DOM API to move the nodes in the message as required.
var imp = new JavaImporter(com.vordel.mime, org.w3c.dom);

with(imp) {
    function invoke(msg) {


        var doc = XMLBody.getDocument(msg);

        // Get the <soap:Header> node

        var nodes = doc.getDocumentElement().getElementsByTagNameNS(
            "http://schemas.xmlsoap.org/soap/envelope/", "Header");
        if (nodes.getLength() == 0)
            return false;
        var headEle = nodes.item(0);

        // Get the <wsse:Security> node
        nodes = headEle.getElementsByTagNameNS("http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd", "Security");
        if (nodes.getLength() == 0)
            return false;
        var wsseEle = nodes.item(0);

        // Get the <dsig:Signature> node
        nodes = wsseEle.getElementsByTagNameNS("http://www.w3.org/2000/09/xmldsig#", "Signature");
        if (nodes.getLength() == 0)
            return false;
        var signatureEle = nodes.item(0);

        // Get the <enc:ReferenceList>  node
        nodes = wsseEle.getElementsByTagNameNS("http://www.w3.org/2001/04/xmlenc#", "ReferenceList");
        if (nodes.getLength() == 0)
            return false;
        var refListEle = nodes.item(0);

        // Remove the <enc:ReferenceList>  node from its current position
        var removed = doc.removeChild(refListEle);

        // Place the <enc:ReferenceList>  node before the <dsig:Signature> node
        doc.insertBefore(removed, signatureEle);
        return true;
    }
};