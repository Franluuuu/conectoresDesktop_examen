/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.eldelbit.conectoresdesktop.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author virtualbox
 */
public class DB {

    // BasicDataSource
    final private static BasicDataSource dataSource = new BasicDataSource();

    // PoolingDataSource
    // private static DataSource dataSource = null;
    // Init
    static {

        String protocol = "jdbc:mysql://";
        String hosts = "127.0.0.1";
        String port = "3306";
        String database = "restful";

        String url = protocol + hosts + ":" + port + "/" + database;

        String username = "acceso_a_datos";
        String password = "Changeme_23";

        int minIdle = 3;
        int maxIdle = 6;
        int maxTotal = 10;

        // BasicDataSource
        dataSource.setUrl(url + "?allowMultiQueries=true&useSSL=false&zeroDateTimeBehavior=convertToNull");
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setInitialSize(minIdle);
        dataSource.setMinIdle(minIdle);
        dataSource.setMaxIdle(maxIdle);
        dataSource.setMaxTotal(maxTotal);

        // PoolingDataSource
        /*
        Properties properties = new Properties();
        properties.setProperty("user", username);
        properties.setProperty("password", password);

        properties.setProperty("useSSL", "false");

        ConnectionFactory connectionFactory = new DriverManagerConnectionFactory(url, properties);

        PoolableConnectionFactory poolableConnectionFactory = new PoolableConnectionFactory(connectionFactory, null);

        GenericObjectPoolConfig<PoolableConnection> config = new GenericObjectPoolConfig<>();
        config.setMinIdle(minIdle);
        config.setMaxIdle(maxIdle);
        config.setMaxTotal(maxTotal);
                
        ObjectPool<PoolableConnection> connectionPool = new GenericObjectPool<>(poolableConnectionFactory, config);
        poolableConnectionFactory.setPool(connectionPool);

        dataSource = new PoolingDataSource<>(connectionPool);
         */
    }

    public static Connection getConnection() throws SQLException {

        return dataSource.getConnection();

    }

    public static void closeConnection(Connection conn) {

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException sqlEx) {
            }
        }

    }

    public static void closeStatement(Statement stmt) {

        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException sqlEx) {
            }
        }

    }

    public static void closeResultSet(ResultSet rs) {

        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException sqlEx) {
            }
        }

    }

    public static void rollback(Connection conn) {

        if (conn != null) {
            try {
                conn.rollback();
            } catch (SQLException sqlEx) {
            }
        }

    }

    public static Integer getInt(ResultSet rs, String field) throws SQLException {

        Integer value = rs.getInt(field);
        if (rs.wasNull()) {
            value = null;
        }
        return value;

    }
    
    public static Long getLong(ResultSet rs, String field) throws SQLException {

        Long value = rs.getLong(field);
        if (rs.wasNull()) {
            value = null;
        }
        return value;

    }
}