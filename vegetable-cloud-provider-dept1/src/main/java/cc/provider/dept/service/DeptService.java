package cc.provider.dept.service;

import cc.common.entity.Dept;

import java.util.List;

public interface DeptService {
    Dept get(Integer deptNo);
    List<Dept> selectAll();

}
