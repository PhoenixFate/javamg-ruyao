/**
 * 
 */
package com.thinkgem.javamg.modules.rfb.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.javamg.common.persistence.DataEntity;

/**
 * 奖品Entity
 * @author shenming
 * @version 2020-05-04
 */
public class RfbAward extends DataEntity<RfbAward> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// 奖品名称
	private String picture;		// 奖品配图
	private String content;		// 奖品介绍
	private String rule;		// 规则
	
	public RfbAward() {
		super();
	}

	public RfbAward(String id){
		super(id);
	}

	@Length(min=1, max=64, message="奖品名称长度必须介于 1 和 64 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=1, max=500, message="奖品配图长度必须介于 1 和 500 之间")
	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	@Length(min=0, max=500, message="奖品介绍长度必须介于 0 和 500 之间")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	@Length(min=0, max=255, message="规则长度必须介于 0 和 255 之间")
	public String getRule() {
		return rule;
	}

	public void setRule(String rule) {
		this.rule = rule;
	}
	
}