package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.JDBCUntil;
import Model.QuanHe;

public class QuanHeDAO implements DAOInterface<QuanHe> {
	public static QuanHeDAO getInstance() {
		return new QuanHeDAO();
	}
	
    @Override
    public int insert(QuanHe quanHe) {
        try {
        	Connection con = JDBCUntil.getConnection();
        	
        	Statement st = con.createStatement();
        	
        	String sql = "INSERT INTO tbl_quanhe (nhan_khau, quan_he, quan_he, tam_tru, tam_vang) " + 
        				"VALUES (" + quanHe.getID_nhankhau() + ", " + quanHe.getID_hokhau()
        				 + ", " + "'" + quanHe.getQuan_he() + "'" + ", " + quanHe.isTam_tru()
        				 + ", " + quanHe.isTam_vang() + ")";
        	
        	int thongbao = st.executeUpdate(sql);
        	
        	System.out.println("Ban da thuc hien cau lenh" + sql);
    		System.out.println("Co " + thongbao +" dong bi thay doi");
    		
    		JDBCUntil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int update(QuanHe quanHe) {
    	try {
			Connection con = JDBCUntil.getConnection();
			
			Statement st = con.createStatement();		

			String sql = "UPDATE tbl_quanhe" +
						" SET" + 
						" ID_hokhau = " + quanHe.getID_hokhau() +
						",quan_he = '" + quanHe.getQuan_he() + "'" +
						",tam_tru = " + quanHe.isTam_tru() +
						",tam_vang = " + quanHe.isTam_vang() +
						"WHERE ID_nhankhau = " + quanHe.getID_nhankhau()  ;
		
		int ketQua = st.executeUpdate(sql);
			

		System.out.println("Ban da thuc hien cau lenh" + sql);
		System.out.println("Co " + ketQua +" dong bi thay doi");

		JDBCUntil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
    }

    @Override
    public int delete(QuanHe quanHe) {
    	try {
			Connection con = JDBCUntil.getConnection();
			
			Statement st = con.createStatement();		

			String sql = "DELETE FROM tbl_quanhe" +
						"WHERE ID_nhankhau = " + quanHe.getID_nhankhau()  ;
		
		int ketQua = st.executeUpdate(sql);
			

		System.out.println("Ban da thuc hien cau lenh" + sql);
		System.out.println("Co " + ketQua +" dong bi thay doi");

		JDBCUntil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
    }

    @Override
    public QuanHe selectByusername(QuanHe quanHe) {
        QuanHe ketQua = null;
        
        try {
			Connection con = JDBCUntil.getConnection();
			
			Statement st = con.createStatement();		

			String sql = "SELECT* FROM tbl_quanhe WHERE ID_nhankhau = " + quanHe.getID_nhankhau();
			
			ResultSet rs = st.executeQuery(sql);
			System.out.println("Ban da thuc hien cau lenh " + sql);
			
			while(rs.next()) {
				QuanHe quan_he = new QuanHe();
				quan_he.setID_nhankhau(rs.getInt("ID_nhankhau"));
				quan_he.setID_hokhau(rs.getInt("ID_hokhau"));
				quan_he.setQuan_he(rs.getString("quan_he"));
				quan_he.setTam_tru(rs.getBoolean("tam_tru"));
				quan_he.setTam_vang(rs.getBoolean("tam_vang"));
				ketQua = quan_he;
			}
			
		JDBCUntil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketQua;
    } 
    
	@Override
	public boolean checkExit(QuanHe t) {
		QuanHe quanHe = QuanHeDAO.getInstance().selectByusername(t);
		if (quanHe != null) {
			return true;
		}
		return false;
	}

	@Override
	public ArrayList<QuanHe> selectALL() {
		ArrayList<QuanHe> ketQua = new ArrayList<QuanHe>();
		try {
			Connection con = JDBCUntil.getConnection();
			
			Statement st = con.createStatement();		

			String sql = "SELECT* FROM tbl_quanhe" ;
		
			ResultSet rs = st.executeQuery(sql);
			
			System.out.println("Ban da thuc hien cau lenh " + sql);
			System.out.println("Co " + ketQua +" dong bi thay doi");
			
			while(rs.next()) {
				QuanHe quan_he = new QuanHe();
				quan_he.setID_nhankhau(rs.getInt("ID_nhankhau"));
				quan_he.setID_hokhau(rs.getInt("ID_hokhau"));
				quan_he.setQuan_he(rs.getString("quan_he"));
				quan_he.setTam_tru(rs.getBoolean("tam_tru"));
				quan_he.setTam_vang(rs.getBoolean("tam_vang"));
				ketQua.add(quan_he);
			}
			
			JDBCUntil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public ArrayList<QuanHe> selectByCondition(String condition) {
		ArrayList<QuanHe> ketQua = new ArrayList<QuanHe>();
		try {
			Connection con = JDBCUntil.getConnection();
			
			Statement st = con.createStatement();		

			String sql = "SELECT* FROM tbl_quanhe WHERE " + condition ;
			System.out.println("Ban da thuc hien cau lenh " + sql);
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				QuanHe quan_he = new QuanHe();
				quan_he.setID_nhankhau(rs.getInt("ID_nhankhau"));
				quan_he.setID_hokhau(rs.getInt("ID_hokhau"));
				quan_he.setQuan_he(rs.getString("quan_he"));
				quan_he.setTam_tru(rs.getBoolean("tam_tru"));
				quan_he.setTam_vang(rs.getBoolean("tam_vang"));
				ketQua.add(quan_he);
			}
		
		JDBCUntil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketQua;
	}
}
