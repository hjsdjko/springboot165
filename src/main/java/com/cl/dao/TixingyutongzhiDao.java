package com.cl.dao;

import com.cl.entity.TixingyutongzhiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.TixingyutongzhiView;


/**
 * 提醒与通知
 * 
 * @author 
 * @email 
 * @date 2024-03-16 12:07:34
 */
public interface TixingyutongzhiDao extends BaseMapper<TixingyutongzhiEntity> {
	
	List<TixingyutongzhiView> selectListView(@Param("ew") Wrapper<TixingyutongzhiEntity> wrapper);

	List<TixingyutongzhiView> selectListView(Pagination page,@Param("ew") Wrapper<TixingyutongzhiEntity> wrapper);
	
	TixingyutongzhiView selectView(@Param("ew") Wrapper<TixingyutongzhiEntity> wrapper);
	

}
