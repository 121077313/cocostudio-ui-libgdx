package org.freyja.libgdx.cocostudio.ui.model.animation;

import java.util.List;

public class CCActionNode {
	String classname;
	String name;
	int ActionTag;

	List<CCActionFrame> actionframelist;

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

	public int getActionTag() {
		return ActionTag;
	}

	public void setActionTag(int actionTag) {
		ActionTag = actionTag;
	}

	public List<CCActionFrame> getActionframelist() {
		return actionframelist;
	}

	public void setActionframelist(List<CCActionFrame> actionframelist) {
		this.actionframelist = actionframelist;
	}

}
