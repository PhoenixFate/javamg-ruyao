/**
 * 
 */
package com.thinkgem.javamg.modules.rfb.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.javamg.common.persistence.DataEntity;

/**
 * 知识库Entity
 * @author shenming
 * @version 2020-05-04
 */
public class RfbKnowledge extends DataEntity<RfbKnowledge> {
	
	private static final long serialVersionUID = 1L;
	private String type;		// 答题分类
	private String role;		// 人员角色
	private String node;		// 环节、节点
	private String title;		// 标题
	private String options;		// 选项
	private String bingo;		// 正确答案
	private String linkImage;		// 知识拓展图片
	private String linkText;		// 知识扩展文本
	private String hits;		// 点击数
	private String label;		// 标签
	
	public RfbKnowledge() {
		super();
	}

	public RfbKnowledge(String id){
		super(id);
	}

	@Length(min=1, max=11, message="答题分类长度必须介于 1 和 11 之间")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@Length(min=0, max=11, message="人员角色长度必须介于 0 和 11 之间")
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	@Length(min=0, max=11, message="环节、节点长度必须介于 0 和 11 之间")
	public String getNode() {
		return node;
	}

	public void setNode(String node) {
		this.node = node;
	}
	
	@Length(min=1, max=255, message="标题长度必须介于 1 和 255 之间")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	@Length(min=0, max=500, message="选项长度必须介于 0 和 500 之间")
	public String getOptions() {
		return options;
	}

	public void setOptions(String options) {
		this.options = options;
	}
	
	@Length(min=1, max=50, message="正确答案长度必须介于 1 和 50 之间")
	public String getBingo() {
		return bingo;
	}

	public void setBingo(String bingo) {
		this.bingo = bingo;
	}
	
	@Length(min=0, max=500, message="知识拓展图片长度必须介于 0 和 500 之间")
	public String getLinkImage() {
		return linkImage;
	}

	public void setLinkImage(String linkImage) {
		this.linkImage = linkImage;
	}
	
	@Length(min=0, max=255, message="知识扩展文本长度必须介于 0 和 255 之间")
	public String getLinkText() {
		return linkText;
	}

	public void setLinkText(String linkText) {
		this.linkText = linkText;
	}
	
	@Length(min=0, max=11, message="点击数长度必须介于 0 和 11 之间")
	public String getHits() {
		return hits;
	}

	public void setHits(String hits) {
		this.hits = hits;
	}
	
	@Length(min=0, max=255, message="标签长度必须介于 0 和 255 之间")
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
}