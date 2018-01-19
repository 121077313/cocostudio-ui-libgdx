package org.freyja.libgdx.cocostudio.ui.widget;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener.ChangeEvent;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.utils.Pools;

/** A progress bar is a horizontal indicator that allows a user to set a value. The progress bar has a range (min, max) and a stepping between
 * each value the progress bar represents.
 * <p>
 * The preferred height of a progress bar is determined by the larger of the knob and background. The preferred width of a progress bar is
 * 140, a relatively arbitrary size.*/
public class ProgressBar extends Table{
	protected ProgressBarStyle style;
	protected float min, max, stepSize;
	protected float value, animateFromValue;
	protected float progressPos;
	protected final boolean vertical;
	int draggingPointer = -1;
	protected float animateDuration, animateTime;
	protected Interpolation animateInterpolation = Interpolation.linear;
	protected float[] snapValues;
	protected float threshold;

	public ProgressBar (float min, float max, float stepSize, boolean vertical, Skin skin) {
		this(min, max, stepSize, vertical, skin.get("default-" + (vertical ? "vertical" : "horizontal"), ProgressBarStyle.class));
	}

	public ProgressBar (float min, float max, float stepSize, boolean vertical, Skin skin, String styleName) {
		this(min, max, stepSize, vertical, skin.get(styleName, ProgressBarStyle.class));
	}

	/** Creates a new progress bar. It's width is determined by the given prefWidth parameter, its height is determined by the maximum of
	 * the height of either the progress bar {@link NinePatch} or progress bar handle {@link TextureRegion}. The min and max values determine
	 * the range the values of this progress bar can take on, the stepSize parameter specifies the distance between individual values.
	 * E.g. min could be 4, max could be 10 and stepSize could be 0.2, giving you a total of 30 values, 4.0 4.2, 4.4 and so on.
	 * @param min the minimum value
	 * @param max the maximum value
	 * @param stepSize the step size between values
	 * @param style the {@link ProgressBarStyle} */
	public ProgressBar (float min, float max, float stepSize, boolean vertical, ProgressBarStyle style) {
		if (min > max) throw new IllegalArgumentException("min must be > max: " + min + " > " + max);
		if (stepSize <= 0) throw new IllegalArgumentException("stepSize must be > 0: " + stepSize);
		setStyle(style);
		this.min = min;
		this.max = max;
		this.stepSize = stepSize;
		this.vertical = vertical;
		this.value = min;
		setWidth(getPrefWidth());
		setHeight(getPrefHeight());
		this.left();
	}

	public void setStyle (ProgressBarStyle style) {
		if (style == null) throw new IllegalArgumentException("style cannot be null.");
		this.style = style;
		invalidateHierarchy();
	}

	/** Returns the progress bar's style. Modifying the returned style may not have an effect until {@link #setStyle(ProgressBarStyle)} is
	 * called. */
	public ProgressBarStyle getStyle () {
		return style;
	}

	public void act (float delta) {
		super.act(delta);
		animateTime -= delta;
	}

	@Override
	public void draw (Batch batch, float parentAlpha) {
		ProgressBarStyle style = this.style;
		final Drawable bg = style.background;
		final Drawable knobBefore = style.progress;

		Color color = getColor();
		float x = getX();
		float y = getY();
		float width = getWidth();
		float height = getHeight();
		float value = getVisualValue();

		batch.setColor(color.r, color.g, color.b, color.a * parentAlpha);

		if (vertical) {
			bg.draw(batch, x + (int)((width - bg.getMinWidth()) * 0.5f), y, bg.getMinWidth(), height);

			float progressPosHeight = height - (bg.getTopHeight() + bg.getBottomHeight());
			if (min != max) {
				progressPos = (value - min) / (max - min) * (progressPosHeight);
				progressPos = Math.max(0, progressPos);
				progressPos = Math.min(progressPosHeight, progressPos) + bg.getBottomHeight();
			}

			if (knobBefore != null) {
				knobBefore.draw(batch, x + (int)((width - knobBefore.getMinWidth()) * 0.5f), y, knobBefore.getMinWidth(),
					(int)(progressPos));
			}
		} else {
			bg.draw(batch, x, y + (int)((height - bg.getMinHeight()) * 0.5f), width, bg.getMinHeight());

			float progressPosWidth = width - (bg.getLeftWidth() + bg.getRightWidth());
			if (min != max) {
				progressPos = (value - min) / (max - min) * (progressPosWidth);
				progressPos = Math.max(0, progressPos);
				progressPos = Math.min(progressPosWidth, progressPos) + bg.getLeftWidth();
			}

			if (knobBefore != null) {
				knobBefore.draw(batch, x, y + (int)((height - knobBefore.getMinHeight()) * 0.5f), (int)(progressPos),
					knobBefore.getMinHeight());
			}
		}
		super.draw(batch, parentAlpha);
	}

