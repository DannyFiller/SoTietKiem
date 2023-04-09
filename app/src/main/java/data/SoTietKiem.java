package data;

public class SoTietKiem {
    int id;
    int idUser;
    String tenSo;
    int tienTietKiem;

    public SoTietKiem(int idUser, String tenSo, int tienTietKiem) {
        this.idUser = idUser;
        this.tenSo = tenSo;
        this.tienTietKiem = tienTietKiem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getTenSo() {
        return tenSo;
    }

    public void setTenSo(String tenSo) {
        this.tenSo = tenSo;
    }

    public int getTienTietKiem() {
        return tienTietKiem;
    }

    public void setTienTietKiem(int tienTietKiem) {
        this.tienTietKiem = tienTietKiem;
    }
}
