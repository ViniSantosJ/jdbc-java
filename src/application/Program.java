package application;

import db.DB;
import db.DbException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        /*
        * Programa para revisar o comando SELECT
        * */

        Scanner sc = new Scanner(System.in);
        Connection conn = null; //conectar ao banco
        Statement st = null; //preparar a consulta sql
        ResultSet rs = null; //guardar o resultado da consulta

        try {
            conn = DB.getConnection(); //conecta no banco de dados

            st = conn.createStatement(); //instanciando um objeto do tipo statment

            rs = st.executeQuery("SELECT * FROM DEPARTMENT");

//            System.out.println("Digite o nome de um novo departamento: ");
//            String newDepartament = sc.nextLine();

//            rs = st.executeQuery("call department_inserir('"+ newDepartament + "')"); //st.executeQuery irá executar a procedure, passando o parametro que ela pede.

            // imprimindo o resultado do select
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

        sc.close();
    }
}
