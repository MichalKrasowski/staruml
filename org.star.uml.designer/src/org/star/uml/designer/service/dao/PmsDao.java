package org.star.uml.designer.service.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.star.uml.designer.base.constance.CustomMessages;
import org.star.uml.designer.base.db.DBConnectionMgr;
import org.star.uml.designer.base.utils.ResultUtil;
import org.star.uml.designer.service.uvo.LoginInfo;

public class PmsDao {
	//private static DBConnectionMgr pool = null;
	private static DBConnectionMgr pool = new DBConnectionMgr();
	
	public Boolean loginValidation(String id, String pw){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Boolean flag = false;
		try {
			con = pool.getConnection();
			String sql = CustomMessages.LOGIN_SQL;
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			rs = pstmt.executeQuery();
			if(rs.next()){
				int cnt = rs.getInt("CNT");
				flag = cnt == 0 ? false : true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			freeConnection(con, pstmt, rs);
		}
		
		return flag;
	}
	
	public List usecaseList(){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List list = new ArrayList();
		try {
			con = pool.getConnection();
			String sql = CustomMessages.USECASE_LIST_SQL;
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			list = ResultUtil.transDatasList(rs);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			freeConnection(con, pstmt, rs);
		}
		return list;
	}
	
	public void projectUpdate(Map inputData) throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = pool.getConnection();
			con.setAutoCommit(false);
			String sql = CustomMessages.PROJECT_UPDATE_SQL;
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, inputData.get("name").toString());
			pstmt.setString(2, inputData.get("seq").toString());
			
			pstmt.executeUpdate();
			con.commit();
		} catch (Exception e) {
			con.rollback();
			e.printStackTrace();
		}finally{
			freeConnection(con, pstmt, rs);
		}
		
	}
	
	public void diragramUpdate(Map inputData) throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = pool.getConnection();
			con.setAutoCommit(false);
			String sql = CustomMessages.DIAGRAM_UPDATE_SQL;
			pstmt = con.prepareStatement(sql);
			InputStream in = new FileInputStream((File)inputData.get("img"));
			pstmt.setBlob(1, in);
			pstmt.setString(2, inputData.get("parentSeq").toString());
			
			pstmt.executeUpdate();
			con.commit();
		} catch (Exception e) {
			con.rollback();
			e.printStackTrace();
		}finally{
			freeConnection(con, pstmt, rs);
		}
		
	}
	
	public void analysis_insert(Map inputData) throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = pool.getConnection();
			con.setAutoCommit(false);
			String sql = CustomMessages.ANALYSIS_INSERT;
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, inputData.get("name").toString());
			pstmt.setString(2, inputData.get("REQ_USECASE_SEQ").toString());
			pstmt.executeUpdate();
			con.commit();
		} catch (Exception e) {
			con.rollback();
			e.printStackTrace();
		}finally{
			freeConnection(con, pstmt, rs);
		}
		
	}
	
	public void analysisUpdate(Map inputData) throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = pool.getConnection();
			con.setAutoCommit(false);
			String sql = CustomMessages.ANALYSIS_UPDATE_SQL;
			pstmt = con.prepareStatement(sql);
			InputStream in = new FileInputStream((File)inputData.get("img"));
			pstmt.setBlob(1, in);
			pstmt.setString(2, inputData.get("REQ_USECASE_SEQ").toString());
			
			int resultint = pstmt.executeUpdate();
			con.commit();
		} catch (Exception e) {
			con.rollback();
			e.printStackTrace();
		}finally{
			freeConnection(con, pstmt, rs);
		}
		
	}
	
	public List projectList(){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List list = new ArrayList();
		try {
			con = pool.getConnection();
			String sql = CustomMessages.PROJECT_LIST_SQL;
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			list = ResultUtil.transDatasList(rs);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			freeConnection(con, pstmt, rs);
		}
		return list;
	}
	
	public static void freeConnection(Connection con, PreparedStatement pstmt, ResultSet rs){
		try{
			if(!con.isClosed())
				con.close();
			if(pstmt != null)
				pstmt.close();
			if(rs != null)
				rs.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
