package org.star.uml.designer.service.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.star.uml.designer.service.uvo.LoginInfo;
import org.star.uml.designer.service.uvo.RoleInfo;
import org.star.uml.designer.service.uvo.UserInfo;


public class UserMgtDao {

	public boolean createUser(UserInfo userInfo) {

		PreparedStatement pstmt = null;
		Connection conn = null;
		try {
			conn = LoginInfo.conn;

			conn.setAutoCommit(false);

			StringBuffer buff = new StringBuffer();
			buff.append(" INSERT INTO BPA_USER_T (");
			buff.append(" USER_ID, USER_PASSWORD, USER_NAME,");
			buff.append(" USER_PHONE, USER_EMAIL, USER_FLAG)");
			buff.append(" VALUES ( ?, ?, ?,");
			buff.append(" ?, ?, 'Y' )");

			pstmt = conn.prepareStatement(buff.toString());

			pstmt.setString(1, userInfo.getUserId());
			pstmt.setString(2, userInfo.getUserPassword());
			pstmt.setString(3, userInfo.getUserName());
			pstmt.setString(4, userInfo.getUserPhone());
			pstmt.setString(5, userInfo.getUserEmail());
			pstmt.executeUpdate();

			buff = new StringBuffer();
			buff.append(" INSERT INTO BPA_ROLE_T (");
			buff.append(" USER_ID, GROUP_ID, OBJECT_SEQ,");
			buff.append(" ROLE_VALUE)");
			buff.append(" VALUES ( ?, null, 1, '0001')");

			pstmt = conn.prepareStatement(buff.toString());

			pstmt.setString(1, userInfo.getUserId());
			pstmt.executeUpdate();

			conn.commit();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				pstmt.close();
				pstmt = null;
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return true;
	}

	public boolean deleteUser(String userId) {

		PreparedStatement pstmt = null;
		Connection conn = LoginInfo.conn;

		try {

			conn.setAutoCommit(false);

			StringBuffer buff = new StringBuffer();
			buff.append(" UPDATE BPA_USER_T SET USER_FLAG='N' WHERE USER_ID=?");

			pstmt = conn.prepareStatement(buff.toString());

			pstmt.setString(1, userId);
			pstmt.executeUpdate();

			conn.commit();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				pstmt.close();
				pstmt = null;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return true;
	}

	public boolean modifyUser(UserInfo userUvo) {

		PreparedStatement pstmt = null;

		try {
			Connection conn = LoginInfo.conn;

			conn.setAutoCommit(false);

			StringBuffer buff = new StringBuffer();
			buff.append(" UPDATE BPA_USER_T ");
			buff.append(" SET USER_NAME=?, USER_PASSWORD=?,");
			buff.append(" USER_PHONE=?,USER_EMAIL=?");
			buff.append(" WHERE USER_ID=? ");

			pstmt = conn.prepareStatement(buff.toString());

			pstmt.setString(1, userUvo.getUserName());
			pstmt.setString(2, userUvo.getUserPassword());
			pstmt.setString(3, userUvo.getUserPhone());
			pstmt.setString(4, userUvo.getUserEmail());
			pstmt.setString(5, userUvo.getUserId());
			pstmt.executeUpdate();

			conn.commit();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				pstmt.close();
				pstmt = null;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return true;
	}

	public List<UserInfo> getListUser() {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuffer sql = new StringBuffer();

		List<UserInfo> result = new ArrayList<UserInfo>();

		try {

			sql
					.append("SELECT USER_ID,USER_NAME,USER_PHONE,USER_EMAIL,USER_FLAG");
			sql.append(" FROM BPA_USER_T WHERE USER_FLAG='Y'");

			pstmt = LoginInfo.conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();

			// 값 다 집어 넣기
			while (rs.next()) {

				UserInfo info = new UserInfo();
				info.setUserId(rs.getString("USER_ID"));
				info.setUserName(rs.getString("USER_NAME"));
				info.setUserPhone(rs.getString("USER_PHONE"));
				info.setUserEmail(rs.getString("USER_EMAIL"));
				info.setUserFlag(rs.getString("USER_FLAG"));

				result.add(info);

			}

		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			try {
				pstmt.close();
				rs.close();
				pstmt = null;
				rs = null;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	public List<UserInfo> getListUserInGroup(String groupId) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuffer sql = new StringBuffer();

		List<UserInfo> result = new ArrayList<UserInfo>();

		try {

			sql.append(" SELECT BUT.USER_ID, BUT.USER_NAME");
			sql.append(" FROM BPA_USER_T BUT, BPA_USER_GROUP_T BUGT");
			sql.append(" WHERE BUT.USER_ID=BUGT.USER_ID AND BUT.USER_FLAG='Y'");
			sql.append(" AND BUGT.GROUP_ID=?");

			pstmt = LoginInfo.conn.prepareStatement(sql.toString());
			pstmt.setString(1, groupId);
			rs = pstmt.executeQuery();

			// 값 다 집어 넣기
			while (rs.next()) {

				UserInfo info = new UserInfo();
				info.setUserId(rs.getString("USER_ID"));
				info.setUserName(rs.getString("USER_NAME"));

				result.add(info);

			}

		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			try {
				pstmt.close();
				rs.close();
				pstmt = null;
				rs = null;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	public UserInfo userAuthenticate(Connection conn, String user,
			String password) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		StringBuffer sql = new StringBuffer();
		sql.append("SELECT USER_ID, USER_NAME, USER_FLAG ");
		sql.append("FROM   BPA_USER_T ");
		sql
				.append("WHERE  USER_ID = ? and USER_PASSWORD = ? AND (USER_FLAG='Y' OR USER_FLAG='A')");

		UserInfo userInfo = new UserInfo();

		try {
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, user);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				userInfo.setUserId(rs.getString("USER_ID"));
				userInfo.setUserName(rs.getString("USER_NAME"));
				userInfo.setUserFlag(rs.getString("USER_FLAG"));
			} else {
				return null;
			}

			LoginInfo.userInfo = userInfo;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				pstmt.close();
				rs.close();
				pstmt = null;
				rs = null;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return userInfo;
	}

	public Map<String, String> getPolicy(Connection conn) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT POLICY_DIVISION, POLICY_PRIVILEGE ");
		sql.append(" FROM   BPA_POLICY_T ");

		Map<String, String> policy = new HashMap<String, String>();

		try {
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				policy.put(rs.getString("POLICY_DIVISION"), rs
						.getString("POLICY_PRIVILEGE"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				pstmt.close();
				rs.close();
				pstmt = null;
				rs = null;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return policy;
	}

	public Map<Integer, String> getMyPolicy(Connection conn) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT   OBJECT_SEQ,");
		sql.append(" CASE");
		sql.append(" WHEN SUM (SUBSTR (role_value, 1, 1)) > 0");
		sql.append(" THEN '1'");
		sql.append(" ELSE '0'");
		sql.append(" END");
		sql.append(" || CASE");
		sql.append(" WHEN SUM (SUBSTR (role_value, 2, 1)) > 0");
		sql.append(" THEN '1'");
		sql.append(" ELSE '0'");
		sql.append(" END");
		sql.append(" || CASE");
		sql.append(" WHEN SUM (SUBSTR (role_value, 3, 1)) > 0");
		sql.append(" THEN '1'");
		sql.append(" ELSE '0'");
		sql.append(" END");
		sql.append(" || CASE");
		sql.append(" WHEN SUM (SUBSTR (role_value, 4, 1)) > 0");
		sql.append(" THEN '1'");
		sql.append(" ELSE '0'");
		sql.append(" END AS PRIVILIGE");
		sql.append(" FROM bpa_role_t");
		sql.append(" WHERE object_seq IN (");
		sql.append(" SELECT object_seq");
		sql.append(" FROM bpa_role_t br,");
		sql.append(" (SELECT GROUP_ID");
		sql.append(" FROM bpa_user_group_t bugt");
		sql.append(" WHERE bugt.user_id = ?) bb");
		sql.append(" WHERE bb.GROUP_ID = br.GROUP_ID");
		sql.append(" UNION");
		sql.append(" SELECT object_seq");
		sql.append(" FROM bpa_role_t");
		sql.append(" WHERE user_id = ?)");
		sql.append(" GROUP BY object_seq ");

		Map<Integer, String> myPolicy = new HashMap<Integer, String>();

		try {
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, LoginInfo.userInfo.getUserId());
			pstmt.setString(2, LoginInfo.userInfo.getUserId());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				myPolicy
						.put(rs.getInt("OBJECT_SEQ"), rs.getString("PRIVILIGE"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				rs.close();
				pstmt = null;
				rs = null;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return myPolicy;
	}

	public List<RoleInfo> getListRole(Connection conn, Integer objectSeq) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT brt.user_id, brt.GROUP_ID, brt.object_seq,");
		sql
				.append(" bpt.policy_division AS role_value, (SELECT GROUP_NAME FROM BPA_GROUP_T WHERE GROUP_ID=brt.GROUP_ID) GROUP_NAME");
		sql.append(" FROM bpa_role_t brt, bpa_policy_t bpt");
		sql.append(" WHERE brt.object_seq = ?");
		sql.append(" AND bpt.policy_privilege = brt.role_value");

		List<RoleInfo> roles = new ArrayList<RoleInfo>();

		try {

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, objectSeq);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				RoleInfo role = new RoleInfo();
				role.setGroupId(rs.getString("GROUP_ID"));
				role.setObjectSeq(objectSeq);
				role.setRoleValue(rs.getString("ROLE_VALUE"));
				role.setUserId(rs.getString("USER_ID"));
				role.setGroupName(rs.getString("GROUP_NAME"));
				roles.add(role);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				rs.close();
				pstmt = null;
				rs = null;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return roles;
	}

}
