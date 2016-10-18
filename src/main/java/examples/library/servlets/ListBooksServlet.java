package examples.library.servlets;

import examples.library.dao.BookDao;
import examples.library.dto.Book;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ListBooksServlet extends HttpServlet {

    @Resource(name="jdbc/library")
    private DataSource ds;

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        //get database connection
        try {
            //get connection
            Connection con = ds.getConnection();
            // create instance of DAO
            BookDao bookDao = new BookDao();
            // get all books
            List<Book> books = bookDao.getAll(con);
            // to request add parameter "books"
            request.setAttribute("books", books);
            // redirect to jsp
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/listbooks.jsp");
            // forward request
            rd.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}