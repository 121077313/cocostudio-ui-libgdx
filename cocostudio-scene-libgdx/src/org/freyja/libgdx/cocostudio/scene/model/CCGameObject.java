package org.freyja.libgdx.cocostudio.scene.model;

import java.util.List;

/**
 * 控件
 * 
 * @author i see
 * 
 */
public class CCGameObject {

	String classname;

	String name;

	List<CCGameObject> gameobjects;

	float scalex;

	float scaley;

	int visible;

	float x;

	float y;

	int rotation;
	
	int objecttag;

	int zorder;

	List<CCComponent> components;

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

	public List<CCGameObject> getGameobjects() {
		return gameobjects;
	}

	public void setGameobjects(List<CCGameObject> gameobjects) {
		this.gameobjects = gameobjects;
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

	public int getVisible() {
		return visible;
	}

	public void setVisible(int visible) {
		this.visible = visible;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getRotation() {
		return rotation;
	}

	public void setRotation(int rotation) {
		this.rotation = rotation;
	}

	public int getZorder() {
		return zorder;
	}

	public void setZorder(int zorder) {
		this.zorder = zorder;
	}

	public List<CCComponent> getComponents() {
		return components;
	}

	public void setComponents(List<CCComponent> components) {
		this.components = components;
	}

	public boolean isVisible() {
		return visible == 1;
	}

	public int getObjecttag() {
		return objecttag;
	}

	public void setObjecttag(int objecttag) {
		this.objecttag = objecttag;
	}

}
