package com.sky.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * @author liweihua
 * @classname MybatisUtils
 * @description TODO
 * @date 2022/8/4 11:13
 */
//sqlSessionFactory-->构建sqlSession
public class MybatisUtils {
    private static SqlSessionFactory sqlSessionFactory;
    static{
        try {
            //获取sqlSessionFactory对象
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
             sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    //既然有了SqlSessionFactory,顾名思义，我们就可以从中获得sqlSession的实例了。
    //sqlSession完全包含了面向数据库执行sql命令的所需方法
    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }
}
