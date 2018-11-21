package com.zhou.test.tuil;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


/**
 * 
 * @author Mr_zhou
 * 2018年11月21日 下午10:11:33
 * TODO 
 * 		MyBatis 测试工具
 * 		getOpenSession 获得SqlSession
 * 		getTestMapper 传入dao接口，返回dao实现类
 */
public class SqlSessionFactoryUtil {
	
	private static SqlSessionFactory sqlSessionFactory;
	
	
	static {
		try {
			InputStream inputStream = Resources.getResourceAsStream("mybatis_config_test.xml");
			 sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	
	public static SqlSession getOpenSession() {
		SqlSession session=null;
        try {
            session = sqlSessionFactory.openSession();
        } catch (Exception e) {
			System.out.println(e.getMessage());
		}
        return session;
	}
	
	/**
	 * 
	 * @fun-name getTestMapper
	 * @return-type T
	 * @author Mr_zhou
	 * @date 2018年11月21日 下午10:03:04
	 * @param type
	 * @return
	 * TODO !!! 单元测试专用方法，传入dao接口，返回实现类
	 */
	public static <T> T getTestMapper(Class<T> type) {
		return getOpenSession().getMapper(type);
	}
	
}
