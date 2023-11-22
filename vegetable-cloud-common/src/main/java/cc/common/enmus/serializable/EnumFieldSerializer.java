package cc.common.enmus.serializable;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import lombok.SneakyThrows;

import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

public class EnumFieldSerializer implements ObjectSerializer {


    @SneakyThrows
    @Override
    public void write(JSONSerializer jsonSerializer, Object o, Object o1, Type type, int i) throws IOException {


        Class<?> aClass = Class.forName(type.getTypeName());

        Method getCode = aClass.getDeclaredMethod("getCode");
        Integer code = (Integer) getCode.invoke(o);
        jsonSerializer.writeInt(code);
    }
}
