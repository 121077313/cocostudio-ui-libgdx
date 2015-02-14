package org.freyja.libgdx.cocostudio.ui.model;

import java.util.List;

import org.freyja.libgdx.cocostudio.ui.model.animation.CCAnimation;

public class GameProjectData {

	TimelineActionData Animation;

	List<CCAnimation> AnimationList;

	ObjectData ObjectData;

	public TimelineActionData getAnimation() {
		return Animation;
	}

	public void setAnimation(TimelineActionData animation) {
		Animation = animation;
	}

	public List<CCAnimation> getAnimationList() {
		return AnimationList;
	}

	public void setAnimationList(List<CCAnimation> animationList) {
		AnimationList = animationList;
	}

	public ObjectData getObjectData() {
		return ObjectData;
	}

	public void setObjectData(ObjectData objectData) {
		ObjectData = objectData;
	}

}
