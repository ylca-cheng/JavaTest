package com.cheng.utils;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ClinicalBeanUtils {

	private static Logger logger=Logger.getLogger(ClinicalBeanUtils.class);
	
	/**
	 * 浅copy
	 * @Description: 
	 * @author yuxiangtong
	 * @date 2014-11-20 下午2:08:36
	 */
	public static Object cloneBean(Object bean){
		try {
			return org.apache.commons.beanutils.BeanUtils.cloneBean(bean);
		} catch (Exception e) {
			logger.error("浅copy出错:",e);
		}
		return null;
	}
	
	
	/**
	 * 深度克隆
	 * @Description:
	 * @author yuxiangtong
	 * @date 2014-11-20 下午1:59:32
	 */
	public static Object deepCloneBean(Object o) {
		ByteArrayOutputStream baos = null;
		ObjectOutputStream oos = null;
		ByteArrayInputStream bais = null;
		ObjectInputStream ois = null;
		try {
			baos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(baos);
			oos.writeObject(o);

			bais = new ByteArrayInputStream(baos.toByteArray());
			ois = new ObjectInputStream(bais);
			return ois.readObject();
		} catch (Exception e) {
			logger.error("对象深copy出错:",e);
		} finally {
			IOUtils.closeQuietly(baos);
			IOUtils.closeQuietly(oos);
			IOUtils.closeQuietly(bais);
			IOUtils.closeQuietly(ois);
		}
		return null;
	}

}
