/**
 * 
 */
package com.thinkgem.javamg.modules.rfb.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.javamg.common.persistence.Page;
import com.thinkgem.javamg.common.service.CrudService;
import com.thinkgem.javamg.modules.rfb.entity.RfbArena;
import com.thinkgem.javamg.modules.rfb.dao.RfbArenaDao;

/**
 * 擂台赛Service
 * @author shenming
 * @version 2020-05-04
 */
@Service
@Transactional(readOnly = true)
public class RfbArenaService extends CrudService<RfbArenaDao, RfbArena> {

	public RfbArena get(String id) {
		return super.get(id);
	}
	
	public List<RfbArena> findList(RfbArena rfbArena) {
		return super.findList(rfbArena);
	}
	
	public Page<RfbArena> findPage(Page<RfbArena> page, RfbArena rfbArena) {
		return super.findPage(page, rfbArena);
	}
	
	@Transactional(readOnly = false)
	public void save(RfbArena rfbArena) {
		super.save(rfbArena);
	}
	
	@Transactional(readOnly = false)
	public void delete(RfbArena rfbArena) {
		super.delete(rfbArena);
	}
	
}