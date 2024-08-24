package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.TixingyutongzhiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.TixingyutongzhiView;


/**
 * 提醒与通知
 *
 * @author 
 * @email 
 * @date 2024-03-16 12:07:34
 */
public interface TixingyutongzhiService extends IService<TixingyutongzhiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<TixingyutongzhiView> selectListView(Wrapper<TixingyutongzhiEntity> wrapper);
   	
   	TixingyutongzhiView selectView(@Param("ew") Wrapper<TixingyutongzhiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<TixingyutongzhiEntity> wrapper);
   	

}

