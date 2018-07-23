package atm.v2_0.bank.db.driver;

import java.sql.*;
import java.util.Properties;
import java.util.logging.Logger;

public class MyDriverDB implements Driver {
    static {
        System.out.println("Registering...");
        try {
            DriverManager.registerDriver(new MyDriverDB());
        } catch (SQLException e) {
            System.err.println("Do not registering driver DB");
        }
    }
    @Override
    public Connection connect(String url, Properties info) throws SQLException {
        System.out.println("Connect...");
        return new MyConnection();
    }

    @Override
    public boolean acceptsURL(String url) throws SQLException {
        return false;
    }

    @Override
    public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException {
        return new DriverPropertyInfo[0];
    }

    @Override
    public int getMajorVersion() {
        return 0;
    }

    @Override
    public int getMinorVersion() {
        return 0;
    }

    @Override
    public boolean jdbcCompliant() {
        return false;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }
}
