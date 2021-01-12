package ehu.isad.model;

public class Checksums {

    private Integer idCMS;
    private String version;
    private String md5;
    private String path;

    public Checksums(Integer idCMS, String version, String md5, String path) {
        this.idCMS = idCMS;
        this.version = version;
        this.md5 = md5;
        this.path = path;
    }

    public Integer getIdCMS() {
        return idCMS;
    }

    public String getVersion() {
        return version;
    }

    public String getMd5() {
        return md5;
    }

    public String getPath() {
        return path;
    }
}