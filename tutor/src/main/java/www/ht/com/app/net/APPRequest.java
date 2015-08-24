/*
 * Copyright (c) 2015 huwentao (vernon.huwt@gmail.com)
 */

package www.ht.com.app.net;

import com.alibaba.fastjson.JSON;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import www.ht.com.app.config.Config;
import www.ht.com.app.data.Login;
import www.ht.com.app.data.Register;
import www.ht.com.app.data.SetNewPassword;
import www.ht.com.app.data.Teacher;
import www.ht.com.app.ui.core.TutorApplication;

/**
 * Created by mokey on 2015/8/18.
 */
public class APPRequest {
    public static TutorApplication tutorApp;
    public static Config.ServerConfig serverConfig = null;

    /**
     * 注册
     *
     * @param mobile
     * @param password
     * @param userName
     * @param vcode
     * @return
     */
    public static Request getRegister(String userType, String mobile, String password, String userName, String vcode) {
        password = MD5(MD5(password));
        String requestUrl = serverConfig.getServerUrl() + "/registration/signup";
        Register register = new Register(userType, mobile, password, userName, vcode);
        RequestBody requestBody = new FormEncodingBuilder()
                .add("data", JSON.toJSONString(register))
                .build();
        return new Request.Builder().url(requestUrl).post(requestBody).build();

    }

    /**
     * 取短信难码
     *
     * @param mobile
     * @return
     */
    public static Request getRegisterCode(String mobile) {
        String requestUrl = serverConfig.getServerUrl() + "/confirmation/vcode/send";
        RequestBody requestBody = new FormEncodingBuilder()
                .add("data", "{\"mobile\":\"" + mobile + "\"}")
                .build();
        return new Request.Builder().url(requestUrl).post(requestBody).build();
    }

    /**
     * 用户登录
     *
     * @param mobile
     * @return
     */
    public static Request login(String mobile,
                                String password,
                                String deviceId) {
        password = MD5(MD5(password));
        Login login = new Login(mobile, password, deviceId);
        String requestUrl = serverConfig.getServerUrl() + "/user/login";
        RequestBody requestBody = new FormEncodingBuilder()
                .add("data", JSON.toJSONString(login))
                .build();
        return new Request.Builder().url(requestUrl).post(requestBody).build();
    }

    /**
     * 修改密码
     *
     * @param mobile
     * @param newPassword
     * @param vcode
     * @return
     */
    public static Request setNewPassword(String mobile,
                                         String newPassword,
                                         String vcode) {
        newPassword = MD5(MD5(newPassword));
        SetNewPassword setNewPassword = new SetNewPassword(mobile, newPassword, vcode);
        String requestUrl = serverConfig.getServerUrl() + "/setting/setNewPassword";
        RequestBody requestBody = new FormEncodingBuilder()
                .add("data", JSON.toJSONString(setNewPassword))
                .build();
        return new Request.Builder().url(requestUrl).post(requestBody).build();
    }

    /**
     * 取短信难码
     *
     * @param mobile
     * @return
     */
    public static Request getNewPasswdCode(String mobile) {
        String requestUrl = serverConfig.getServerUrl() + "/confirmation/vcode/password";
        RequestBody requestBody = new FormEncodingBuilder()
                .add("data", "{\"mobile\":\"" + mobile + "\"}")
                .build();
        return new Request.Builder().url(requestUrl).post(requestBody).build();
    }

    /**
     * 教师信息更新
     *
     * @param token
     * @param theacher
     * @return
     */
    public static Request updateTeacherinfo(String token, Teacher theacher) {
        String requestUrl = serverConfig.getServerUrl() + "/confirmation/vcode/password";
        RequestBody requestBody = new FormEncodingBuilder()
                .add("data", JSON.toJSONString(theacher))
                .build();
        return new Request.Builder()
                .url(requestUrl)
                .header("token", token)
                .post(requestBody).build();
    }

    /**
     * @param hash
     * @return
     */
    public static String hexString(byte[] hash) {
        StringBuilder hex = new StringBuilder(hash.length * 2);
        for (byte b : hash) {
            if ((b & 0xFF) < 0x10) hex.append("0");
            hex.append(Integer.toHexString(b & 0xFF));
        }
        return hex.toString();
    }

    /**
     * @param md5String
     * @return
     */
    public static String MD5(String md5String) {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
            md5.update(md5String.getBytes("utf-8"));
            byte[] hash = md5.digest();//加密
            return hexString(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
