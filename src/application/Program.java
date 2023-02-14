package application;

import db.DB;
import db.DbException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program {
    public static void main(String[] args) {

        Connection conn = null; //conectar ao banco
        Statement st = null; //preparar a consulta sql
        ResultSet rs = null; //guardar o resultado da consulta

        try {
            conn = DB.getConnection(); //conecta no banco de dados

            st = conn.createStatement(); //instanciando um objeto do tipo statment

            rs = st.executeQuery("SELECT * FROM DEPARTMENT"); //"rs" vai receber o resultado da consulta feita pelo "st"

            while (rs.next()) {
                System.out.println(rs.getInt("Id") + ", " + rs.getString("Name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
            DB.closeConnection();
        }

    }
}
