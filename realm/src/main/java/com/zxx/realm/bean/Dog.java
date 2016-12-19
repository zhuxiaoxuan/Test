package com.zxx.realm.bean;

import io.realm.RealmObject;
import io.realm.annotations.Required;

/**
 * Created by Administrator on 2016/12/18.
 */
public class Dog extends RealmObject {
    @Required// Name cannot be null
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
