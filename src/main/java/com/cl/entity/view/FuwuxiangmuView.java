package com.cl.entity.view;

import com.cl.entity.FuwuxiangmuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 服务项目
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-16 12:07:34
 */
@TableName("fuwuxiangmu")
public class FuwuxiangmuView  extends FuwuxiangmuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public FuwuxiangmuView(){
	}
 
 	public FuwuxiangmuView(FuwuxiangmuEntity fuwuxiangmuEntity){
 	try {
			BeanUtils.copyProperties(this, fuwuxiangmuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
