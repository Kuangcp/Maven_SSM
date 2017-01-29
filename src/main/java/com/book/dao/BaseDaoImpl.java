package com.book.dao;

import org.apache.ibatis.session.SqlSession;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Myth on 2017/1/21 0021
 */
public class BaseDaoImpl <T,Id_Type extends Serializable> extends MybatisSessionFactory implements BaseDao{
    //claz用来记录当前T的.class文件
    private Class<T> claz;
    private String className;

    /*@Autowired
    public void setSessionFactory_1(MybatisSessionFactory sessionFactory) {
        super.MybatisSessionFactory(sessionFactory);
    }*/

    public BaseDaoImpl(){
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        this.claz = (Class<T>) pt.getActualTypeArguments()[0];
        this.className = claz.getSimpleName();

    }

    @Override
    public void save(Object o) throws Exception {
        SqlSession session = getSession();
        session.insert("myth.book.insert_"+className,o);
        session.commit();

    }

    @Override
    public boolean delete(Object o) throws Exception {
        boolean flag = true;
        try{
        SqlSession session = getSession();
        session.delete("myth.book.delete_"+className,o);
        session.commit();
        }catch(Exception e){
            e.printStackTrace();
            flag = false;
            throw e;
        }
        return flag;
    }

    @Override
    public boolean update(Object o) throws Exception {
        boolean flag = true;
        try{
            SqlSession session = getSession();
            session.update("myth.book.update_"+className,o);
            session.commit();
        }catch(Exception e){
            e.printStackTrace();
            flag = false;
            throw e;
        }
        return flag;
    }

    @Override
    public List getAll() throws Exception {
        return getSession().selectList("myth.book.getAll_"+className);
    }

    @Override
    public List getAll(String param) throws Exception {
        Map map = new HashMap();
        map.put("param",param);
        return getSession().selectList("myth.book.getAll_Param_"+className,map);
    }

    @Override
    public List getAll(List params) throws Exception {
        Map map = new HashMap();
        map.put("param_list",params);
        return getSession().selectList("myth.book.getAll_Param_"+className,map);
    }

    /*
        要特别注意id的类型，是和具体继承的dao的类型要一致，Long就要加上L后缀
     */
    @Override
    public Object getOne(Serializable id) throws Exception {
        return getSession().selectOne("myth.book.getOne_"+className,id);
    }
}
