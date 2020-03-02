package util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @Author AceDJH
 * @Date 2020/3/2 19:29
 * JDBC工具类，使用Durid连接池
 */
public class JDBCUtils {
    private static DataSource dataSource;

    static {
        Properties properties = new Properties();
        InputStream resourceAsStream = JDBCUtils.class.getClassLoader().getResourceAsStream("./druid.properties");
        try {
            properties.load(resourceAsStream);
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DataSource getDataSource(){
        return dataSource;
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
