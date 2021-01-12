package ehu.isad.controller.db;

import ehu.isad.model.Checksums;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MainKud {

    private static final MainKud instance = new MainKud();

    public static MainKud getInstance() {
        return instance;
    }

    public boolean datuBaseanDago(String md5hash){

        String query = "select * from checksums where md5='" + md5hash + "'";
        DBKudSQLITE dbKudeatzaile = DBKudSQLITE.getDBKud();
        ResultSet rs = dbKudeatzaile.execSQL(query);
        boolean emaitza = false;
        try {
            if (rs.next()){
                emaitza=true;
            }
        } catch (SQLException throwables) {
        throwables.printStackTrace();
        }
        return emaitza;
    }

    public String bertsioabueltatu(String md5hash){

        String query = "select version from checksums where md5='" + md5hash + "'";
        DBKudSQLITE dbKudeatzaile = DBKudSQLITE.getDBKud();
        ResultSet rs = dbKudeatzaile.execSQL(query);
        String version=null;
        try {
            if (rs.next()) {
                version= rs.getString("version");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return version;
    }

}
