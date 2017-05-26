package com.dl.mvpapplication.model;

/**
 *
 * Created by dl on 2017/4/14.
 */
public class UserModel {

    private int iscomplete;
    private String phone;
    private int kind;
    private String sex;
    private String nickname;
    private String avatar;
    private String userid;
    private int age;
    private int ifup;
    private int bean;
    private String ifac;
    private String userrole;
    private String status;
    private int avatartype;

    public int getAvatartype() {
        return avatartype;
    }

    public void setAvatartype(int avatartype) {
        this.avatartype = avatartype;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIfac() {
        return ifac;
    }

    public void setIfac(String ifac) {
        this.ifac = ifac;
    }

    public int getBean() {
        return bean;
    }

    public void setBean(int bean) {
        this.bean = bean;
    }

    public int getIfup() {
        return ifup;
    }

    public void setIfup(int ifup) {
        this.ifup = ifup;
    }

    public void setIscomplete(int iscomplete) {
        this.iscomplete = iscomplete;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setKind(int kind) {
        this.kind = kind;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getIscomplete() {
        return iscomplete;
    }

    public String getPhone() {
        return phone;
    }

    public int getKind() {
        return kind;
    }

    public String getSex() {
        return sex;
    }

    public String getNickname() {
        return nickname;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getUserid() {
        return userid;
    }

    public int getAge() {
        return age;
    }

    public String getUserrole() {
        return userrole;
    }

    public void setUserrole(String userrole) {
        this.userrole = userrole;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "iscomplete=" + iscomplete +
                ", phone='" + phone + '\'' +
                ", kind=" + kind +
                ", sex='" + sex + '\'' +
                ", nickname='" + nickname + '\'' +
                ", avatar='" + avatar + '\'' +
                ", userid='" + userid + '\'' +
                ", age=" + age +
                ", ifup=" + ifup +
                ", bean=" + bean +
                ", ifac='" + ifac + '\'' +
                ", userrole='" + userrole + '\'' +
                ", status='" + status + '\'' +
                ", avatartype=" + avatartype +
                '}';
    }
}
