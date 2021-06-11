package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.*;

public class DBConnect {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/bd";
    static final String USER = "root";
    static final String PASS = "root1";
    public static final String UUID ="1";
    public static final String USERNAME="username";
    public static final String PASSWORD="password";
    public static final String URLSITE="url";
    public static final String SITESNAME="sitesName";
    public static final String CATEGORY="category";
    public static final String COMMENTS="comments";
    public static final String DATE="date";

    public static Connection dbConnection() {
        Connection conn = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void updateDb(String sqlStmt) throws SQLException {
        Connection dbConnection = null;
        Statement statement = null;
        try {
            dbConnection=dbConnection();
            statement = dbConnection.createStatement();
            statement.executeUpdate(sqlStmt);
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
    }

    public static ObservableList<Story> getDataFromDb(String query) throws SQLException {
        ObservableList<Story> users = FXCollections.observableArrayList();
        Connection dbConnection = null;
        Statement statement = null;
        try {
            dbConnection = dbConnection();
            Statement statement1 = dbConnection.createStatement();
            ResultSet rs = statement1.executeQuery(query);
            while (rs.next()) {
                Story user = new Story("1","1","1","1","1","1","1");
                user.setUsername(rs.getString(USERNAME));
                user.setPassword(rs.getString(PASSWORD));
                user.setSiteURL(rs.getString(URLSITE));
                user.setSitename(rs.getString(SITESNAME));
                user.setComment(rs.getString(COMMENTS));
                user.setCategory(rs.getString(CATEGORY));
                user.setDate(rs.getString(DATE));
                users.add(user);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return users;
    }
    public static void createDb() {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = dbConnection();
            stmt = conn.createStatement();
            String sql = "CREATE DATABASE bd2";
            stmt.executeUpdate(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void createTable() {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = dbConnection();
            stmt = conn.createStatement();
            String sql = "CREATE TABLE `bd2` (`username` VARCHAR(45) NULL,`password` VARCHAR(45) NULL,`sitesName` VARCHAR(45) NULL,`category` VARCHAR(45) NULL,`comments` VARCHAR(45) NULL,`date` VARCHAR(45) NULL,`url` VARCHAR(45) NULL)";
            stmt.executeUpdate(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
