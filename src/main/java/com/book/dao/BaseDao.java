package com.book.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Myth on 2017/1/21 0021
 */
public interface BaseDao <T,Id_Type extends Serializable>{
    void save(T t)throws Exception;
    void delete(T t)throws Exception;
    void update(T t)throws Exception;
    List<T> getAll()throws Exception;
    List<T> getAll(String param) throws Exception;
    List<T> getAll(List params) throws Exception;
    T getOne(Id_Type id)throws Exception;
}
