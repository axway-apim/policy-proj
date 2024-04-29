importPackage(Packages.com.vordel.mime);

function invoke(msg)        
{ 
    var doc = XMLBody.getDocument(msg);
    return true;         
}