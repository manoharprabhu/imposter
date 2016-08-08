/*
 * The MIT License
 *
 * Copyright 2016 mprabhu.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.manoharprabhu.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mprabhu
 */
public class MySQLOperations implements DatabaseOperations {

    private int type = 0;
    private String hostname;
    private String username;
    private String password;
    private int port;
    private String database = "";

    public MySQLOperations(String hostname, String username, String password, int port) {
        this.hostname = hostname;
        this.username = username;
        this.password = password;
        this.port = port;
    }

    @Override
    public boolean testConnection() {
        if (!this.loadDatabaseDriver()) {
            return false;
        }
        Connection connection = this.getConnection();
        if (connection == null) {
            return false;
        }
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(MySQLOperations.class.getName()).log(Level.SEVERE, "Error while closing connection", ex);
        }
        Logger.getLogger(MySQLOperations.class.getName()).log(Level.INFO, "Connected successfully");
        return true;
    }

    @Override
    public List<String> getDatabaseList() {
        List<String> result = new ArrayList<String>();
        Connection connection = null;
        try {
            connection = this.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SHOW DATABASES;");
            while (resultSet.next()) {
                result.add(resultSet.getString(1));
            }
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }

    private boolean loadDatabaseDriver() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MySQLOperations.class.getName()).log(Level.SEVERE, "Unable to load the DB driver", ex);
            return false;
        }
        return true;
    }

    private Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://" + hostname + ":" + port + "/" + database, username, password);
        } catch (SQLException ex) {
            Logger.getLogger(MySQLOperations.class.getName()).log(Level.SEVERE, "Unable to connect using the given credentials", ex);
        }
        return connection;
    }

    /**
     * @return the database
     */
    public String getDatabase() {
        return database;
    }

    /**
     * @param database the database to set
     */
    public void setDatabase(String database) {
        this.database = database;
    }

    @Override
    public void setDatabaseName(String database) {
        this.database = database;
    }

}
