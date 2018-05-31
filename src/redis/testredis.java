package redis;

import redis.clients.jedis.Jedis;

public class testredis {
    public static void main(String[] args){
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        jedis.auth("1234");
        System.out.println("Server is running: " + jedis.ping());

        jedis.set("he", "cockpit-ovirt");

        System.out.println("Value: "  + jedis.get("he"));
        jedis.close();

    }
}
