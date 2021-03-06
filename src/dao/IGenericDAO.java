package dao;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;

public interface IGenericDAO<T> {

    T selectById(int id);

    List<T> selectAll();
    
    List<T> selectWhere(Criterion ...criterions );
    
    List<T> selectAllOrderBy(Order order);
    
    List<T> selectOrderByWhere(Order order, Criterion ...criterions );

    T create(T entity);
    
    T update(T entity);
    
    void delete(T entity, Long id);
}
