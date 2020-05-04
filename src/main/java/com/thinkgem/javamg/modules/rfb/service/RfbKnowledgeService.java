/**
 * 
 */
package com.thinkgem.javamg.modules.rfb.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.javamg.common.persistence.Page;
import com.thinkgem.javamg.common.service.CrudService;
import com.thinkgem.javamg.modules.rfb.entity.RfbKnowledge;
import com.thinkgem.javamg.modules.rfb.dao.RfbKnowledgeDao;

/**
 * 知识库Service
 * @author shenming
 * @version 2020-05-04
 */
@Service
@Transactional(readOnly = true)
public class RfbKnowledgeService extends CrudService<RfbKnowledgeDao, RfbKnowledge> {

	public RfbKnowledge get(String id) {
		return super.get(id);
	}
	
	public List<RfbKnowledge> findList(RfbKnowledge rfbKnowledge) {
		return super.findList(rfbKnowledge);
	}
	
	public Page<RfbKnowledge> findPage(Page<RfbKnowledge> page, RfbKnowledge rfbKnowledge) {
		return super.findPage(page, rfbKnowledge);
	}
	
	@Transactional(readOnly = false)
	public void save(RfbKnowledge rfbKnowledge) {
		super.save(rfbKnowledge);
	}
	
	@Transactional(readOnly = false)
	public void delete(RfbKnowledge rfbKnowledge) {
		super.delete(rfbKnowledge);
	}
	
}