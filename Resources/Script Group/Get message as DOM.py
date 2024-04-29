from com.vordel.mime import XMLBody

def invoke(msg):
    doc = XMLBody.getDocument(msg)
    return True