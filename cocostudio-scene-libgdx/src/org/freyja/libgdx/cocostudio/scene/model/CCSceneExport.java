package org.freyja.libgdx.cocostudio.scene.model;

import java.util.List;

/**
 * ui json结构
 * 
 * @author i see
 * 
 */
public class CCSceneExport extends CCGameObject {

	String Version;

	CanvasSize CanvasSize;

	public String getVersion() {
		return Version;
	}

	public void setVersion(String version) {
		Version = version;
	}

	public CanvasSize getCanvasSize() {
		return CanvasSize;
	}

	public void setCanvasSize(CanvasSize canvasSize) {
		CanvasSize = canvasSize;
	}

}
