package org.freyja.libgdx.cocos.creator.ui.model;

import java.util.List;

public class PolygonCollider extends CCScene {

	private Vec2 _offset;

	private List<Vec2> points;

	public List<Vec2> getPoints() {
		return points;
	}

	public void setPoints(List<Vec2> points) {
		this.points = points;
	}

}
