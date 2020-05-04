/**
 * 
 */
package com.thinkgem.javamg.modules.rfb.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.javamg.common.persistence.DataEntity;

/**
 * 团队挑战Entity
 * @author shenming
 * @version 2020-05-04
 */
public class RfbTeamChallenge extends DataEntity<RfbTeamChallenge> {
	
	private static final long serialVersionUID = 1L;
	private String a;		// 甲方
	private String b;		// 乙方
	private String winner;		// 胜者
	private String status;		// 0:已结束 1:进行中 2:取消
	
	public RfbTeamChallenge() {
		super();
	}

	public RfbTeamChallenge(String id){
		super(id);
	}

	@Length(min=1, max=64, message="甲方长度必须介于 1 和 64 之间")
	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}
	
	@Length(min=1, max=64, message="乙方长度必须介于 1 和 64 之间")
	public String getB() {
		return b;
	}

	public void setB(String b) {
		this.b = b;
	}
	
	@Length(min=0, max=64, message="胜者长度必须介于 0 和 64 之间")
	public String getWinner() {
		return winner;
	}

	public void setWinner(String winner) {
		this.winner = winner;
	}
	
	@Length(min=1, max=11, message="0:已结束 1:进行中 2:取消长度必须介于 1 和 11 之间")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}