package cc.provider.dept.mapper;

import cc.common.entity.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DeptMapper {

    //根据主键获取数据
    Dept selectByPrimaryKey(Integer deptNo);
    //获取表中的全部数据
    List<Dept> GetAll();
}
