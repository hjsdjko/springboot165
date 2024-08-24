package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.TixingyutongzhiEntity;
import com.cl.entity.view.TixingyutongzhiView;

import com.cl.service.TixingyutongzhiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 提醒与通知
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-16 12:07:34
 */
@RestController
@RequestMapping("/tixingyutongzhi")
public class TixingyutongzhiController {
    @Autowired
    private TixingyutongzhiService tixingyutongzhiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,TixingyutongzhiEntity tixingyutongzhi,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date tongzhishijianstart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date tongzhishijianend,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			tixingyutongzhi.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("shangjia")) {
			tixingyutongzhi.setShangjiazhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<TixingyutongzhiEntity> ew = new EntityWrapper<TixingyutongzhiEntity>();
                if(tongzhishijianstart!=null) ew.ge("tongzhishijian", tongzhishijianstart);
                if(tongzhishijianend!=null) ew.le("tongzhishijian", tongzhishijianend);

		PageUtils page = tixingyutongzhiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tixingyutongzhi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,TixingyutongzhiEntity tixingyutongzhi, 
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date tongzhishijianstart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date tongzhishijianend,
		HttpServletRequest request){
        EntityWrapper<TixingyutongzhiEntity> ew = new EntityWrapper<TixingyutongzhiEntity>();
                if(tongzhishijianstart!=null) ew.ge("tongzhishijian", tongzhishijianstart);
                if(tongzhishijianend!=null) ew.le("tongzhishijian", tongzhishijianend);

		PageUtils page = tixingyutongzhiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tixingyutongzhi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( TixingyutongzhiEntity tixingyutongzhi){
       	EntityWrapper<TixingyutongzhiEntity> ew = new EntityWrapper<TixingyutongzhiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( tixingyutongzhi, "tixingyutongzhi")); 
        return R.ok().put("data", tixingyutongzhiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(TixingyutongzhiEntity tixingyutongzhi){
        EntityWrapper< TixingyutongzhiEntity> ew = new EntityWrapper< TixingyutongzhiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( tixingyutongzhi, "tixingyutongzhi")); 
		TixingyutongzhiView tixingyutongzhiView =  tixingyutongzhiService.selectView(ew);
		return R.ok("查询提醒与通知成功").put("data", tixingyutongzhiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        TixingyutongzhiEntity tixingyutongzhi = tixingyutongzhiService.selectById(id);
		tixingyutongzhi = tixingyutongzhiService.selectView(new EntityWrapper<TixingyutongzhiEntity>().eq("id", id));
        return R.ok().put("data", tixingyutongzhi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        TixingyutongzhiEntity tixingyutongzhi = tixingyutongzhiService.selectById(id);
		tixingyutongzhi = tixingyutongzhiService.selectView(new EntityWrapper<TixingyutongzhiEntity>().eq("id", id));
        return R.ok().put("data", tixingyutongzhi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody TixingyutongzhiEntity tixingyutongzhi, HttpServletRequest request){
    	tixingyutongzhi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(tixingyutongzhi);
        tixingyutongzhiService.insert(tixingyutongzhi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody TixingyutongzhiEntity tixingyutongzhi, HttpServletRequest request){
    	tixingyutongzhi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(tixingyutongzhi);
        tixingyutongzhiService.insert(tixingyutongzhi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody TixingyutongzhiEntity tixingyutongzhi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(tixingyutongzhi);
        tixingyutongzhiService.updateById(tixingyutongzhi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        tixingyutongzhiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
