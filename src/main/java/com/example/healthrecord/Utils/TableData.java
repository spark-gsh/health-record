package com.example.healthrecord.Utils;



import java.util.List;


public class TableData<E> {
    private int count;
    private int code;
    private List<E> data;


    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<E> getData() {
        return data;
    }

    public void setData(List<E> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "TableData{" +
                "count=" + count +
                ", code=" + code +
                ", data=" + data +
                '}';
    }
}
