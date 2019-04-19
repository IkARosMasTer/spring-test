package org.choviwu.movie.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Customer {
    private Integer id;

    private String name;

    private String school;

    private String number;

    private String password;

    private String course;

    private Date addtime;

    private String score;

    private String kaoshi_date;

    public String getKaoshi_date() {
        return kaoshi_date;
    }

    public void setKaoshi_date(String kaoshi_date) {
        this.kaoshi_date = kaoshi_date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getString(){
        String  score = this.score;
        String []arr = score.split("/");
        String decrip = "";
        if(arr.length==2){
            decrip = "第一门成绩为:"+arr[0]+"第二门成绩为:"+arr[1];
        }else{
            if(!arr[0].contains("暂未")) {
                decrip = "考试成绩为："+score;
            }else
                decrip = arr[0];
        }
        return decrip;
    }
    @Override
    public String toString() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String  score = getScore();
        String []arr = score.split("/");
        String decrip = "";
        if(arr.length==2){
            decrip = "第一门成绩为： "+arr[0]+"\n"+"第二门成绩为："+arr[1];
        }else{
            if(!arr[0].contains("暂未")) {
                decrip = "考试成绩为："+score;
            }else
                decrip = arr[0];
        }
        return
                "学校：" + school  +"\n姓名："+name+
                        ",\n学号/手机号：" + number
                        + "\n课程：" + course +
                        "门.\n "+decrip+"\n 考试时间为： "+kaoshi_date;
    }
}