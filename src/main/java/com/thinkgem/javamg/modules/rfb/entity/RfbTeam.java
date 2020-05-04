/**
 * 
 */
package com.thinkgem.javamg.modules.rfb.entity;

import org.hibernate.validator.constraints.Length(min=1, max=11, message="团体代号;
import org.hibernate.validator.constraints.Length;

import com.thinkgem.javamg.common.persistence.DataEntity;

/**
 * 团队Entity
 * @author shenming
 * @version 2020-05-04
 */
public class RfbTeam extends DataEntity<RfbTeam> {
	
	private static final long serialVersionUID = 1L;
	private String code;		// 团体代号(1~999)
	private String title;		// 团队名称
	private String status;		// 0:已结束 1:进行中 2:取消
	
	public RfbTeam() {
		super();
	}

	public RfbTeam(String id){
		super(id);
	}

	@Length(min=1, max=11, message="团体代号(1~999)长度必须介于 1 和 11 之间")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	@Length(min=1, max=100, message="团队名称长度必须介于 1 和 100 之间")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	@Length(min=1, max=11, message="0:已结束 1:进行中 2:取消长度必须介于 1 和 11 之间")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}