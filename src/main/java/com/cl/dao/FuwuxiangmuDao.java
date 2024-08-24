package com.cl.dao;

import com.cl.entity.FuwuxiangmuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.FuwuxiangmuView;


/**
 * 服务项目
 * 
 * @author 
 * @email 
 * @date 2024-03-16 12:07:34
 */
public interface FuwuxiangmuDao extends BaseMapper<FuwuxiangmuEntity> {
	
	List<FuwuxiangmuView> selectListView(@Param("ew") Wrapper<FuwuxiangmuEntity> wrapper);

	List<FuwuxiangmuView> selectListView(Pagination page,@Param("ew") Wrapper<FuwuxiangmuEntity> wrapper);
	
	FuwuxiangmuView selectView(@Param("ew") Wrapper<FuwuxiangmuEntity> wrapper);
	

}
