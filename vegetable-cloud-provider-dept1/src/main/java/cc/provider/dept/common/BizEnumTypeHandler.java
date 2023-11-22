package cc.provider.dept.common;

import cc.common.enmus.BaseBizEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author followtry
 * @since 2021/8/9 3:38 下午
 */
public class BizEnumTypeHandler<E extends BaseBizEnum> extends BaseTypeHandler<E> {

    private Class<E> type;

    //初始化时定义枚举和code的映射关系
    private final Map<Integer,E> enumsMap = new HashMap<>();

    public BizEnumTypeHandler(Class<E> type) {
        if (type == null) {
            throw new IllegalArgumentException("Type argument cannot be null");
        }
        this.type = type;

        try {

            for (E enumConstant : type.getEnumConstants()) {
                enumsMap.put(enumConstant.getCode(),enumConstant);
            }

        }catch (NullPointerException e){

            System.out.println();
        }

        if (this.enumsMap.size() == 0) {
            throw new IllegalArgumentException(type.getSimpleName() + " does not represent an enum type.");
        }
    }

    //在请求Sql执行时转换参数
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, E e, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i,e.getCode());
    }

    //处理返回结果
    @Override
    public E getNullableResult(ResultSet resultSet, String columnName) throws SQLException {
        if (resultSet.wasNull()) {
            return null;
        }
        int code = resultSet.getInt(columnName);
        return getEnum(code);
    }

    private E getEnum(Integer code) {
        try {
            return getEnumByValue(code);
        } catch (Exception ex) {
            throw new IllegalArgumentException(
                    "Cannot convert " + code + " to " + type.getSimpleName() + " by ordinal value.", ex);
        }
    }

    protected E getEnumByValue(Integer code) {
        return enumsMap.get(code);
    }

    @Override
    public E getNullableResult(ResultSet resultSet, int columnIndex) throws SQLException {
        if (resultSet.wasNull()) {
            return null;
        }
        int code = resultSet.getInt(columnIndex);
        return getEnum(code);
    }

    @Override
    public E getNullableResult(CallableStatement callableStatement, int columnIndex) throws SQLException {
        if (callableStatement.wasNull()) {
            return null;
        }
        int code = callableStatement.getInt(columnIndex);
        return getEnum(code);
    }
}
