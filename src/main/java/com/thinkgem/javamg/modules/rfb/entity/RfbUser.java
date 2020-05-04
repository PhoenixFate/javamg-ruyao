/**
 * 
 */
package com.thinkgem.javamg.modules.rfb.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.javamg.common.persistence.DataEntity;

/**
 * 用户Entity
 * @author shenming
 * @version 2020-05-04
 */
public class RfbUser extends DataEntity<RfbUser> {
	
	private static final long serialVersionUID = 1L;
	private String openid;		// 微信openid
	private String nickname;		// 昵称
	private String gender;		// 性别
	private String realname;		// 真实姓名
	private String phone;		// 手机
	private String address;		// 地址
	private String city;		// 市
	private String province;		// 省
	private String country;		// 县
	private String avatarUrl;		// 头像
	private String unionid;		// 唯一机制id
	private String bestScore;		// 最好成绩
	private String useCount;		// 使用次数
	
	public RfbUser() {
		super();
	}

	public RfbUser(String id){
		super(id);
	}

	@Length(min=1, max=64, message="微信openid长度必须介于 1 和 64 之间")
	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}
	
	@Length(min=1, max=64, message="昵称长度必须介于 1 和 64 之间")
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	@Length(min=0, max=100, message="性别长度必须介于 0 和 100 之间")
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	@Length(min=0, max=100, message="真实姓名长度必须介于 0 和 100 之间")
	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}
	
	@Length(min=0, max=20, message="手机长度必须介于 0 和 20 之间")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Length(min=0, max=500, message="地址长度必须介于 0 和 500 之间")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	@Length(min=0, max=100, message="市长度必须介于 0 和 100 之间")
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	@Length(min=0, max=100, message="省长度必须介于 0 和 100 之间")
	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}
	
	@Length(min=0, max=100, message="县长度必须介于 0 和 100 之间")
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	@Length(min=0, max=200, message="头像长度必须介于 0 和 200 之间")
	public String getAvatarUrl() {
		return avatarUrl;
	}

	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}
	
	@Length(min=0, max=200, message="唯一机制id长度必须介于 0 和 200 之间")
	public String getUnionid() {
		return unionid;
	}

	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}
	
	@Length(min=0, max=11, message="最好成绩长度必须介于 0 和 11 之间")
	public String getBestScore() {
		return bestScore;
	}

	public void setBestScore(String bestScore) {
		this.bestScore = bestScore;
	}
	
	@Length(min=0, max=11, message="使用次数长度必须介于 0 和 11 之间")
	public String getUseCount() {
		return useCount;
	}

	public void setUseCount(String useCount) {
		this.useCount = useCount;
	}
	
}