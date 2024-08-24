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

import com.cl.entity.BaoyangyuyueEntity;
import com.cl.entity.view.BaoyangyuyueView;

import com.cl.service.BaoyangyuyueService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 保养预约
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-16 12:07:34
 */
@RestController
@RequestMapping("/baoyangyuyue")
public class BaoyangyuyueController {
    @Autowired
    private BaoyangyuyueService baoyangyuyueService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,BaoyangyuyueEntity baoyangyuyue,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("shangjia")) {
			baoyangyuyue.setShangjiazhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yonghu")) {
			baoyangyuyue.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<BaoyangyuyueEntity> ew = new EntityWrapper<BaoyangyuyueEntity>();

		PageUtils page = baoyangyuyueService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, baoyangyuyue), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,BaoyangyuyueEntity baoyangyuyue, 
		HttpServletRequest request){
        EntityWrapper<BaoyangyuyueEntity> ew = new EntityWrapper<BaoyangyuyueEntity>();

		PageUtils page = baoyangyuyueService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, baoyangyuyue), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( BaoyangyuyueEntity baoyangyuyue){
       	EntityWrapper<BaoyangyuyueEntity> ew = new EntityWrapper<BaoyangyuyueEntity>();
      	ew.allEq(MPUtil.allEQMapPre( baoyangyuyue, "baoyangyuyue")); 
        return R.ok().put("data", baoyangyuyueService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(BaoyangyuyueEntity baoyangyuyue){
        EntityWrapper< BaoyangyuyueEntity> ew = new EntityWrapper< BaoyangyuyueEntity>();
 		ew.allEq(MPUtil.allEQMapPre( baoyangyuyue, "baoyangyuyue")); 
		BaoyangyuyueView baoyangyuyueView =  baoyangyuyueService.selectView(ew);
		return R.ok("查询保养预约成功").put("data", baoyangyuyueView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        BaoyangyuyueEntity baoyangyuyue = baoyangyuyueService.selectById(id);
		baoyangyuyue = baoyangyuyueService.selectView(new EntityWrapper<BaoyangyuyueEntity>().eq("id", id));
        return R.ok().put("data", baoyangyuyue);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        BaoyangyuyueEntity baoyangyuyue = baoyangyuyueService.selectById(id);
		baoyangyuyue = baoyangyuyueService.selectView(new EntityWrapper<BaoyangyuyueEntity>().eq("id", id));
        return R.ok().put("data", baoyangyuyue);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody BaoyangyuyueEntity baoyangyuyue, HttpServletRequest request){
    	baoyangyuyue.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(baoyangyuyue);
        baoyangyuyueService.insert(baoyangyuyue);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody BaoyangyuyueEntity baoyangyuyue, HttpServletRequest request){
    	baoyangyuyue.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(baoyangyuyue);
        baoyangyuyueService.insert(baoyangyuyue);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody BaoyangyuyueEntity baoyangyuyue, HttpServletRequest request){
        //ValidatorUtils.validateEntity(baoyangyuyue);
        baoyangyuyueService.updateById(baoyangyuyue);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        baoyangyuyueService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
