function invoke(msg) {
    var ips = [
      "95.115.84.128", "79.205.61.4", "13.37.9.68", "154.83.33.176", 
      "95.164.227.84", "35.245.138.171", "100.37.32.35", "80.92.32.0", 
      "1.208.104.217", "121.115.252.131", "151.38.191.204", 
      "54.68.118.62", "77.0.12.122", "40.95.51.222", 
      "3.249.221.244", "67.236.10.142", "134.238.201.92",
      "77.182.30.192", "20.199.180.48", "80.89.213.13",
      "162.62.133.97", "80.187.107.61", "212.99.80.181",
      "90.118.127.46", "87.67.12.27", "82.113.19.251",
      "95.255.9.84", "2.35.241.114", "62.169.192.15",
      "174.205.193.30", "24.217.40.193", "136.142.115.31",
      "68.168.180.244", "141.207.147.254", "50.252.166.98",
      "96.49.164.211", "3.97.136.203", "155.159.24.75",
      "64.140.139.181", "98.185.249.94", "50.247.80.246",
      "107.143.99.37", "50.37.7.53", "107.41.191.177",
      "155.31.14.30", "45.21.131.111", "76.196.205.229"
    ];

    var randomNo = Math.floor(Math.random() * ips.length);
    var randomIp = ips[randomNo];

    msg.put("xForwardedFor", randomIp);
    return true;
}