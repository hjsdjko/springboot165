package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DiscussfuwuxiangmuEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussfuwuxiangmuView;


/**
 * 服务项目评论表
 *
 * @author 
 * @email 
 * @date 2024-03-16 12:07:34
 */
public interface DiscussfuwuxiangmuService extends IService<DiscussfuwuxiangmuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussfuwuxiangmuView> selectListView(Wrapper<DiscussfuwuxiangmuEntity> wrapper);
   	
   	DiscussfuwuxiangmuView selectView(@Param("ew") Wrapper<DiscussfuwuxiangmuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussfuwuxiangmuEntity> wrapper);
   	

}

