/**
 * 
 */
package com.thinkgem.javamg.modules.rfb.dao;

import com.thinkgem.javamg.common.persistence.CrudDao;
import com.thinkgem.javamg.common.persistence.annotation.MyBatisDao;
import com.thinkgem.javamg.modules.rfb.entity.RfbArenaUser;

/**
 * 擂台赛用户DAO接口
 * @author shenming
 * @version 2020-05-04
 */
@MyBatisDao
public interface RfbArenaUserDao extends CrudDao<RfbArenaUser> {
	
}