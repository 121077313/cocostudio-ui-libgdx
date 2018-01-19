package org.freyja.libgdx.cocostudio.ui.model.animation;

import java.util.List;

public class CCActionFrame {
	String classname;
	String name;

	int frameid;

	int colorb;
	int colorg;
	int colorr;
	int opacity;

	float positionx;
	float positiony;

	float rotation;

	float scalex;
	float scaley;

	String starttime;

	List<Float> tweenParameter;

	int tweenType;

	boolean visible;

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

	public int getColorb() {
		return colorb;
	}

	public void setColorb(int colorb) {
		this.colorb = colorb;
	}

	public int getColorg() {
		return colorg;
	}

	public void setColorg(int colorg) {
		this.colorg = colorg;
	}

	public int getColorr() {
		return colorr;
	}

	public void setColorr(int colorr) {
		this.colorr = colorr;
	}

	public int getOpacity() {
		return opacity;
	}

	public void setOpacity(int opacity) {
		this.opacity = opacity;
	}

	public int getFrameid() {
		return frameid;
	}

	public void setFrameid(int frameid) {
		this.frameid = frameid;
	}

	public float getPositionx() {
		return positionx;
	}

	public void setPositionx(float positionx) {
		this.positionx = positionx;
	}

	public float getPositiony() {
		return positiony;
	}

	public void setPositiony(float positiony) {
		this.positiony = positiony;
	}

	public float getRotation() {
		return rotation;
	}

	public void setRotation(float rotation) {
		this.rotation = rotation;
	}

	public float getScalex() {
		return scalex;
	}

	public void setScalex(float scalex) {
		this.scalex = scalex;
	}

	public float getScaley() {
		return scaley;
	}

	public void setScaley(float scaley) {
		this.scaley = scaley;
	}

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public List<Float> getTweenParameter() {
		return tweenParameter;
	}

	public void setTweenParameter(List<Float> tweenParameter) {
		this.tweenParameter = tweenParameter;
	}

	public int getTweenType() {
		return tweenType;
	}

	public void setTweenType(int tweenType) {
		this.tweenType = tweenType;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

}
