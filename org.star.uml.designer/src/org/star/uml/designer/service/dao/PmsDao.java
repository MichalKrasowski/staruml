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
			InputStream in = new FileInputStream((File)inputData.get("img"));
			pstmt.setBlob(2, in);
			pstmt.setString(3, inputData.get("seq").toString());
			pstmt.executeUpdate();
			con.commit();
			in.close();
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
			in.close();
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
			
			System.out.println("name ===== " + inputData.get("name"));
			System.out.println("seq ==== " + inputData.get("seq"));
			System.out.println("userId ==== " + inputData.get("userId"));
			System.out.println("parentSeq ==== " + inputData.get("parentSeq"));
			pstmt.setString(1, inputData.get("name").toString());
			pstmt.setInt(2, Integer.valueOf(inputData.get("seq").toString()));
			pstmt.setString(3, inputData.get("userId").toString());
			pstmt.setInt(4, Integer.valueOf(inputData.get("parentSeq").toString()));
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
			pstmt.setString(2, inputData.get("seq").toString());
			
			int resultint = pstmt.executeUpdate();
			con.commit();
			in.close();
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
	
	public void clazzInsert(Map inputData) throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = pool.getConnection();
			con.setAutoCommit(false);
			String sql = CustomMessages.CLAZZ_INSERT_SQL;
			System.out.println("name ===== " + inputData.get("name"));
			System.out.println("seq ==== " + inputData.get("seq"));
			System.out.println("userId ==== " + inputData.get("userId"));
			System.out.println("parentSeq ==== " + inputData.get("parentSeq"));
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, inputData.get("name").toString());
			pstmt.setString(2, inputData.get("divId").toString());
			pstmt.setInt(3, Integer.valueOf(inputData.get("seq").toString()));
			pstmt.setInt(4, Integer.valueOf(inputData.get("parentSeq").toString()));
			pstmt.setString(5, inputData.get("userId").toString());
			int resultint = pstmt.executeUpdate();
			con.commit();
		} catch (Exception e) {
			con.rollback();
			e.printStackTrace();
		}finally{
			freeConnection(con, pstmt, rs);
		}
	}
	
	public String clazzDevelopIdMax(){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String developId = "DEV_01";
		try {
			con = pool.getConnection();
			String sql = CustomMessages.CLAZZ_DEVSEQ_MAX_SQL;
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			if(rs.next()){
				developId = rs.getString("CNT");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			freeConnection(con, pstmt, rs);
		}
		
		return developId;
	}
	
	public int clazzSeqMax(){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int cnt = 1;
		try {
			con = pool.getConnection();
			String sql = CustomMessages.CLAZZ_SEQ_MAX_SQL;
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			if(rs.next()){
				cnt = rs.getInt("CNT");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			freeConnection(con, pstmt, rs);
		}
		
		return cnt;
	}
	
	public int sequenceSeqMax(){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int cnt = 1;
		try {
			con = pool.getConnection();
			String sql = CustomMessages.SEQUENCE_MAXSEQ_SQL;
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			if(rs.next()){
				cnt = rs.getInt("CNT");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			freeConnection(con, pstmt, rs);
		}
		
		return cnt;
	}
	
	
	public void clazzUpdate(Map inputData) throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = pool.getConnection();
			con.setAutoCommit(false);
			String sql = CustomMessages.CLAZZ_UPDATE_SQL;
			pstmt = con.prepareStatement(sql);
			InputStream in = new FileInputStream((File)inputData.get("img"));
			pstmt.setString(1, inputData.get("name").toString());
			pstmt.setBlob(2, in);
			pstmt.setString(3, inputData.get("userId").toString());
			pstmt.setString(4, inputData.get("seq").toString());
			int resultint = pstmt.executeUpdate();
			con.commit();
			in.close();
		} catch (Exception e) {
			con.rollback();
			e.printStackTrace();
		}finally{
			freeConnection(con, pstmt, rs);
		}
	}
	
	public void sequenceDelete(String seq) throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = pool.getConnection();
			con.setAutoCommit(false);
			String sql = CustomMessages.ANALYSIS_DELETE_SQL;
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, seq);
			
			pstmt.executeUpdate();
			con.commit();
		} catch (Exception e) {
			con.rollback();
			e.printStackTrace();
		}finally{
			freeConnection(con, pstmt, rs);
		}
		
	}
	
	public void clazzDelete(String seq) throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = pool.getConnection();
			con.setAutoCommit(false);
			String sql = CustomMessages.CLAZZ_DELETE_SQL;
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, seq);
			
			pstmt.executeUpdate();
			con.commit();
		} catch (Exception e) {
			con.rollback();
			e.printStackTrace();
		}finally{
			freeConnection(con, pstmt, rs);
		}		
	}
	
	public int clazzSequenceCount(String seq){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int cnt = 1;
		try {
			con = pool.getConnection();
			String sql = CustomMessages.CLAZZ_SEQUENCE_COUNT_SQL;
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, seq);
			
			rs = pstmt.executeQuery();
			if(rs.next()){
				cnt = rs.getInt("CNT");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			freeConnection(con, pstmt, rs);
		}
		
		return cnt;
	}
}
