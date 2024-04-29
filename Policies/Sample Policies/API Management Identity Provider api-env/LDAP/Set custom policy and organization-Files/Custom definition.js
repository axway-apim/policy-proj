function invoke(msg) 
{
    var userName=msg.get("authN.loginname");

    if (userName == "alex") {
      msg.put("organizationName", "API Development");
      msg.put("roleName", "admin");
      return true;
    } else if (userName == "angel") {
      msg.put("organizationName", "API Development");
      msg.put("roleName", "admin");
      return true;
    } else if (userName == "anna") {
      msg.put("organizationName", "Community");
      msg.put("roleName", "oadmin");
      return true;
    } else if (userName == "dave") {
      msg.put("organizationName", "Partners");
      msg.put("roleName", "user");
      return true;
    } else if (userName == "fred") {
      msg.put("organizationName", "FHIR");
      msg.put("roleName", "admin");
      return true;
    } else if (userName == "renee") {
      msg.put("organizationName", "Partners");
      msg.put("roleName", "oadmin");
      return true;
    } else if (userName == "oliver") {
      msg.put("organizationName", "API Development");
      msg.put("roleName", "admin");
      return true;
    }

    msg.put("organizationName", "Community");
    msg.put("roleName", "user");
    return true;
}