package com.test;


import cc.common.enmus.DeptType;
import cc.common.entity.Dept;
import cc.common.entity.Meeting;
import cc.provider.dept.CloudProviderDeptStart1;
import cc.provider.dept.mapper.DeptMapper;
import cc.provider.dept.service.DeptService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson2.util.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CloudProviderDeptStart1.class)
public class TestMyBatis {

    @Autowired
    private DeptService deptService;

    @Autowired
    private DeptMapper deptMapper;

    @Test
    public void testMyBatisEnum() {

        /*SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        List<Dept> depts = deptService.selectAll();

        for (Dept dept : depts) {

            if(dept.getCreateTime1() != null){
                System.out.println("time1" + simpleDateFormat.format(dept.getCreateTime1()));
            }

            if(dept.getCreateTime2() != null){
                System.out.println("time2" + simpleDateFormat.format(dept.getCreateTime2()));
            }

        }

        String json = JSONObject.toJSONString(depts);
        System.out.println(json);


        JSONArray objects = JSONArray.parseArray(json);
        List<Dept> depts1 = objects.toJavaList(Dept.class);

        System.out.println(depts1);*/


        List<Meeting> meeting = deptMapper.getMeeting();

        Meeting meeting1 = meeting.get(0);

        System.out.println();

    }
}
