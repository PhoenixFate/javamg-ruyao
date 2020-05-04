/**
 * 
 */
package com.thinkgem.javamg.modules.rfb.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.NotNull;

import com.thinkgem.javamg.common.persistence.DataEntity;

/**
 * 擂台赛Entity
 * @author shenming
 * @version 2020-05-04
 */
public class RfbArena extends DataEntity<RfbArena> {
	
	private static final long serialVersionUID = 1L;
	private String title;		// 擂台赛名称
	private String type;		// 赛事类型
	private String intro;		// 擂台赛介绍
	private String awardTitle;		// 奖品名称
	private String awardImage;		// 奖品图片
	private String awardIntro;		// 奖品介绍
	private Date startDate;		// 开始日期
	private Date endDate;		// 结束日期
	private String winner;		// 擂主openid
	private String status;		// 赛事状态
	
	public RfbArena() {
		super();
	}

	public RfbArena(String id){
		super(id);
	}

	@Length(min=1, max=100, message="擂台赛名称长度必须介于 1 和 100 之间")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	@Length(min=1, max=11, message="赛事类型长度必须介于 1 和 11 之间")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@Length(min=0, max=500, message="擂台赛介绍长度必须介于 0 和 500 之间")
	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}
	
	@Length(min=1, max=64, message="奖品名称长度必须介于 1 和 64 之间")
	public String getAwardTitle() {
		return awardTitle;
	}

	public void setAwardTitle(String awardTitle) {
		this.awardTitle = awardTitle;
	}
	
	@Length(min=0, max=255, message="奖品图片长度必须介于 0 和 255 之间")
	public String getAwardImage() {
		return awardImage;
	}

	public void setAwardImage(String awardImage) {
		this.awardImage = awardImage;
	}
	
	@Length(min=0, max=500, message="奖品介绍长度必须介于 0 和 500 之间")
	public String getAwardIntro() {
		return awardIntro;
	}

	public void setAwardIntro(String awardIntro) {
		this.awardIntro = awardIntro;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="开始日期不能为空")
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="结束日期不能为空")
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	@Length(min=0, max=64, message="擂主openid长度必须介于 0 和 64 之间")
	public String getWinner() {
		return winner;
	}

	public void setWinner(String winner) {
		this.winner = winner;
	}
	
	@Length(min=1, max=11, message="赛事状态长度必须介于 1 和 11 之间")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}