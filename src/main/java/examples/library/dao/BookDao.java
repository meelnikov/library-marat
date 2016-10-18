package examples.library.dao;

import examples.library.dto.Book;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookDao {

    public List<Book> getAll() throws SQLException {

        // init list
        List<Book> books = new ArrayList<>();

        // create connection, statement, result set vars
        Connection con = null; Statement st = null; ResultSet rs = null;
        try {
            // create connection and get statement
            con = getConnection(); st = con.createStatement();
            // execute query
            rs = st.executeQuery("SELECT * FROM book");
            // fill list
            while(rs.next()){
                // read positions of row
                long id = rs.getLong(1); String author = rs.getString(2); String title = rs.getString(3);
                // init new book and add to list
                books.add(new Book(id, author, title));
            }
        } catch(SQLException e){
            // close result set, statement and connection
            if(rs != null) try {
                rs.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            if(st != null) try {
                st.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            if(con != null) try {
                con.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            // throw exception for caller
            throw e;
        }
        return books;
    }

    public List<Book> getAll(Connection con) throws SQLException {

        // init list
        List<Book> books = new ArrayList<>();

        // create connection, statement, result set vars
        Statement st = null; ResultSet rs = null;
        try {
            // create connection and get statement
            st = con.createStatement();
            // execute query
            rs = st.executeQuery("SELECT * FROM book");
            // fill list
            while(rs.next()){
                // read positions of row
                long id = rs.getLong(1); String author = rs.getString(2); String title = rs.getString(3);
                // init new book and add to list
                books.add(new Book(id, author, title));
            }
        } catch(SQLException e){
            // close result set, statement and connection
            if(rs != null) try {
                rs.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            if(st != null) try {
                st.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            if(con != null) try {
                con.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            // throw exception for caller
            throw e;
        }
        return books;
    }

    public Connection getConnection() throws SQLException {
        return null;
    }
}