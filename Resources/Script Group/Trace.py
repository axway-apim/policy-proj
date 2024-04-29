from com.vordel.trace import Trace

def invoke(msg):
    Trace.error("This trace statement was generated in script filter!")
    Trace.debug("This trace statement was generated in script filter!")
    return True