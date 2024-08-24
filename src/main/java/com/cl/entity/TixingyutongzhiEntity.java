package com.cl.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 提醒与通知
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-03-16 12:07:34
 */
@TableName("tixingyutongzhi")
public class TixingyutongzhiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public TixingyutongzhiEntity() {
		
	}
	
	public TixingyutongzhiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 用户账号
	 */
					
	private String yonghuzhanghao;
	
	/**
	 * 用户名
	 */
					
	private String yonghuming;
	
	/**
	 * 手机号码
	 */
					
	private String shoujihaoma;
	
	/**
	 * 通知提醒内容
	 */
					
	private String tongzhitixingneirong;
	
	/**
	 * 通知时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date tongzhishijian;
	
	/**
	 * 商家账号
	 */
					
	private String shangjiazhanghao;
	
	/**
	 * 店铺名称
	 */
					
	private String dianpumingcheng;
	
	/**
	 * 地区
	 */
					
	private String diqu;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：用户账号
	 */
	public void setYonghuzhanghao(String yonghuzhanghao) {
		this.yonghuzhanghao = yonghuzhanghao;
	}
	/**
	 * 获取：用户账号
	 */
	public String getYonghuzhanghao() {
		return yonghuzhanghao;
	}
	/**
	 * 设置：用户名
	 */
	public void setYonghuming(String yonghuming) {
		this.yonghuming = yonghuming;
	}
	/**
	 * 获取：用户名
	 */
	public String getYonghuming() {
		return yonghuming;
	}
	/**
	 * 设置：手机号码
	 */
	public void setShoujihaoma(String shoujihaoma) {
		this.shoujihaoma = shoujihaoma;
	}
	/**
	 * 获取：手机号码
	 */
	public String getShoujihaoma() {
		return shoujihaoma;
	}
	/**
	 * 设置：通知提醒内容
	 */
	public void setTongzhitixingneirong(String tongzhitixingneirong) {
		this.tongzhitixingneirong = tongzhitixingneirong;
	}
	/**
	 * 获取：通知提醒内容
	 */
	public String getTongzhitixingneirong() {
		return tongzhitixingneirong;
	}
	/**
	 * 设置：通知时间
	 */
	public void setTongzhishijian(Date tongzhishijian) {
		this.tongzhishijian = tongzhishijian;
	}
	/**
	 * 获取：通知时间
	 */
	public Date getTongzhishijian() {
		return tongzhishijian;
	}
	/**
	 * 设置：商家账号
	 */
	public void setShangjiazhanghao(String shangjiazhanghao) {
		this.shangjiazhanghao = shangjiazhanghao;
	}
	/**
	 * 获取：商家账号
	 */
	public String getShangjiazhanghao() {
		return shangjiazhanghao;
	}
	/**
	 * 设置：店铺名称
	 */
	public void setDianpumingcheng(String dianpumingcheng) {
		this.dianpumingcheng = dianpumingcheng;
	}
	/**
	 * 获取：店铺名称
	 */
	public String getDianpumingcheng() {
		return dianpumingcheng;
	}
	/**
	 * 设置：地区
	 */
	public void setDiqu(String diqu) {
		this.diqu = diqu;
	}
	/**
	 * 获取：地区
	 */
	public String getDiqu() {
		return diqu;
	}

}
