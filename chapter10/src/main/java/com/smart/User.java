package com.smart;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.lang.reflect.Field;

@Entity
@Table(name = "t_uer")
public class User implements Serializable {
    @Id
    @Column(name = "user_name")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "score")
    private int score;

    @Column(name = "last_logon_time")
    private long lastLogonTime = 0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public long getLastLogonTime() {
        return lastLogonTime;
    }

    public void setLastLogonTime(long lastLogonTime) {
        this.lastLogonTime = lastLogonTime;
    }

    @Override
    public String toString() {
        return (new ReflectionToStringBuilder(this) {
            @Override
            protected boolean accept(Field field) {
                return field.getType().isPrimitive() || field.getType() == String.class;
            }
        }).toString();
    }
}
