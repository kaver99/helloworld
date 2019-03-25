package db.com.test;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import db.com.test.sql.util.SqlMapSessionFactory;

public class DataDAO {
	SqlSessionFactory sqlSessionFactory;

	/**
	 * XML로 작성된 Mybatis 설정 사용 시
	 */
	public DataDAO() {
		sqlSessionFactory = SqlMapSessionFactory.getSqlSessionFactory();
	}
	
	/**
	 * Class로 작성된 Mybatis 설정 사용 시
	 */
//	public DataDAO() {
//		sqlSessionFactory = SqlSessionManager.getSqlSession();
//	}
	
	/**
	 * SQL Data Select
	 * @param data
	 * @return
	 */
	public DataDTO selectData(Map<String, String> data) {
		SqlSession session = sqlSessionFactory.openSession();
		DataDTO dataDTO;
		try {
			dataDTO = session.selectOne("dataMapper.selectData", data);
		} finally {
			session.close();
		}

		return dataDTO;
	}
	
}
