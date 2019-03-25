package db.com.test.sql.util;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlMapSessionFactory {

	public static SqlSessionFactory sqlSession;
	
	static {
		String rootPath = System.getProperty("user.dir") + "/config";
		String resource = rootPath + "/mybatis_config.xml";
		
		
		try {
			Reader reader = new FileReader(resource);
			if(sqlSession == null){ 
				sqlSession = new SqlSessionFactoryBuilder().build(reader); 
			}
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSession;
	}
}
