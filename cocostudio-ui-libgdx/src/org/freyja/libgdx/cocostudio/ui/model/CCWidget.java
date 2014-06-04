package org.freyja.libgdx.cocostudio.ui.model;

import java.util.List;

/**
 * 控件
 * 
 * @author i see
 * 
 */
public class CCWidget {

	 String classname;

	 String name;

	 List<CCWidget> children;

	 CCOption options;

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<CCWidget> getChildren() {
		return children;
	}

	public void setChildren(List<CCWidget> children) {
		this.children = children;
	}

	public CCOption getOptions() {
		return options;
	}

	public void setOptions(CCOption options) {
		this.options = options;
	}

}
