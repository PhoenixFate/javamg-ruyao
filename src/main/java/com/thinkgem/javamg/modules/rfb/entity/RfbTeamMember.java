/**
 * 
 */
package com.thinkgem.javamg.modules.rfb.entity;

import org.hibernate.validator.constraints.Length(min=1, max=64, message="团体代号;
import org.hibernate.validator.constraints.Length;

import com.thinkgem.javamg.common.persistence.DataEntity;

/**
 * 团队成员Entity
 * @author shenming
 * @version 2020-05-04
 */
public class RfbTeamMember extends DataEntity<RfbTeamMember> {
	
	private static final long serialVersionUID = 1L;
	private String teamid;		// 团体代号(1~999)
	private String openid;		// openid
	private String role;		// role
	private String status;		// status
	
	public RfbTeamMember() {
		super();
	}

	public RfbTeamMember(String id){
		super(id);
	}

	@Length(min=1, max=64, message="团体代号(1~999)长度必须介于 1 和 64 之间")
	public String getTeamid() {
		return teamid;
	}

	public void setTeamid(String teamid) {
		this.teamid = teamid;
	}
	
	@Length(min=1, max=64, message="openid长度必须介于 1 和 64 之间")
	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}
	
	@Length(min=0, max=11, message="role长度必须介于 0 和 11 之间")
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	@Length(min=1, max=11, message="status长度必须介于 1 和 11 之间")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}