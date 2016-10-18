package examples.library;

import examples.library.dao.BookDao;
import examples.library.dto.Book;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class BookDaoTest {
    @Test
    public void test() throws Exception {

        // JDBC result set mock
        ResultSet resultSet = Mockito.mock(ResultSet.class);

        // JDBC result set set getNext() method mock
        Mockito.when(resultSet.next()).thenReturn(true, true, false);

        // JDBC result set getLong(1) method mock
        Mockito.when(resultSet.getLong(1)).thenReturn(1L, 2L);

        // JDBC result set getString(2) method mock
        Mockito.when(resultSet.getString(2)).thenReturn("Leo Tolstoy", "Dostoevsky");

        // JDBC result set getString(3) method mock
        Mockito.when(resultSet.getString(3)).thenReturn("Voskresenye", "Bratya Karamazovy");

        // JDBC statement mock
        Statement statement = Mockito.mock(Statement.class);

        // link statement and result set
        Mockito.when(statement.executeQuery("SELECT * FROM book")).thenReturn(resultSet);

        //JDBC connection mock
        Connection jdbcConnection = Mockito.mock(Connection.class);

        // link connection and statement
        Mockito.when(jdbcConnection.createStatement()).thenReturn(statement);

        // mock for book DAO
        BookDao bookDao = PowerMockito.spy(new BookDao());

        // mock for private method of BookDao instance
        PowerMockito.doReturn(jdbcConnection).when(bookDao, "getConnection");

        // get all books
        List<Book> books = bookDao.getAll();

        // out all books
        for(Book b: books){
            System.out.println(b.toString());
        }
    }
}