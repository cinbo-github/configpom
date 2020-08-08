package com.cinbo.mapper;


import com.cinbo.dto.UsersDTO;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.SelectProvider;

public interface MyTestDBDao {

    @SelectProvider(type = MyTestDBDaoProvider.class,method = "selectByPK")
    @ResultType(UsersDTO.class)
    public UsersDTO selectByPk(long pk);

    @SelectProvider(type = MyTestDBDaoProvider.class,method = "selectById")
    @ResultType(UsersDTO.class)
    public UsersDTO selectById(@Param("id") long id);

    @SelectProvider(type = MyTestDBDaoProvider.class,method = "selectByIdForUpdate")
    @ResultType(UsersDTO.class)
    public UsersDTO selectByIdForUpdate(@Param("id") long id);

    @InsertProvider(type = MyTestDBDaoProvider.class,method = "insert")
    public int insert(UsersDTO usersDTO);
}
