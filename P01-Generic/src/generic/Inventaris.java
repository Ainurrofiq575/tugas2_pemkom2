package generic;

public class Inventaris {

    private String path;
    private String FileName;
    private String fileSize;
    private String extension;
    private int jumlah;
    private String keterangan;

    public Inventaris(String path, String fileName, String fileSize, String extension) {
        this.path = path;
        this.FileName = FileName;
        this.fileSize = fileSize;
        this.extension = extension;
        this.jumlah = 0; // Default jumlah
        this.keterangan = ""; // Default keterangan kosong
    }

    // Getter dan Setter
    public String getPath() {
        return path;
    }

    public String getFileName() {
        return FileName;
    }

    public String getFileSize() {
        return fileSize;
    }

    public String getExtension() {
        return extension;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public void setFileName(String FileName) {
        this.FileName = FileName;
    }

}
