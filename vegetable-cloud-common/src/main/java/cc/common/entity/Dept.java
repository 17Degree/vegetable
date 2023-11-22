package cc.common.entity;

import cc.common.enmus.DeptState;
import cc.common.enmus.DeptType;
import cc.common.enmus.serializable.EnumFieldDeserializer;
import cc.common.enmus.serializable.EnumFieldSerializer;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class Dept implements Serializable {

    private Integer deptNo;
    private String deptName;
    private String dbSource;
    private Date createTime1;
    private Date createTime2;


    //@JSONField(serializeUsing = EnumFieldSerializer.class, deserializeUsing = EnumFieldDeserializer.class)
    private DeptType type;

    //@JSONField(serializeUsing = EnumFieldSerializer.class, deserializeUsing = EnumFieldDeserializer.class)
    private DeptState state;


}
