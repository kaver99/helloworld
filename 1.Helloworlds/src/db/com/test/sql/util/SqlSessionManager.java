package db.com.test.sql.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

/**
 * mybatis config java로 작성(config.xml 대처용)
 * @author minsungkim
 *
 */
public class SqlSessionManager {
    public static SqlSessionFactory sqlSession;
    static {
    	// ---------------------------------------------------------
    	// Properties File Read
    	// ---------------------------------------------------------
    	String rootPath = System.getProperty("user.dir") + "/config/database.properties";
		Properties properties = new Properties();
		FileInputStream fis;
		try {
			fis = new FileInputStream(rootPath);
			properties.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
        
    	String jdbc_driver = properties.getProperty("jdbc.driver");
    	String jdbc_url = properties.getProperty("jdbc.url");
    	String jdbc_username = properties.getProperty("jdbc.username");
    	String jdbc_password = properties.getProperty("jdbc.password");
    	
    	// ---------------------------------------------------------
    	// DB Session Setting
    	// ---------------------------------------------------------
        DataSource dataSource = new PooledDataSource(jdbc_driver, jdbc_url, jdbc_username, jdbc_password);
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment( "development", transactionFactory, dataSource );
        Configuration configuration = new Configuration( environment );
        
        // ---------------------------------------------------------
        // Mybatis Mapper Package setting
        // ---------------------------------------------------------
        //아래의 2번에 설정된 인터페이스를 지정합니다.
        configuration.addMappers("db.com.test.mybatis.mapper.oracle.data_Mapper.xml");
//        configuration.addMapper( MybatisMapper.class );
        sqlSession = new SqlSessionFactoryBuilder().build( configuration );
    }
    
    public static SqlSessionFactory getSqlSession() {
        return sqlSession;
    }
}