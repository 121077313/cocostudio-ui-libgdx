package org.freyja.libgdx.cocostudio.ui.util;

public class StringUtil {
	/** 去除重复字符 */
	public static String removeRepeatedChar(String text) {
		char[] chars = text.toCharArray();
		char[] existChar = new char[chars.length];
		int i = 0;
		StringBuffer sb = new StringBuffer();
		for (char ch : chars) {
			if (isExistsChar(existChar, ch)) {
				continue;
			}
			existChar[i] = ch;
			sb.append(ch);
			i++;
		}

		if (chars.length == i) {// 没有重复项避免创建String
			return text;
		}
		return sb.toString();
	}

	/** 检查是否存在字符 */
	static boolean isExistsChar(char[] chars, char ch) {
		for (char c : chars) {
			if (c == ch) {
				return true;
			}
		}
		return false;
	}
}