	boolean calculatePositionAndValue (float x, float y) {
		final Drawable bg = style.background;

		float value;
		float oldPosition = progressPos;

		if (vertical) {
			float height = getHeight() - bg.getTopHeight() - bg.getBottomHeight();
			progressPos = y - bg.getBottomHeight();
			value = min + (max - min) * (progressPos / (height));
			progressPos = Math.max(0, progressPos);
			progressPos = Math.min(height, progressPos);
		} else {
			float width = getWidth() - bg.getLeftWidth() - bg.getRightWidth();
			progressPos = x - bg.getLeftWidth();
			value = min + (max - min) * (progressPos / (width));
			progressPos = Math.max(0, progressPos);
			progressPos = Math.min(width, progressPos);
		}

		float oldValue = value;
		boolean valueSet = setValue(value);
		if (value == oldValue) progressPos = oldPosition;
		return valueSet;
	}

	public float getValue () {
		return value;
	}

	/** If {@link #setAnimateDuration(float) animating} the progress bar value, this returns the value current displayed. */
	public float getVisualValue () {
		if (animateTime > 0) return animateInterpolation.apply(animateFromValue, value, 1 - animateTime / animateDuration);
		return value;
	}

	/** Sets the progress bar position, rounded to the nearest step size and clamped to the minumum and maximim values.
	 * {@link #clamp(float)} can be overidden to allow values outside of the progress bars min/max range.
	 * @return false if the value was not changed because the progress bar already had the value or it was canceled by a listener. */
	public boolean setValue (float value) {
		value = snap(clamp(Math.round(value / stepSize) * stepSize));
		float oldValue = this.value;
		if (value == oldValue) return false;
		float oldVisualValue = getVisualValue();
		this.value = value;
		ChangeEvent changeEvent = Pools.obtain(ChangeEvent.class);
		boolean cancelled = fire(changeEvent);
		if (cancelled)
			this.value = oldValue;
		else if (animateDuration > 0) {
			animateFromValue = oldVisualValue;
			animateTime = animateDuration;
		}
		Pools.free(changeEvent);
		return !cancelled;
	}

	/** Clamps the value to the progress bars min/max range. */
	protected float clamp (float value) {
		return MathUtils.clamp(value, min, max);
	}

	/** Sets the range of this progress bar. The progress bar's current value is reset to min. */
	public void setRange (float min, float max) {
		if (min > max) throw new IllegalArgumentException("min must be <= max");
		this.min = min;
		this.max = max;
		if (value < min)
			setValue(min);
		else if (value > max) setValue(max);
	}

	/** Sets the step size of the progress bar */
	public void setStepSize (float stepSize) {
		if (stepSize <= 0) throw new IllegalArgumentException("steps must be > 0: " + stepSize);
		this.stepSize = stepSize;
	}

	public float getPrefWidth () {
		if (vertical) {
			final Drawable bg = style.background;
			return Math.max(0, bg.getMinWidth());
		} else
			return 140;
	}

	public float getPrefHeight () {
		if (vertical)
			return 140;
		else {
			final Drawable bg = style.background;
			return Math.max(0, bg.getMinHeight());
		}
	}

	public float getMinValue () {
		return this.min;
	}

	public float getMaxValue () {
		return this.max;
	}

	public float getStepSize () {
		return this.stepSize;
	}

	/** If > 0, changes to the progress bar value via {@link #setValue(float)} will happen over this duration in seconds. */
	public void setAnimateDuration (float duration) {
		this.animateDuration = duration;
	}

	/** Sets the interpolation to use for {@link #setAnimateDuration(float)}. */
	public void setAnimateInterpolation (Interpolation animateInterpolation) {
		if (animateInterpolation == null) throw new IllegalArgumentException("animateInterpolation cannot be null.");
		this.animateInterpolation = animateInterpolation;
	}

	/** Will make this progress bar snap to the specified values, if the knob is within the threshold */
	public void setSnapToValues (float[] values, float threshold) {
		this.snapValues = values;
		this.threshold = threshold;
	}

	/** Returns a snapped value, or the original value */
	private float snap (float value) {
		if (snapValues == null) return value;
		for (int i = 0; i < snapValues.length; i++) {
			if (Math.abs(value - snapValues[i]) <= threshold) return snapValues[i];
		}
		return value;
	}


	/** The style for a progress bar, see {@link ProgressBar}.*/
	static public class ProgressBarStyle {
		/** The progress bar background, stretched only in one direction. */
		public Drawable background;
		/** ProgressBar progress. */
		public Drawable progress;

		public ProgressBarStyle () {
		}

		public ProgressBarStyle (Drawable background, Drawable progress) {
			this.background = background;
			this.progress = progress;
		}

		public ProgressBarStyle (ProgressBarStyle style) {
			this.background = style.background;
			this.progress = style.progress;
		}
	}
}