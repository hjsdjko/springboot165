package com.cl.entity.view;

import com.cl.entity.BaoyangyuyueEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 保养预约
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-16 12:07:34
 */
@TableName("baoyangyuyue")
public class BaoyangyuyueView  extends BaoyangyuyueEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public BaoyangyuyueView(){
	}
 
 	public BaoyangyuyueView(BaoyangyuyueEntity baoyangyuyueEntity){
 	try {
			BeanUtils.copyProperties(this, baoyangyuyueEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}