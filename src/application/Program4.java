package application;

import db.DB;
import db.DbIntegrityException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Program4 {
    public static void main(String[] args) {

        /*
         *  Programa para revisar o comando DELETE
         * */

        Connection conn = null;
        PreparedStatement st = null;

        String sql = null;

        sql = "DELETE FROM DEPARTMENT "
                + "WHERE "
                + "ID = ?";

        try {
            conn = DB.getConnection();
            st = conn.prepareStatement(sql);
            st.setInt(1, 2);

            int rowsAffected = st.executeUpdate();

            System.out.println("Done! Rows affected: " + rowsAffected);

        } catch (SQLException e) {
            throw new DbIntegrityException(e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }


    }
}
