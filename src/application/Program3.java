package application;

import db.DB;

import java.sql.*;
import java.text.SimpleDateFormat;

public class Program3 {
    public static void main(String[] args) {

        /*
         *  Programa para revisar o comando UPDATE
         * */

        Connection conn = null;
        PreparedStatement st = null;

        String sql = null;

        sql = "update seller "
                + "set baseSalary = baseSalary + ? "
                + "where "
                + " (DepartmentId = ?) ";

        try {
            conn = DB.getConnection();
            st = conn.prepareStatement(sql);
            st.setDouble(1, 200.00);
            st.setInt(2, 2);

            int rowsAffected = st.executeUpdate();

            System.out.println("Done! Rows affected: " + rowsAffected);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }


    }
}
