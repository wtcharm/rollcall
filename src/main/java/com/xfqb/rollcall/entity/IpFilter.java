package com.xfqb.rollcall.entity;

import java.io.Serializable;
import java.util.Date;

public class IpFilter implements Serializable {
    /**
	 * @author: tao wang
	 * @date:   2019年4月29日 
	 */
	private static final long serialVersionUID = -1322682848884683967L;

	private Long id;

    private String ip;

    private String module;

    private Integer mark;

    private Date createTime;

    private Date updateTime;

    private Integer dr;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module == null ? null : module.trim();
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getDr() {
        return dr;
    }

    public void setDr(Integer dr) {
        this.dr = dr;
    }

	@Override
	public String toString() {
		return "IpFilter [id=" + id + ", ip=" + ip + ", module=" + module + ", mark=" + mark + ", createTime="
				+ createTime + ", updateTime=" + updateTime + ", dr=" + dr + "]";
	}
    
    
}