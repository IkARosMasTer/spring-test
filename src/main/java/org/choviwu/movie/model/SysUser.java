package org.choviwu.movie.model;

import java.util.Date;

public class SysUser {
    private Integer id;

    private String sysName;

    private String sysPwd;

    private Date addtime;

    private String addip;

    private String salt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSysName() {
        return sysName;
    }

    public void setSysName(String sysName) {
        this.sysName = sysName;
    }

    public String getSysPwd() {
        return sysPwd;
    }

    public void setSysPwd(String sysPwd) {
        this.sysPwd = sysPwd;
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public String getAddip() {
        return addip;
    }

    public void setAddip(String addip) {
        this.addip = addip;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}