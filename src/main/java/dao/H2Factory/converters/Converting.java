package dao.H2Factory.converters;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface Converting<T> {

    public List<T> convert(ResultSet rs) throws SQLException;
}
