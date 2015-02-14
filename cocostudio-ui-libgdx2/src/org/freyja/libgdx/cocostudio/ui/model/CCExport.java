package org.freyja.libgdx.cocostudio.ui.model;

/**
 * ui json结构
 * 
 * @author i see
 * 
 */
public class CCExport {

	String ID;
	String Version;

	String Type;

	String Name;

	CCData Content;

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getVersion() {
		return Version;
	}

	public void setVersion(String version) {
		Version = version;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public CCData getContent() {
		return Content;
	}

	public void setContent(CCData content) {
		Content = content;
	}

}
