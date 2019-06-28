package impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import sql.SqlMapClient;

public class MainServiceImplDAO {
	
	private static MainServiceImplDAO instance = new MainServiceImplDAO();
	private SqlSession session = SqlMapClient.getSqlSession();
	
	public static MainServiceImplDAO getInstace(){
		if(instance == null){
			instance = new MainServiceImplDAO();
		}
		return instance;
	}
	
	public int insertData(String sqlName, Object obj) throws SQLException{
		int result = session.insert(sqlName, obj);
		
		return result;
	}
	
	public int updateData(String sqlName, Object obj) throws SQLException{
		int result = session.update(sqlName, obj);
		
		return result;
	}
	
	public int deleteData(String sqlName, Object obj) throws SQLException{
		int result = session.delete(sqlName, obj);
		
		return result;
	}
	
	public List selectData(String sqlName, Object obj) throws SQLException{
		List<Object> result = session.selectList(sqlName, obj);
		
		return result;
	}
	
	public List selectData(String sqlName) throws SQLException{
		List<Object> result = session.selectList(sqlName);
		
		return result;
	}
	
}
