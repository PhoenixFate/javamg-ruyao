/**
 * 
 */
package com.thinkgem.javamg.modules.rfb.dao;

import com.thinkgem.javamg.common.persistence.CrudDao;
import com.thinkgem.javamg.common.persistence.annotation.MyBatisDao;
import com.thinkgem.javamg.modules.rfb.entity.RfbAward;

/**
 * 奖品DAO接口
 * @author shenming
 * @version 2020-05-04
 */
@MyBatisDao
public interface RfbAwardDao extends CrudDao<RfbAward> {
	
}