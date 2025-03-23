package com.chen.common;
import lombok.Data;

@Data
public class ReturnMsg<T> {
    private Integer code;
    private String message;
    private T data;

    public ReturnMsg code(int code){
        this.code=code;
        return this;
    }
    public ReturnMsg message(String msg)
    {
        this.message=msg;
        return this;
    }
    public ReturnMsg data(T o)
    {
        this.data=o;
        return this;
    }

    /* public String toJSONString()
    {
        return JSONObject.toJSONString(this);
    }
*/
}
