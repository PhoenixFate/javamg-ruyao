/**
 * 
 */
package com.thinkgem.javamg.modules.rfb.entity;

import org.hibernate.validator.constraints.Length;
import com.thinkgem.javamg.common.persistence.DataEntity;

/**
 * 擂台赛用户Entity
 * @author shenming
 * @version 2020-05-04
 */
public class RfbArenaUser extends DataEntity<RfbArenaUser> {
	
	private static final long serialVersionUID = 1L;
	private String aid;		// aid
	private String openid;		// 团队名称
	private String score;		// 团体代号(1~999)
	private String status;		// 0:已参赛 1:未开始
	
	public RfbArenaUser() {
		super();
	}

	public RfbArenaUser(String id){
		super(id);
	}

	@Length(min=1, max=64, message="aid长度必须介于 1 和 64 之间")
	public String getAid() {
		return aid;
	}

	public void setAid(String aid) {
		this.aid = aid;
	}
	
	@Length(min=1, max=64, message="团队名称长度必须介于 1 和 64 之间")
	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}
	
	@Length(min=0, max=10, message="团体代号(1~999)长度必须介于 0 和 10 之间")
	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}
	
	@Length(min=1, max=11, message="0:已参赛 1:未开始长度必须介于 1 和 11 之间")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}