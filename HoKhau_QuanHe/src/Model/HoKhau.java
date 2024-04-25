package Model;

public class HoKhau {
	private int ID_hokhau;
	private int ID_diachi;
	private int ID_nhankhau;
	
	public HoKhau(int hk, int dc, int iD_nhankhau) {
		this.ID_hokhau = hk;
		this.ID_diachi = dc;
		this.ID_nhankhau = iD_nhankhau;
	}

	public HoKhau() {}
	
	public int getID_hokhau() {
		return this.ID_hokhau;
	}

	public void setID_hokhau(int iD_hokhau) {
		this.ID_hokhau = iD_hokhau;
	}

	public int getID_diachi() {
		return this.ID_diachi;
	}

	public void setID_diachi(int iD_diachi) {
		this.ID_diachi = iD_diachi;
	}

	public int getID_nhankhau() {
		return this.ID_nhankhau;
	}

	public void setID_nhankhau(int iD_nhankhau) {
		this.ID_nhankhau = iD_nhankhau;
	}
	
	
	
	
	
}
