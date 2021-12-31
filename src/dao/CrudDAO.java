package dao;

import com.sun.xml.bind.v2.model.core.ID;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface CrudDAO<T,ID> extends SuperDAO {

        void add(T t)throws SQLException, ClassNotFoundException;
        boolean delete(ID id)throws SQLException, ClassNotFoundException;
        void update(T t)throws SQLException, ClassNotFoundException;
        T search(ID id)throws SQLException, ClassNotFoundException;
        List<T> getAll()throws SQLException, ClassNotFoundException;

}
