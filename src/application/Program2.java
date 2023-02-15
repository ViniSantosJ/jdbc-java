package application;

import db.DB;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) {

        /*
         *  Programa para revisar o comando INSERT
         * */

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = DB.getConnection();

//            st = conn.prepareStatement(  // espera como argumento uma string que é o comando sql
//                    "INSERT INTO seller (name, email, birthdate, basesalary, departmentid)" +
//                            "values (?,?,?,?,?)",//placeholder
//                    Statement.RETURN_GENERATED_KEYS
//            );
//            st.setString(1, "Vinicius Santos"); //1º ? vai receber Vinicius Santos
//            st.setString(2, "vinicius@gmail.com");
//            st.setDate(3, new java.sql.Date(sdf.parse("10/02/1995").getTime()));
//            st.setDouble(4, 2850.00);
//            st.setInt(5, 1);

            st = conn.prepareStatement(
                    "insert into department (name) values ('D1'),('D2')",
                    Statement.RETURN_GENERATED_KEYS
            );

            int rowsAffected = st.executeUpdate(); //operação que ALTERA os dados e retorna quantas linhas foram alteradas

            if (rowsAffected > 0) {
                ResultSet rs = st.getGeneratedKeys();
                while (rs.next()) {
                    int id = rs.getInt(1);
                    System.out.println("Done! Id = " + id);
                }
            } else {
                System.out.println("Now row affected!");
            }


        } catch (SQLException e) {
            e.printStackTrace();
//        } catch (ParseException e) {
//            e.printStackTrace();
        } finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }

    }
}
