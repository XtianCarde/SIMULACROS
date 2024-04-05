package database;

import java.util.List;

public interface CRUD {
    Object insert(Object obj);
    List<Object> findAll();
    boolean delete(Object obj);
    boolean update(Object obj);
}
