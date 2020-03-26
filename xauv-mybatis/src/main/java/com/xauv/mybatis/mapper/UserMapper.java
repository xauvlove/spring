package com.xauv.mybatis.mapper;

import com.xauv.mybatis.pojo.User;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Select;
import java.util.List;

/**
 * 开启二级缓存
 */
//@CacheNamespace
public interface UserMapper {
	@Select("select * from tb_user")
	List<User> queryAllUser();
}
