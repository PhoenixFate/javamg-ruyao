/**
 * 
 */
package com.thinkgem.javamg.modules.rfb.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.javamg.common.persistence.Page;
import com.thinkgem.javamg.common.service.CrudService;
import com.thinkgem.javamg.modules.rfb.entity.RfbUser;
import com.thinkgem.javamg.modules.rfb.dao.RfbUserDao;

/**
 * 用户Service
 * @author shenming
 * @version 2020-05-04
 */
@Service
@Transactional(readOnly = true)
public class RfbUserService extends CrudService<RfbUserDao, RfbUser> {

	@Autowired
	private RfbUserDao rfbUserDao;


	public RfbUser get(String id) {
		return super.get(id);
	}

	@Transactional(readOnly = false)
	public RfbUser createByOpenId(String openId){
		RfbUser result = rfbUserDao.getByOpenId(openId);
		if(result==null){
			result=new RfbUser();
			result.setId(UUID.randomUUID().toString());
			result.setOpenid(openId);
			result.setCreateDate(new Date());
			result.setUpdateDate(new Date());
			result.setBestScore(10000);
			result.setUseCount(0);
			rfbUserDao.insert(result);
			return result;
		}
		return result;
	}

	
	public List<RfbUser> findList(RfbUser rfbUser) {
		return super.findList(rfbUser);
	}
	
	public Page<RfbUser> findPage(Page<RfbUser> page, RfbUser rfbUser) {

		page.setOrderBy("best_score asc");

		return super.findPage(page, rfbUser);
	}
	
	@Transactional(readOnly = false)
	public void save(RfbUser rfbUser) {
		super.save(rfbUser);
	}
	
	@Transactional(readOnly = false)
	public void delete(RfbUser rfbUser) {
		super.delete(rfbUser);
	}

	@Transactional(readOnly = false)
	public void updateFromWeChat(RfbUser rfbUser) {
		RfbUser oldRfbUser = rfbUserDao.get(rfbUser.getId());
		oldRfbUser.setAvatarUrl(rfbUser.getAvatarUrl());
 		oldRfbUser.setCity(rfbUser.getCity());
		oldRfbUser.setCountry(rfbUser.getCountry());
 		oldRfbUser.setGender(rfbUser.getGender());
		oldRfbUser.setNickName(rfbUser.getNickName());
		rfbUserDao.update(oldRfbUser);
	}
}