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
import com.cl.entity.OrdersEntity;
import com.cl.service.OrdersService;

import com.cl.entity.FuwuxiangmuEntity;
import com.cl.entity.view.FuwuxiangmuView;

import com.cl.service.FuwuxiangmuService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;
import com.cl.service.StoreupService;
import com.cl.entity.StoreupEntity;

/**
 * 服务项目
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-16 12:07:34
 */
@RestController
@RequestMapping("/fuwuxiangmu")
public class FuwuxiangmuController {
    @Autowired
    private FuwuxiangmuService fuwuxiangmuService;

    @Autowired
    private StoreupService storeupService;

    @Autowired
    private OrdersService ordersService;

    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,FuwuxiangmuEntity fuwuxiangmu,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("shangjia")) {
			fuwuxiangmu.setShangjiazhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<FuwuxiangmuEntity> ew = new EntityWrapper<FuwuxiangmuEntity>();

		PageUtils page = fuwuxiangmuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fuwuxiangmu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,FuwuxiangmuEntity fuwuxiangmu, 
		HttpServletRequest request){
        EntityWrapper<FuwuxiangmuEntity> ew = new EntityWrapper<FuwuxiangmuEntity>();

		PageUtils page = fuwuxiangmuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fuwuxiangmu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( FuwuxiangmuEntity fuwuxiangmu){
       	EntityWrapper<FuwuxiangmuEntity> ew = new EntityWrapper<FuwuxiangmuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( fuwuxiangmu, "fuwuxiangmu")); 
        return R.ok().put("data", fuwuxiangmuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(FuwuxiangmuEntity fuwuxiangmu){
        EntityWrapper< FuwuxiangmuEntity> ew = new EntityWrapper< FuwuxiangmuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( fuwuxiangmu, "fuwuxiangmu")); 
		FuwuxiangmuView fuwuxiangmuView =  fuwuxiangmuService.selectView(ew);
		return R.ok("查询服务项目成功").put("data", fuwuxiangmuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        FuwuxiangmuEntity fuwuxiangmu = fuwuxiangmuService.selectById(id);
		fuwuxiangmu.setClicktime(new Date());
		fuwuxiangmuService.updateById(fuwuxiangmu);
		fuwuxiangmu = fuwuxiangmuService.selectView(new EntityWrapper<FuwuxiangmuEntity>().eq("id", id));
        return R.ok().put("data", fuwuxiangmu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        FuwuxiangmuEntity fuwuxiangmu = fuwuxiangmuService.selectById(id);
		fuwuxiangmu.setClicktime(new Date());
		fuwuxiangmuService.updateById(fuwuxiangmu);
		fuwuxiangmu = fuwuxiangmuService.selectView(new EntityWrapper<FuwuxiangmuEntity>().eq("id", id));
        return R.ok().put("data", fuwuxiangmu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody FuwuxiangmuEntity fuwuxiangmu, HttpServletRequest request){
    	fuwuxiangmu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(fuwuxiangmu);
        fuwuxiangmuService.insert(fuwuxiangmu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody FuwuxiangmuEntity fuwuxiangmu, HttpServletRequest request){
    	fuwuxiangmu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(fuwuxiangmu);
        fuwuxiangmuService.insert(fuwuxiangmu);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody FuwuxiangmuEntity fuwuxiangmu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(fuwuxiangmu);
        fuwuxiangmuService.updateById(fuwuxiangmu);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        fuwuxiangmuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,FuwuxiangmuEntity fuwuxiangmu, HttpServletRequest request,String pre){
        EntityWrapper<FuwuxiangmuEntity> ew = new EntityWrapper<FuwuxiangmuEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicktime");
        params.put("order", "desc");
		PageUtils page = fuwuxiangmuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fuwuxiangmu), params), params));
        return R.ok().put("data", page);
    }

        /**
     * 按用户购买推荐
     */
    @RequestMapping("/autoSort2")
    public R autoSort2(@RequestParam Map<String, Object> params,FuwuxiangmuEntity fuwuxiangmu, HttpServletRequest request){
        String userId = request.getSession().getAttribute("userId").toString();
        String goodtypeColumn = "fuwuleixing";
        List<OrdersEntity> orders = ordersService.selectList(new EntityWrapper<OrdersEntity>().eq("userid", userId).eq("tablename", "fuwuxiangmu").orderBy("addtime", false));
        List<String> goodtypes = new ArrayList<String>();
        Integer limit = params.get("limit")==null?10:Integer.parseInt(params.get("limit").toString());
        List<FuwuxiangmuEntity> fuwuxiangmuList = new ArrayList<FuwuxiangmuEntity>();
	//去重
    	List<OrdersEntity> ordersDist = new ArrayList<OrdersEntity>();
    	for(OrdersEntity o1 : orders) {
    		boolean addFlag = true;
    		for(OrdersEntity o2 : ordersDist) {
    			if(o1.getGoodid()==o2.getGoodid() || o1.getGoodtype().equals(o2.getGoodtype())) {
    				addFlag = false;
    				break;
    			}
    		}
    		if(addFlag) ordersDist.add(o1);
    	}
        if(ordersDist!=null && ordersDist.size()>0) {
                for(OrdersEntity o : ordersDist) {
                        fuwuxiangmuList.addAll(fuwuxiangmuService.selectList(new EntityWrapper<FuwuxiangmuEntity>().eq(goodtypeColumn, o.getGoodtype())));
                }
        }
        EntityWrapper<FuwuxiangmuEntity> ew = new EntityWrapper<FuwuxiangmuEntity>();
        params.put("sort", "id");
        params.put("order", "desc");
        PageUtils page = fuwuxiangmuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fuwuxiangmu), params), params));
        List<FuwuxiangmuEntity> pageList = (List<FuwuxiangmuEntity>)page.getList();
        if(fuwuxiangmuList.size()<limit) {
                int toAddNum = (limit-fuwuxiangmuList.size())<=pageList.size()?(limit-fuwuxiangmuList.size()):pageList.size();
                for(FuwuxiangmuEntity o1 : pageList) {
                    boolean addFlag = true;
                    for(FuwuxiangmuEntity o2 : fuwuxiangmuList) {
                        if(o1.getId().intValue()==o2.getId().intValue()) {
                            addFlag = false;
                            break;
                        }
                    }
                    if(addFlag) {
                        fuwuxiangmuList.add(o1);
                        if(--toAddNum==0) break;
                    }   
                }
        } else if(fuwuxiangmuList.size()>limit) {
            fuwuxiangmuList = fuwuxiangmuList.subList(0, limit);
        }
        page.setList(fuwuxiangmuList);
        return R.ok().put("data", page);
    }







}
