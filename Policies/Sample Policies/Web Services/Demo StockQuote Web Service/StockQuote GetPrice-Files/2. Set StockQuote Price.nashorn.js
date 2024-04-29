function invoke(msg) {
    var randomnumber = Math.floor(Math.random() * 101)
    msg.put("stockquote.price", randomnumber);
    return true;
}