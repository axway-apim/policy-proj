importPackage(Packages.com.vordel.trace);

function invoke(msg)        
{            
    Trace.error("This trace statement was generated in javascript!");
    Trace.debug("This trace statement was generated in javascript!");
    return true;         
}