/**
 * 
 */
package com.thinkgem.javamg.modules.rfb.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.javamg.common.persistence.Page;
import com.thinkgem.javamg.common.service.CrudService;
import com.thinkgem.javamg.modules.rfb.entity.RfbAward;
import com.thinkgem.javamg.modules.rfb.dao.RfbAwardDao;

/**
 * 奖品Service
 * @author shenming
 * @version 2020-05-04
 */
@Service
@Transactional(readOnly = true)
public class RfbAwardService extends CrudService<RfbAwardDao, RfbAward> {

	public RfbAward get(String id) {
		return super.get(id);
	}
	
	public List<RfbAward> findList(RfbAward rfbAward) {
		return super.findList(rfbAward);
	}
	
	public Page<RfbAward> findPage(Page<RfbAward> page, RfbAward rfbAward) {
		return super.findPage(page, rfbAward);
	}
	
	@Transactional(readOnly = false)
	public void save(RfbAward rfbAward) {
		super.save(rfbAward);
	}
	
	@Transactional(readOnly = false)
	public void delete(RfbAward rfbAward) {
		super.delete(rfbAward);
	}
	
}