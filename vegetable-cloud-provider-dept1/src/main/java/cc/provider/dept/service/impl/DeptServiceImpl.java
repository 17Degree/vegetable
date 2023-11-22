package cc.provider.dept.service.impl;

import cc.common.entity.Dept;
import cc.provider.dept.mapper.DeptMapper;
import cc.provider.dept.service.DeptService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("deptService")
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public Dept get(Integer deptNo) {
        return deptMapper.selectByPrimaryKey(deptNo);
    }
    @Override
    public List<Dept> selectAll() {



        return deptMapper.GetAll();
    }
}