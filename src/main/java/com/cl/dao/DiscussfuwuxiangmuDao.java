package com.cl.dao;

import com.cl.entity.DiscussfuwuxiangmuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussfuwuxiangmuView;


/**
 * 服务项目评论表
 * 
 * @author 
 * @email 
 * @date 2024-03-16 12:07:34
 */
public interface DiscussfuwuxiangmuDao extends BaseMapper<DiscussfuwuxiangmuEntity> {
	
	List<DiscussfuwuxiangmuView> selectListView(@Param("ew") Wrapper<DiscussfuwuxiangmuEntity> wrapper);

	List<DiscussfuwuxiangmuView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussfuwuxiangmuEntity> wrapper);
	
	DiscussfuwuxiangmuView selectView(@Param("ew") Wrapper<DiscussfuwuxiangmuEntity> wrapper);
	

}
