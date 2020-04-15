package com.zzy.crm.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 邹靓仔
 * @date 2020/3/25 -14:41 -zzy_crm
 **/
public class StringUtils {

    public static String getNowTime(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        return df.format(date);
    }
}
