package com.cinbo.mapper;



import com.cinbo.dto.UsersDTO;

import java.util.Map;

public class MyTestDBDaoProvider {

    public String selectByPK(long pk){
        return "select * from users1 where id="+pk;
    }
    public String selectById(Map<String, Object> para){

        return "select * from users1 where id="+para.get("id");
    }


    public String selectByIdForUpdate(Map<String, Object> para){

        return "select * from users1 where id="+para.get("id")+" for update";
    }

    public String insert(UsersDTO usersDTO){
        String sql="";

        sql = "insert into users1(username,password,logindate,myvalue) values(";
        sql += "#{username},#{password},#{logindate},#{myvalue})";

        return sql;
    }
}
