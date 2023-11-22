package cc.common.enmus;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum DeptState implements BaseBizEnum{

    state_1( 101, "开启"),
    state_2(102, "禁用"),
    state_3(103, "冻结"),

    ;
    Integer val;
    String explain;


    @Override
    public Integer getCode() {
        return this.val;
    }
}
