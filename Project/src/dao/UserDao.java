package dao;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.DatatypeConverter;

import model.Login;
import model.User;

public class UserDao {
	public User findByLogin(Login login) {
		Connection conn = null;
		User user = null;

		try {
			conn = DBManager.getConnection();

			String sql = "SELECT * FROM user WHERE login_id = ? and password = ?";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, login.getLoginId());
			pStmt.setString(2, convert(login.getPass()));
			ResultSet rs = pStmt.executeQuery();

			if (rs.next()) {
				String loginId = rs.getString("login_id");
				String pass = rs.getString("password");
				int id = rs.getInt("id");
				String name = rs.getString("name");
				Date birthDate = rs.getDate("birth_date");
				String createDate = rs.getString("create_date");
				String updateDate = rs.getString("update_date");
				user = new User(loginId, pass, id, name, birthDate, createDate, updateDate);

			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return user;
	}

	public List<User> findAll() {
		Connection conn = null;
		List<User> userList = new ArrayList<User>();

		try {
			conn = DBManager.getConnection();

			// TODO: 未実装：管理者以外を取得するようSQLを変更する
			String sql = "SELECT * FROM user where login_id != 'admin'";

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				int id = rs.getInt("id");
				String loginId = rs.getString("login_id");
				String name = rs.getString("name");
				Date birthDate = rs.getDate("birth_date");
				String pass = rs.getString("password");
				String createDate = rs.getString("create_date");
				String updateDate = rs.getString("update_date");
				User user = new User(loginId, pass, id, name, birthDate, createDate, updateDate);

				userList.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return userList;
	}



	public List<User> findSerach(String loginIdP, String userNameP, String fromBirthDateP, String toBirthDateP) {
			Connection conn = null;
			List<User> userList = new ArrayList<User>();

			try {
				conn = DBManager.getConnection();

				// TODO: 未実装：管理者以外を取得するようSQLを変更する
				String sql = "SELECT * FROM user where login_id != 'admin'";

				if(!loginIdP.equals("")) {
					sql += " AND login_id = '" + loginIdP + "'";
				}

				if(!userNameP.equals("")) {
					sql += " AND name LIKE '%" + userNameP + "%'";
				}

				if(!fromBirthDateP.equals("")) {
					sql += " AND birth_date >= '" + fromBirthDateP + "'";
				}

				if(!toBirthDateP.equals("")) {
					sql += " AND birth_date <= '" + toBirthDateP + "'";
				}
				System.out.println(sql);

				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);

				while (rs.next()) {
					int id = rs.getInt("id");
					String loginId = rs.getString("login_id");
					String name = rs.getString("name");
					Date birthDate = rs.getDate("birth_date");
					String pass = rs.getString("password");
					String createDate = rs.getString("create_date");
					String updateDate = rs.getString("update_date");
					User user = new User(loginId, pass, id, name, birthDate, createDate, updateDate);

					userList.add(user);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			} finally {

				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
						return null;
					}
				}
			}
		return userList;
	}

	public boolean signUp(String loginId, String pass, String name, String birthDate) {
		Connection conn = null;
		conn = DBManager.getConnection();

		try {
			String sql = "INSERT INTO user (login_id, password, name, birth_date, create_date, update_date) VALUES (?, ?, ?, ?, now(), now())";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, loginId);
			pStmt.setString(2, convert(pass));
			pStmt.setString(3, name);
			pStmt.setString(4, birthDate);
			int rs = pStmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

			return false;
		}
		return true;
	}

	public boolean infoUpdate(String loginId, String pass, String name, String birthDate) {
		Connection conn = null;
		conn = DBManager.getConnection();

		try {
			String sql = "UPDATE user SET password = ?, name = ?, birth_date = ?, update_date = now() WHERE login_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, convert(pass));
			pStmt.setString(2, name);
			pStmt.setString(3, birthDate);
			pStmt.setString(4, loginId);
			int rs = pStmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

			return false;
		}

		return true;

	}

	public void infoDelete(String loginId) {
		Connection conn = null;
		conn = DBManager.getConnection();

		try {
			String sql = "DELETE FROM user WHERE login_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, loginId);
			int rs = pStmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		}

	}

	public ResultSet loginId(int id) {
		Connection conn = null;
		conn = DBManager.getConnection();

		try {
			String sql = "SELECT login_id FROM user WHERE id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, id);
			ResultSet rs = pStmt.executeQuery();

			return rs;

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return null;

	}

	public ResultSet loginId2(int id) {
		Connection conn = null;
		conn = DBManager.getConnection();

		try {
			String sql = "SELECT*FROM user WHERE id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, id);
			ResultSet rs = pStmt.executeQuery();

			return rs;

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return null;

	}

	private String convert(String pass) {
		String source = pass;
		Charset charset = StandardCharsets.UTF_8;
		String algorithm = "MD5";

		byte[] bytes = null;
		try {
			bytes = MessageDigest.getInstance(algorithm).digest(source.getBytes(charset));
		} catch (NoSuchAlgorithmException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}
		String result = DatatypeConverter.printHexBinary(bytes);

		System.out.println(result);

		return result;
	}
}