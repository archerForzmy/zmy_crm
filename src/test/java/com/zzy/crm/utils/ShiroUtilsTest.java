package com.zzy.crm.utils;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author 邹靓仔
 * @date 2020/3/24 -17:04 -zzy_crm
 **/
public class ShiroUtilsTest {

    @Test
    public void encryptPassword() {
        System.out.println("密码："+ShiroUtils.encryptPassword("123456","hby815881a11507"));
    }




    @Test
    public void randomSalt() {
        System.out.println("随机盐："+ShiroUtils.randomSalt());

    }
}