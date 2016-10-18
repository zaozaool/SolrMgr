package com.iflytek.solrmgr.util;

import org.hibernate.transform.AliasToBeanResultTransformer;
import org.hibernate.transform.ResultTransformer;

/**
 * hibernate Transformers
 * 
 * @author xkfeng@iflytek.com
 */
public class ResultTransformers
{

	/**
	 * 
	 * aliasToBean 别名转换成java属性规则如：COLUMN_NAME -> columnName
	 * 
	 * @param target
	 *            Class
	 * @return Transformers
	 * @author xkfeng@iflytek.com
	 * @created 2013-11-13 上午09:00:50
	 * @lastModified
	 * @history
	 */
	@SuppressWarnings("rawtypes")
	public static ResultTransformer aliasToBean(Class target)
	{
		return new AliasToBeanResultTransformer(target);
	}
}
