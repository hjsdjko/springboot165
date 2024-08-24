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


import com.cl.dao.FuwuxiangmuDao;
import com.cl.entity.FuwuxiangmuEntity;
import com.cl.service.FuwuxiangmuService;
import com.cl.entity.view.FuwuxiangmuView;

@Service("fuwuxiangmuService")
public class FuwuxiangmuServiceImpl extends ServiceImpl<FuwuxiangmuDao, FuwuxiangmuEntity> implements FuwuxiangmuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<FuwuxiangmuEntity> page = this.selectPage(
                new Query<FuwuxiangmuEntity>(params).getPage(),
                new EntityWrapper<FuwuxiangmuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<FuwuxiangmuEntity> wrapper) {
		  Page<FuwuxiangmuView> page =new Query<FuwuxiangmuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<FuwuxiangmuView> selectListView(Wrapper<FuwuxiangmuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public FuwuxiangmuView selectView(Wrapper<FuwuxiangmuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
