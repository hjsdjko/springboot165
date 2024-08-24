package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.TixingyutongzhiDao;
import com.cl.entity.TixingyutongzhiEntity;
import com.cl.service.TixingyutongzhiService;
import com.cl.entity.view.TixingyutongzhiView;

@Service("tixingyutongzhiService")
public class TixingyutongzhiServiceImpl extends ServiceImpl<TixingyutongzhiDao, TixingyutongzhiEntity> implements TixingyutongzhiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<TixingyutongzhiEntity> page = this.selectPage(
                new Query<TixingyutongzhiEntity>(params).getPage(),
                new EntityWrapper<TixingyutongzhiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<TixingyutongzhiEntity> wrapper) {
		  Page<TixingyutongzhiView> page =new Query<TixingyutongzhiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<TixingyutongzhiView> selectListView(Wrapper<TixingyutongzhiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public TixingyutongzhiView selectView(Wrapper<TixingyutongzhiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
