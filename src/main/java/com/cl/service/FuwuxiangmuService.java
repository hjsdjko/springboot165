package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.FuwuxiangmuEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.FuwuxiangmuView;


/**
 * 服务项目
 *
 * @author 
 * @email 
 * @date 2024-03-16 12:07:34
 */
public interface FuwuxiangmuService extends IService<FuwuxiangmuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<FuwuxiangmuView> selectListView(Wrapper<FuwuxiangmuEntity> wrapper);
   	
   	FuwuxiangmuView selectView(@Param("ew") Wrapper<FuwuxiangmuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<FuwuxiangmuEntity> wrapper);
   	

}

