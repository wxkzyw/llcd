package com.justech.luolesite.entity;


/**
 * @Author: WangXiaoKun
 * @Date: 2019/4/18 10:53
 * 返回的JSON实体
 */
public class jsonEntity {

    private int state; //10000:失败 10001:成功
    private String msg;
    private Object data;

    public void failure(String msg){
        this.msg=msg;
        this.state=10000;
    }

    public void success(String msg){
        this.msg=msg;
        this.state=10001;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
