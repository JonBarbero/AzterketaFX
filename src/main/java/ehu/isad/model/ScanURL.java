package ehu.isad.model;

public class ScanURL {
    private String url;
    private String md5;
    private String version;


    public ScanURL(String url, String md5, String version) {
        this.url = url;
        this.md5 = md5;
        this.version = version;
    }

    public String getUrl() {
        return url;
    }

    public String getMd5() {
        return md5;
    }

    public String getVersion() {
        return version;
    }
}
