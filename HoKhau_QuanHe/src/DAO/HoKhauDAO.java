package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.JDBCUntil;
import Model.HoKhau;

public class HoKhauDAO implements DAOInterface<HoKhau> {
	public static HoKhauDAO getInstance() {
		return new HoKhauDAO();
	}
	
    @Override
    public int insert(HoKhau hoKhau) {
        try {
        	Connection con = JDBCUntil.getConnection();
        	
        	Statement st = con.createStatement();
        	
        	String sql = "INSERT INTO tbl_hokhau (ID_hokhau, ID_diachi, ID_nhankhau) " + 
        				"VALUES (" + hoKhau.getID_hokhau() + ", " + hoKhau.getID_diachi()
        				 + ", " + hoKhau.getID_nhankhau() + ")";
        	
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
    public int update(HoKhau hoKhau) {
    	try {
			Connection con = JDBCUntil.getConnection();
			
			Statement st = con.createStatement();		

			String sql = "UPDATE tbl_hokhau" +
						" SET" + 
						" ID_diachi = " + hoKhau.getID_diachi() +
						",ID_nhankhau = " + hoKhau.getID_nhankhau() +
						"WHERE ID_hokhau = " + hoKhau.getID_hokhau();
		
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
    public int delete(HoKhau hoKhau) {
    	try {
			Connection con = JDBCUntil.getConnection();
			
			Statement st = con.createStatement();		

			String sql = "DELETE FROM tbl_hokhau" +
						"WHERE ID_hokhau = " + hoKhau.getID_hokhau()  ;
		
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
    public HoKhau selectByusername(HoKhau hoKhau) {
        HoKhau ketQua = null;
        
        try {
			Connection con = JDBCUntil.getConnection();
			
			Statement st = con.createStatement();		

			String sql = "SELECT* FROM tbl_hokhau WHERE ID_hokhau = '" + hoKhau.getID_hokhau() + "'";
			
			ResultSet rs = st.executeQuery(sql);
			System.out.println("Ban da thuc hien cau lenh " + sql);
			
			while(rs.next()) {
				HoKhau ho_khau = new HoKhau();
				ho_khau.setID_hokhau(rs.getInt("ID_hokhau"));
				ho_khau.setID_diachi(rs.getInt("ID_diachi"));
				ho_khau.setID_nhankhau(rs.getInt("ID_nhankhau"));
				ketQua = ho_khau;
			}
			
		JDBCUntil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketQua;
    } 
    
	@Override
	public boolean checkExit(HoKhau t) {
		HoKhau hoKhau = HoKhauDAO.getInstance().selectByusername(t);
		if (hoKhau != null) {
			return true;
		}
		return false;
	}

	@Override
	public ArrayList<HoKhau> selectALL() {
		ArrayList<HoKhau> ketQua = new ArrayList<HoKhau>();
		try {
			Connection con = JDBCUntil.getConnection();
			
			Statement st = con.createStatement();		

			String sql = "SELECT* FROM tbl_hokhau" ;
		
			ResultSet rs = st.executeQuery(sql);
			
			System.out.println("Ban da thuc hien cau lenh " + sql);
			System.out.println("Co " + ketQua +" dong bi thay doi");
			
			while(rs.next()) {
				HoKhau ho_khau = new HoKhau();
				ho_khau.setID_hokhau(rs.getInt("ID_hokhau"));
				ho_khau.setID_diachi(rs.getInt("ID_diachi"));
				ho_khau.setID_nhankhau(rs.getInt("ID_nhankhau"));
				ketQua.add(ho_khau);
			}
			
			JDBCUntil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public ArrayList<HoKhau> selectByCondition(String condition) {
		ArrayList<HoKhau> ketQua = new ArrayList<HoKhau>();
		try {
			Connection con = JDBCUntil.getConnection();
			
			Statement st = con.createStatement();		

			String sql = "SELECT* FROM tbl_hokhau WHERE " + condition ;
			System.out.println("Ban da thuc hien cau lenh " + sql);
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				HoKhau ho_khau = new HoKhau();
				ho_khau.setID_hokhau(rs.getInt("ID_hokhau"));
				ho_khau.setID_diachi(rs.getInt("ID_diachi"));
				ho_khau.setID_nhankhau(rs.getInt("ID_nhankhau"));
				ketQua.add(ho_khau);
			}
		
		JDBCUntil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketQua;
	}
}
