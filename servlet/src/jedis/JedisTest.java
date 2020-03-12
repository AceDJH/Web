package jedis;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.Map;
import java.util.Set;

/**
 * @Author AceDJH
 * @Date 2020/3/12 14:39
 */
public class JedisTest {
    @Test
    public void test1(){
        // 运行前需要先打开redis文件夹中的redis-server.exe
        Jedis jedis = new Jedis("localhost", 6379);
        // 存储字符串
        jedis.set("username", "lisi");
        // 存储hash
        jedis.hset("user", "name", "linghuchong");
        jedis.hset("user", "age", "28");
        //读取hash
        String name = jedis.hget("user", "name");
        System.out.println(name);
        Map<String, String> user = jedis.hgetAll("user");
        Set<String> keySet = user.keySet();
        for (String s : keySet) {
            System.out.println(s + " : " + user.get(s));
        }
        jedis.close();
    }
}
