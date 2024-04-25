package Controller;

import Model.HoKhau;
import DAO.HoKhauDAO;

import java.util.ArrayList;

public class HoKhauController {
	private HoKhauDAO HoKhauDAO;

	public HoKhauController() {
		this.HoKhauDAO = new HoKhauDAO();
	}
	
	 public void themHoKhau(HoKhau hokhau) {
	        HoKhauDAO.insert(hokhau);
	    }

	    public void capNhatHoKhau(HoKhau hokhau) {
	    	HoKhauDAO.update(hokhau);
	    }
	    
	    public void xoaHoKhau(HoKhau hokhau) {
	    	HoKhauDAO.delete(hokhau);
	    }

	    public HoKhau timHoKhau(HoKhau hokhau) {
	        return HoKhauDAO.selectByusername(hokhau);
	    }
	    
	    public boolean isExit(HoKhau hokhau) {
	    	return HoKhauDAO.checkExit(hokhau);
	    }
	    
	    public ArrayList<HoKhau> chonTatCa() {
	        return HoKhauDAO.selectALL();
	    }
	    
	    public ArrayList<HoKhau> chonTheoDieuKien(String condition) {
	        return HoKhauDAO.selectByCondition(condition);
	    }
}
