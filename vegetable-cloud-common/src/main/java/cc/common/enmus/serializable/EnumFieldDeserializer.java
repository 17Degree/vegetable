package cc.common.enmus.serializable;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;

import java.lang.reflect.Type;

public class EnumFieldDeserializer implements ObjectDeserializer {




    @Override
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object o) {

        Class objectClass = this.getObjectClass();

        ParserConfig config = defaultJSONParser.getConfig();
        System.out.println();
        return null;
    }
}
