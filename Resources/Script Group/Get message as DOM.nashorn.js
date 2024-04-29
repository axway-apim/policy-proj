var imp = new JavaImporter(com.vordel.mime);
with(imp) {
    function invoke(msg) {
        var doc = XMLBody.getDocument(msg);
        return true;
    }
};