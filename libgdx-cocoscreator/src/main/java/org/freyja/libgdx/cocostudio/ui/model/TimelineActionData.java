package org.freyja.libgdx.cocostudio.ui.model;

import java.util.List;

public class TimelineActionData {

	float Duration;
	float Speed;
	List Timelines;
	String ctype;

	public float getDuration() {
		return Duration;
	}

	public void setDuration(float duration) {
		Duration = duration;
	}

	public float getSpeed() {
		return Speed;
	}

	public void setSpeed(float speed) {
		Speed = speed;
	}

	public List getTimelines() {
		return Timelines;
	}

	public void setTimelines(List timelines) {
		Timelines = timelines;
	}

	public String getCtype() {
		return ctype;
	}

	public void setCtype(String ctype) {
		this.ctype = ctype;
	}

}
