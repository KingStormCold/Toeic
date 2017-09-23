package vn.myclass.core.data.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by TuanKul on 9/13/2017.
 */
//Serializable đọc ghi dữ liệu bộ nhớ
    //ID dựa vào id để lấy dữ liệu lên
    //T tên class
public interface GenericDao<ID extends Serializable, T> {
    List<T> findAll();
    T update(T entity);
    void save(T entity);
    T findById(ID id);
    Object[] finByProperty(String property, Object value, String sortExpression, String sortDirection, Integer offset, Integer limit);
    Integer delete(List<ID> ids);
}
