package org.freyja.libgdx.cocostudio.scene.model;

/**
 * 控件选项
 * 
 * @author i see
 * 
 */
public class CCComponent {
	
	String __type;
	
	String classname;
	
	String name;

	String scenename;

	
	String file;
	
	CCFileData fileData;

	public String get__type() {
		return __type;
	}

	public void set__type(String __type) {
		this.__type = __type;
	}

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

	public String getScenename() {
		return scenename;
	}

	public void setScenename(String scenename) {
		this.scenename = scenename;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public CCFileData getFileData() {
		return fileData;
	}

	public void setFileData(CCFileData fileData) {
		this.fileData = fileData;
	}
	
	

}
