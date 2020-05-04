/**
 * 
 */
package com.thinkgem.javamg.modules.rfb.entity;


import com.thinkgem.javamg.common.persistence.DataEntity;

/**
 * 团队成绩Entity
 * @author shenming
 * @version 2020-05-04
 */
public class RfbTeamScore extends DataEntity<RfbTeamScore> {
	
	private static final long serialVersionUID = 1L;
	private String xx;		// 选项题评价时间
	private String sm;		// 扫码题评价时间
	private String cd;		// 穿戴题评价时间
	
	public RfbTeamScore() {
		super();
	}

	public RfbTeamScore(String id){
		super(id);
	}

	public String getXx() {
		return xx;
	}

	public void setXx(String xx) {
		this.xx = xx;
	}
	
	public String getSm() {
		return sm;
	}

	public void setSm(String sm) {
		this.sm = sm;
	}
	
	public String getCd() {
		return cd;
	}

	public void setCd(String cd) {
		this.cd = cd;
	}
	
}