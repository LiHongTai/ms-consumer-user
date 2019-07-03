package github.roger.mapper;

import github.roger.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select * from user t where t.id = #{id}")
    User findById(Integer id);
}
