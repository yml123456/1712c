package com.yml.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.yml.util.DateUtil;

public class UtilTest {

	public static void main(String[] args) {
		String sql = "select * from t_order where create_time>='{1}' and create_time<='{2}'";
		
		Date date = new Date();
		Date initMonth = DateUtil.getDateByInitMonth(date);
		Date fullMonth = DateUtil.getDateByFullMonth(date);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		sql = sql.replaceFirst("\\{1\\}", "{" + sdf.format(initMonth) + "}");
		sql = sql.replaceFirst("\\{2\\}", "{" + sdf.format(fullMonth) + "}");
		
		System.out.println(sql);
	}
}
