package id.ac.poliban.mi.listmakanan;

public class Makanan {
    private String gambar;
    private String makananName;
    private String makananDesc;

    public Makanan(String gambar, String makananName, String makananDesc) {
        this.gambar = gambar;
        this.makananName = makananName;
        this.makananDesc = makananDesc;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getMakananName() {
        return makananName;
    }

    public void setMakananName(String makananName) {
        this.makananName = makananName;
    }

    public String getMakananDesc() {
        return makananDesc;
    }

    public void setMakananDesc(String makananDesc) {
        this.makananDesc = makananDesc;
    }

    @Override
    public String toString(){
        return String.format("%30s\n\n%s", getMakananName(), getMakananDesc());
    }
}
