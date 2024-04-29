function invoke(msg) 
{ 
    var businessUser = msg.get("businessUserGroup");
    var adminsUser = msg.get("adminsUserGroup");
    var userCn= "cn=" + msg.get("userCn");

    for (i=0; i<businessUser.size(); i++) {
      if (businessUser.get(i).indexOf(userCn) !== -1) {
        msg.set("organizationName", "Sales");
        msg.set("roleName", "oadmin");
        return true;
      }
    }

    for (i=0; i<adminsUser.size(); i++) {
      if (adminsUser.get(i).indexOf(userCn) !== -1) {
        msg.set("organizationName", "API Development");
        msg.set("roleName", "admin");
        return true;
      }
    }

    msg.set("organizationName", "Community");
    msg.set("roleName", "user");
    return true;   
}
