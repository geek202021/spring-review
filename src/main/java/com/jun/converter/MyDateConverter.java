package com.jun.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 自定义类型转换器
 * @author HuangJun7
 * @date 2021-10-26 20:20
 */
public class MyDateConverter implements Converter<String, Date> {
    private String pattern;

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    /**
     * convert方法作用: String ---> Date
     *      SimpleDateFormat sdf = new SimpleDateFormat();
     *      sdf.parse(String) ---> Date
     *
     *      param:source代表的是配置文件中, 日期字符串 <value>2021-10-26</value>
     *      return : 当把转换好的 Date 作为 convert 方法的返回值后,
     *              Spring ⾃动的为birthday属性进行注入（赋值）
     */
    @Override
    public Date convert(String source) {
        Date date = null;
        try {
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);//通过依赖注入的方式，由配置文件来完成赋值。
            date = sdf.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
