/**
 * 
 */
package com.thinkgem.javamg.modules.rfb.service;

import java.util.List;

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

	public RfbUser get(String id) {
		return super.get(id);
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
	
}