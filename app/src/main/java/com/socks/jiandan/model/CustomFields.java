package com.socks.jiandan.model;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.Serializable;

/**
 * 新鲜事中的自定义字段
 * Created by zhaokaiqiang on 15/4/24.
 */
public class CustomFields implements Serializable {

	//自定义缩略图大小
	public String thumb_c;
	//中等缩略图大小
	public String thumb_m;
	//查看人数
	public String views;

	public static CustomFields parse(final JSONObject jsonObject) {
		CustomFields customFields;
		if (jsonObject == null) {
			customFields = null;
		} else {
			customFields = new CustomFields();
			final JSONArray optJSONArray = jsonObject.optJSONArray("thumb_c");
			if (optJSONArray != null && optJSONArray.length() > 0) {
				customFields.thumb_c = optJSONArray.optString(0);
				if (customFields.thumb_c.contains("custom")) {
					customFields.thumb_m = customFields.thumb_c.replace("custom", "medium");
				}
			}
			final JSONArray optJSONArray2 = jsonObject.optJSONArray("views");
			if (optJSONArray2 != null && optJSONArray2.length() > 0) {
				customFields.views = optJSONArray2.optString(0);
			}
		}
		return customFields;
	}




}
