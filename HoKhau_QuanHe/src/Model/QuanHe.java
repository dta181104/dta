package Model;

public class QuanHe {
	private int ID_nhankhau;
	private int ID_hokhau;
	private String quan_he;
	private boolean tam_tru;
	private boolean tam_vang;
	
	public QuanHe(int iD_nhankhau, int iD_hokhau, String quan_he, boolean tam_tru, boolean tam_vang) {
		this.ID_nhankhau = iD_nhankhau;
		this.ID_hokhau = iD_hokhau;
		this.quan_he = quan_he;
		this.tam_tru = tam_tru;
		this.tam_vang = tam_vang;
	}
	
	public QuanHe() {}
	
	public int getID_nhankhau() {
		return this.ID_nhankhau;
	}
	
	public void setID_nhankhau(int iD_nhankhau) {
		this.ID_nhankhau = iD_nhankhau;
	}
	
	public int getID_hokhau() {
		return this.ID_hokhau;
	}
	
	public void setID_hokhau(int iD_hokhau) {
		this.ID_hokhau = iD_hokhau;
	}
	
	public String getQuan_he() {
		return this.quan_he;
	}
	
	public void setQuan_he(String quan_he) {
		this.quan_he = quan_he;
	}
	
	public boolean isTam_tru() {
		return this.tam_tru;
	}
	
	public void setTam_tru(boolean tam_tru) {
		this.tam_tru = tam_tru;
	}
	
	public boolean isTam_vang() {
		return this.tam_vang;
	}
	
	public void setTam_vang(boolean tam_vang) {
		this.tam_vang = tam_vang;
	}
}
