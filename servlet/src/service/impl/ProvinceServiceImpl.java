package service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.ProvinceDao;
import dao.impl.ProvinceDaoImpl;
import domain.Province;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import service.ProvinceService;
import util.JedisPoolUtils;

import java.util.List;

/**
 * @Author AceDJH
 * @Date 2020/4/4 17:09
 */
public class ProvinceServiceImpl implements ProvinceService {
    private ProvinceDao dao = new ProvinceDaoImpl();
    @Override
    public List<Province> findAll() {
        return dao.findAll();
    }

    // 使用redis的缓存
    @Override
    public String findAllJson() {
        System.out.println("使用了findAllJson");
        // 先从redis中查询数据
        Jedis jedis = JedisPoolUtils.getJedis();
        String province_json = jedis.get("province");
        System.out.println(province_json);

        // 判断province_json是否为null
        if (province_json == null || province_json.length() == 0){
            // redis中没有数据
            // 从mysql数据库中查询
            System.out.println("redis中没数据，查询数据库");
            List<Province> provinces = dao.findAll();
            // 将list数列化为json
            ObjectMapper mapper = new ObjectMapper();
            try {
                province_json = mapper.writeValueAsString(provinces);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            // 将json数据存入redis中
            jedis.set("province", province_json);
            jedis.close();
        }else {
            System.out.println("redis中有数据，查询缓存");
        }
        System.out.println("结束了findAllJson");
        return province_json;
    }
}
