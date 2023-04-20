package data;

public class SoTietKiem {
    int id;
    int idUser;
    String tenSo;
    int tienTietKiem;
    String date;
    String daoHan;


    public SoTietKiem(int id, int idUser, String tenSo, int tienTietKiem, String date, String daoHan) {
        this.id = id;
        this.idUser = idUser;
        this.tenSo = tenSo;
        this.tienTietKiem = tienTietKiem;
        this.date = date;
        this.daoHan = daoHan;
    }

    public SoTietKiem(int id, String tenSo, String daoHan,String date ,int tienTietKiem) {
        this.id = id;
        this.tenSo = tenSo;
        this.tienTietKiem = tienTietKiem;
        this.daoHan = daoHan;
        this.date = date;
    }

    public SoTietKiem(int id, int idUser, String tenSo, int tienTietKiem, String date) {
        this.id = id;
        this.idUser = idUser;
        this.tenSo = tenSo;
        this.tienTietKiem = tienTietKiem;
        this.date = date;
    }

    public SoTietKiem(int id, int idUser, String tenSo, int tienTietKiem) {
        this.id=id;
        this.idUser = idUser;
        this.tenSo = tenSo;
        this.tienTietKiem = tienTietKiem;
    }

//    public SoTietKiem(int id, String tenSo, int tienTietKiem,String date,String daoHan) {
//        this.id=id;
//        this.tenSo = tenSo;
//        this.tienTietKiem = tienTietKiem;
//        this.date = date;
//        this.daoHan=daoHan;
//    }

    public SoTietKiem(int idUser, String tenSo, int tienTietKiem,String date,String daohan) {
        this.id=id;
        this.idUser = idUser;
        this.tenSo = tenSo;
        this.tienTietKiem = tienTietKiem;
        this.date = date;
        this.daoHan =daohan;
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

    public String getDate() {return date;}

    public void setDate(String date) {this.date = date;}

    public String getDaoHan() {
        return daoHan;
    }

    public void setDaoHan(String daoHan) {
        this.daoHan = daoHan;
    }

}
