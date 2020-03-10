package com.briup.cms.utils;

import java.io.Serializable;
import java.util.Date;

public class Message<T> implements Serializable {
    private Integer status;
    private String code;
    private String message;
    private Long timestamp;
    private T data;

    /*
    *默认成功响应,并携带数据
     */
    private Message(T data){
        this.status = 200;
        this.code = "ok";
        this.message = "成功";
        this.data = data;
        this.timestamp = new Date().getTime();
    }
    /*
        默认成功响应,并携带数据
     */
    private Message(String message,T data){
        this.status = 200;
        this.code = "ok";
        this.message = message;
        this.data = data;
        this.timestamp = new Date().getTime();
    }
    /*
        默认成功.不携带数据
     */
    private Message(){
        this(null);
    }
    /*
        自定义响应,不携带数据
     */
    private Message(Integer status,String code,String message){
        this.status = status;
        this.code = code;
        this.message = message;
        this.timestamp = new Date().getTime();
    }
    /*
        自定义响应,携带数据
     */
    private Message(Integer status,String code,String message,T data){
        this.status = status;
        this.code = code;
        this.message = message;
        this.data = data;
        this.timestamp = new Date().getTime();
    }

    /*
        200成功,带数据的响应返回
     */
    public static <T> Message<T> success(T data){
        return new Message<>(data);
    }
    /*
        自定义返回
     */
    public static <T> Message<T> success(Integer status,String code,String message){
        return new Message<>(status,code,message);
    }
    /*
        200成功,不带数据的响应返回
     */

    public static  Message<String> success(){
        return new Message<>();
    }
    /*

     */
    public static Message<String > error(String message){
        return new Message<>(500,"ok",message);
    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
