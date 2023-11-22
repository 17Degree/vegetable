package cc.common.enmus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.val;


@Getter
@AllArgsConstructor
public enum DeptType implements BaseBizEnum{

    type_1(1, "类型1"),
    type_2(2, "类型2"),
    type_3(3, "类型3"),
    type_4(4, "类型4"),
    type_5(5, "类型5"),

    ;
    Integer val;
    String explain;


    @Override
    public Integer getCode() {
        return this.val;
    }
}
