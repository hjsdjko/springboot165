package com.cl.dao;

import com.cl.entity.BaoyangyuyueEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.BaoyangyuyueView;


/**
 * 保养预约
 * 
 * @author 
 * @email 
 * @date 2024-03-16 12:07:34
 */
public interface BaoyangyuyueDao extends BaseMapper<BaoyangyuyueEntity> {
	
	List<BaoyangyuyueView> selectListView(@Param("ew") Wrapper<BaoyangyuyueEntity> wrapper);

	List<BaoyangyuyueView> selectListView(Pagination page,@Param("ew") Wrapper<BaoyangyuyueEntity> wrapper);
	
	BaoyangyuyueView selectView(@Param("ew") Wrapper<BaoyangyuyueEntity> wrapper);
	

}
