/**
 * 
 */
package com.thinkgem.javamg.modules.rfb.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.javamg.common.persistence.DataEntity;

/**
 * 比赛历史Entity
 * @author shenming
 * @version 2020-05-04
 */
public class RfbHistory extends DataEntity<RfbHistory> {
	
	private static final long serialVersionUID = 1L;
	private String openid;		// 微信用户id
	private String matchType;		// 赛事类型
	private String matchCode;		// 团体赛的情况下，保存代号
	private String time;		// 用时(秒)
	private String knowledges;		// 所做答题
	private String answers;		// 对应答案
	
	public RfbHistory() {
		super();
	}

	public RfbHistory(String id){
		super(id);
	}

	@Length(min=1, max=64, message="微信用户id长度必须介于 1 和 64 之间")
	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}
	
	@Length(min=1, max=64, message="赛事类型长度必须介于 1 和 64 之间")
	public String getMatchType() {
		return matchType;
	}

	public void setMatchType(String matchType) {
		this.matchType = matchType;
	}
	
	@Length(min=0, max=11, message="团体赛的情况下，保存代号长度必须介于 0 和 11 之间")
	public String getMatchCode() {
		return matchCode;
	}

	public void setMatchCode(String matchCode) {
		this.matchCode = matchCode;
	}
	
	@Length(min=0, max=11, message="用时(秒)长度必须介于 0 和 11 之间")
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	@Length(min=0, max=500, message="所做答题长度必须介于 0 和 500 之间")
	public String getKnowledges() {
		return knowledges;
	}

	public void setKnowledges(String knowledges) {
		this.knowledges = knowledges;
	}
	
	@Length(min=0, max=200, message="对应答案长度必须介于 0 和 200 之间")
	public String getAnswers() {
		return answers;
	}

	public void setAnswers(String answers) {
		this.answers = answers;
	}
	
}