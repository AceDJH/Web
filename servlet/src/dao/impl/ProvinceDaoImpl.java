package dao.impl;

import dao.ProvinceDao;
import domain.Province;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCProvinceUtils;
import util.JDBCUtils;

import java.util.List;

/**
 * @Author AceDJH
 * @Date 2020/4/4 17:07
 */
public class ProvinceDaoImpl implements ProvinceDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCProvinceUtils.getDataSource());

    @Override
    public List<Province> findAll() {
        String sql = "select * from province";
        List<Province> list = template.query(sql, new BeanPropertyRowMapper<>(Province.class));
        return list;
    }
}
