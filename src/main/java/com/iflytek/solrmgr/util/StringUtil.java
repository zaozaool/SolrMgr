package com.iflytek.solrmgr.util;

public class StringUtil {

	/**
	 * 
	 * @param args
	 * @return
	 */
	public static boolean isNullOREmpty(String args) {
		if (args == null || args.trim().equals("")) {
			return true;
		}
		return false;
	}

	/**
	 * 判断Router字段是否包含不合法字符
	 * 
	 * @param router
	 *            Router字段
	 */
	public static boolean isValidRouter(String router) {
		char[] ch = router.toCharArray();

		for (char c : ch) {

			Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);

			if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
					|| ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
					|| ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
					|| ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B
					|| ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
					|| ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS
					|| ub == Character.UnicodeBlock.GENERAL_PUNCTUATION) {
				return false;
			}
		}
		return true;
	}

}
