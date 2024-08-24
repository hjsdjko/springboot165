package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.BaoyangyuyueEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.BaoyangyuyueView;


/**
 * 保养预约
 *
 * @author 
 * @email 
 * @date 2024-03-16 12:07:34
 */
public interface BaoyangyuyueService extends IService<BaoyangyuyueEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<BaoyangyuyueView> selectListView(Wrapper<BaoyangyuyueEntity> wrapper);
   	
   	BaoyangyuyueView selectView(@Param("ew") Wrapper<BaoyangyuyueEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<BaoyangyuyueEntity> wrapper);
   	

}

