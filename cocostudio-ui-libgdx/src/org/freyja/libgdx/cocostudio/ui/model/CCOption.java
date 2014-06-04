package org.freyja.libgdx.cocostudio.ui.model;

/**
 * 控件选项
 * 
 * @author i see
 * 
 */
public class CCOption {
	String __type;
	String classname;
	String name;
	int ZOrder;
	int actiontag;
	float anchorPointX;
	float anchorPointY;
	String classType;
	int colorB;
	int colorG;
	int colorR;
	boolean flipX;
	boolean flipY;
	float height;
	boolean ignoreSize;
	String layoutParameter;
	int opacity;
	float positionPercentX;
	float positionPercentY;
	int positionType;
	float rotation;
	float scaleX;
	float scaleY;
	float sizePercentX;
	float sizePercentY;
	int sizeType;
	int tag;
	boolean touchAble;

	@Deprecated
	boolean useMergedTexture;

	boolean visible;
	float width;
	float x;
	float y;
	int bgColorB;
	int bgColorG;
	int bgColorOpacity;
	int bgColorR;
	int bgEndColorB;
	int bgEndColorG;
	int bgEndColorR;
	int bgStartColorB;
	int bgStartColorG;
	int bgStartColorR;
	int capInsetsHeight;
	int capInsetsWidth;
	int capInsetsX;
	int capInsetsY;
	boolean clipAble;
	int colorType;
	int layoutType;
	float vectorX;
	float vectorY;
	String fileName;
	/** 图片文件 */
	CCWidgetData fileNameData;
	/** 字体名字 */
	String fontName;
	int fontSize;
	int fontType;
	String normal;
	/** 按钮普通状态 */
	CCWidgetData normalData;
	String pressed;
	/** 按钮按下状态 */
	CCWidgetData pressedData;
	String disabled;
	/** 按钮禁用状态 */
	CCWidgetData disabledData;
	boolean scale9Enable;
	int scale9Height;
	int scale9Width;
	/** 文字 */
	String text;
	int textColorB;
	int textColorG;
	int textColorR;
	/** 最大长度 */
	int maxLength;
	/** 是否启用最大长度 */
	boolean maxLengthEnable;
	/** 密码模式 */
	boolean passwordEnable;
	/** 密码替换字符 '*' */
	char passwordStyleText;
	/** 文本默认文字 */
	String placeHolder;
	int vAlignment;
	int hAlignment;
	int areaWidth;
	int areaHeight;
	boolean touchScaleEnable;
	String backGroundImage;
	CCWidgetData backGroundImageData;
	boolean backGroundScale9Enable;

	/** 滚动控件,是否开启弹簧 */
	boolean bounceEnable;

	/** 滚动方向 1 上下,2左右 3,都可以 */
	int direction;

	/** checkbox选中标识 */
	boolean selectedState;

	CCWidgetData frontCrossData;

	CCWidgetData frontCrossDisabledData;

	CCWidgetData backGroundBoxSelectedData;

	CCWidgetData backGroundBoxDisabledData;

	CCWidgetData backGroundBoxData;

	CCWidgetData textureData;

	CCWidgetData charMapFileData;

	int itemWidth;

	int itemHeight;

	String stringValue;

	String startCharMap;

	CCWidgetData ballNormalData;

	CCWidgetData barFileNameData;

	float percent;
	
	public float getPercent() {
		return percent;
	}

	public void setPercent(float percent) {
		this.percent = percent;
	}

	public CCWidgetData getBallNormalData() {
		return ballNormalData;
	}

	public void setBallNormalData(CCWidgetData ballNormalData) {
		this.ballNormalData = ballNormalData;
	}

	public CCWidgetData getBarFileNameData() {
		return barFileNameData;
	}

	public void setBarFileNameData(CCWidgetData barFileNameData) {
		this.barFileNameData = barFileNameData;
	}

	public String get__type() {
		return __type;
	}

	public void set__type(String __type) {
		this.__type = __type;
	}

	public CCWidgetData getCharMapFileData() {
		return charMapFileData;
	}

	public void setCharMapFileData(CCWidgetData charMapFileData) {
		this.charMapFileData = charMapFileData;
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

	public int getItemWidth() {
		return itemWidth;
	}

	public void setItemWidth(int itemWidth) {
		this.itemWidth = itemWidth;
	}

	public int getItemHeight() {
		return itemHeight;
	}

	public void setItemHeight(int itemHeight) {
		this.itemHeight = itemHeight;
	}

	public int getZOrder() {
		return ZOrder;
	}

	public void setZOrder(int zOrder) {
		ZOrder = zOrder;
	}

	public int getActiontag() {
		return actiontag;
	}

	public void setActiontag(int actiontag) {
		this.actiontag = actiontag;
	}

	public String getClassType() {
		return classType;
	}

	public void setClassType(String classType) {
		this.classType = classType;
	}

	public int getColorB() {
		return colorB;
	}

	public void setColorB(int colorB) {
		this.colorB = colorB;
	}

	public int getColorG() {
		return colorG;
	}

	public void setColorG(int colorG) {
		this.colorG = colorG;
	}

	public int getColorR() {
		return colorR;
	}

	public void setColorR(int colorR) {
		this.colorR = colorR;
	}

	public boolean isFlipX() {
		return flipX;
	}

	public void setFlipX(boolean flipX) {
		this.flipX = flipX;
	}

	public boolean isFlipY() {
		return flipY;
	}

	public void setFlipY(boolean flipY) {
		this.flipY = flipY;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public boolean isIgnoreSize() {
		return ignoreSize;
	}

	public void setIgnoreSize(boolean ignoreSize) {
		this.ignoreSize = ignoreSize;
	}

	public String getLayoutParameter() {
		return layoutParameter;
	}

	public void setLayoutParameter(String layoutParameter) {
		this.layoutParameter = layoutParameter;
	}

	public int getOpacity() {
		return opacity;
	}

	public void setOpacity(int opacity) {
		this.opacity = opacity;
	}

	public float getPositionPercentX() {
		return positionPercentX;
	}

	public void setPositionPercentX(float positionPercentX) {
		this.positionPercentX = positionPercentX;
	}

	public float getPositionPercentY() {
		return positionPercentY;
	}

	public void setPositionPercentY(float positionPercentY) {
		this.positionPercentY = positionPercentY;
	}

	public String getStringValue() {
		return stringValue;
	}

	public void setStringValue(String stringValue) {
		this.stringValue = stringValue;
	}

	public String getStartCharMap() {
		return startCharMap;
	}

	public void setStartCharMap(String startCharMap) {
		this.startCharMap = startCharMap;
	}

	public int getPositionType() {
		return positionType;
	}

	public void setPositionType(int positionType) {
		this.positionType = positionType;
	}

	public float getRotation() {
		return rotation;
	}

	public void setRotation(float rotation) {
		this.rotation = rotation;
	}

	public float getScaleX() {
		return scaleX;
	}

	public void setScaleX(float scaleX) {
		this.scaleX = scaleX;
	}

	public float getScaleY() {
		return scaleY;
	}

	public void setScaleY(float scaleY) {
		this.scaleY = scaleY;
	}

	public float getSizePercentX() {
		return sizePercentX;
	}

	public void setSizePercentX(float sizePercentX) {
		this.sizePercentX = sizePercentX;
	}

	public float getSizePercentY() {
		return sizePercentY;
	}

	public void setSizePercentY(float sizePercentY) {
		this.sizePercentY = sizePercentY;
	}

	public int getSizeType() {
		return sizeType;
	}

	public void setSizeType(int sizeType) {
		this.sizeType = sizeType;
	}

	public int getTag() {
		return tag;
	}

	public void setTag(int tag) {
		this.tag = tag;
	}

	public boolean isTouchAble() {
		return touchAble;
	}

	public void setTouchAble(boolean touchAble) {
		this.touchAble = touchAble;
	}

	@Deprecated
	public boolean isUseMergedTexture() {
		return useMergedTexture;
	}

	public void setUseMergedTexture(boolean useMergedTexture) {
		this.useMergedTexture = useMergedTexture;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public String getBackGroundImage() {
		return backGroundImage;
	}

	public void setBackGroundImage(String backGroundImage) {
		this.backGroundImage = backGroundImage;
	}

	public int getBgColorB() {
		return bgColorB;
	}

	public void setBgColorB(int bgColorB) {
		this.bgColorB = bgColorB;
	}

	public int getBgColorG() {
		return bgColorG;
	}

	public void setBgColorG(int bgColorG) {
		this.bgColorG = bgColorG;
	}

	public int getBgColorOpacity() {
		return bgColorOpacity;
	}

	public void setBgColorOpacity(int bgColorOpacity) {
		this.bgColorOpacity = bgColorOpacity;
	}

	public int getBgColorR() {
		return bgColorR;
	}

	public void setBgColorR(int bgColorR) {
		this.bgColorR = bgColorR;
	}

	public int getBgEndColorB() {
		return bgEndColorB;
	}

	public void setBgEndColorB(int bgEndColorB) {
		this.bgEndColorB = bgEndColorB;
	}

	public int getBgEndColorG() {
		return bgEndColorG;
	}

	public void setBgEndColorG(int bgEndColorG) {
		this.bgEndColorG = bgEndColorG;
	}

	public int getBgEndColorR() {
		return bgEndColorR;
	}

	public void setBgEndColorR(int bgEndColorR) {
		this.bgEndColorR = bgEndColorR;
	}

	public int getBgStartColorB() {
		return bgStartColorB;
	}

	public void setBgStartColorB(int bgStartColorB) {
		this.bgStartColorB = bgStartColorB;
	}

	public int getBgStartColorG() {
		return bgStartColorG;
	}

	public void setBgStartColorG(int bgStartColorG) {
		this.bgStartColorG = bgStartColorG;
	}

	public int getBgStartColorR() {
		return bgStartColorR;
	}

	public void setBgStartColorR(int bgStartColorR) {
		this.bgStartColorR = bgStartColorR;
	}

	public int getCapInsetsHeight() {
		return capInsetsHeight;
	}

	public void setCapInsetsHeight(int capInsetsHeight) {
		this.capInsetsHeight = capInsetsHeight;
	}

	public int getCapInsetsWidth() {
		return capInsetsWidth;
	}

	public void setCapInsetsWidth(int capInsetsWidth) {
		this.capInsetsWidth = capInsetsWidth;
	}

	public int getCapInsetsX() {
		return capInsetsX;
	}

	public void setCapInsetsX(int capInsetsX) {
		this.capInsetsX = capInsetsX;
	}

	public int getCapInsetsY() {
		return capInsetsY;
	}

	public void setCapInsetsY(int capInsetsY) {
		this.capInsetsY = capInsetsY;
	}

	public boolean isClipAble() {
		return clipAble;
	}

	public void setClipAble(boolean clipAble) {
		this.clipAble = clipAble;
	}

	public int getColorType() {
		return colorType;
	}

	public void setColorType(int colorType) {
		this.colorType = colorType;
	}

	public int getLayoutType() {
		return layoutType;
	}

	public void setLayoutType(int layoutType) {
		this.layoutType = layoutType;
	}

	public float getVectorX() {
		return vectorX;
	}

	public void setVectorX(float vectorX) {
		this.vectorX = vectorX;
	}

	public float getVectorY() {
		return vectorY;
	}

	public void setVectorY(float vectorY) {
		this.vectorY = vectorY;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public CCWidgetData getFileNameData() {
		return fileNameData;
	}

	public void setFileNameData(CCWidgetData fileNameData) {
		this.fileNameData = fileNameData;
	}

	public String getFontName() {
		return fontName;
	}

	public void setFontName(String fontName) {
		this.fontName = fontName;
	}

	public int getFontSize() {
		return fontSize;
	}

	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}

	public int getFontType() {
		return fontType;
	}

	public void setFontType(int fontType) {
		this.fontType = fontType;
	}

	public String getNormal() {
		return normal;
	}

	public void setNormal(String normal) {
		this.normal = normal;
	}

	public CCWidgetData getNormalData() {
		return normalData;
	}

	public void setNormalData(CCWidgetData normalData) {
		this.normalData = normalData;
	}

	public String getPressed() {
		return pressed;
	}

	public void setPressed(String pressed) {
		this.pressed = pressed;
	}

	public CCWidgetData getPressedData() {
		return pressedData;
	}

	public void setPressedData(CCWidgetData pressedData) {
		this.pressedData = pressedData;
	}

	public String getDisabled() {
		return disabled;
	}

	public void setDisabled(String disabled) {
		this.disabled = disabled;
	}

	public CCWidgetData getDisabledData() {
		return disabledData;
	}

	public void setDisabledData(CCWidgetData disabledData) {
		this.disabledData = disabledData;
	}

	public boolean isScale9Enable() {
		return scale9Enable;
	}

	public void setScale9Enable(boolean scale9Enable) {
		this.scale9Enable = scale9Enable;
	}

	public int getScale9Height() {
		return scale9Height;
	}

	public void setScale9Height(int scale9Height) {
		this.scale9Height = scale9Height;
	}

	public int getScale9Width() {
		return scale9Width;
	}

	public void setScale9Width(int scale9Width) {
		this.scale9Width = scale9Width;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getTextColorB() {
		return textColorB;
	}

	public void setTextColorB(int textColorB) {
		this.textColorB = textColorB;
	}

	public int getTextColorG() {
		return textColorG;
	}

	public void setTextColorG(int textColorG) {
		this.textColorG = textColorG;
	}

	public int getTextColorR() {
		return textColorR;
	}

	public void setTextColorR(int textColorR) {
		this.textColorR = textColorR;
	}

	public int getMaxLength() {
		return maxLength;
	}

	public void setMaxLength(int maxLength) {
		this.maxLength = maxLength;
	}

	public boolean isMaxLengthEnable() {
		return maxLengthEnable;
	}

	public void setMaxLengthEnable(boolean maxLengthEnable) {
		this.maxLengthEnable = maxLengthEnable;
	}

	public boolean isPasswordEnable() {
		return passwordEnable;
	}

	public void setPasswordEnable(boolean passwordEnable) {
		this.passwordEnable = passwordEnable;
	}

	public String getPlaceHolder() {
		return placeHolder;
	}

	public void setPlaceHolder(String placeHolder) {
		this.placeHolder = placeHolder;
	}

	public char getPasswordStyleText() {
		return passwordStyleText;
	}

	public void setPasswordStyleText(char passwordStyleText) {
		this.passwordStyleText = passwordStyleText;
	}

	public int getvAlignment() {
		return vAlignment;
	}

	public void setvAlignment(int vAlignment) {
		this.vAlignment = vAlignment;
	}

	public boolean isTouchScaleEnable() {
		return touchScaleEnable;
	}

	public void setTouchScaleEnable(boolean touchScaleEnable) {
		this.touchScaleEnable = touchScaleEnable;
	}

	public int gethAlignment() {
		return hAlignment;
	}

	public void sethAlignment(int hAlignment) {
		this.hAlignment = hAlignment;
	}

	public int getAreaWidth() {
		return areaWidth;
	}

	public void setAreaWidth(int areaWidth) {
		this.areaWidth = areaWidth;
	}

	public int getAreaHeight() {
		return areaHeight;
	}

	public void setAreaHeight(int areaHeight) {
		this.areaHeight = areaHeight;
	}

	public CCWidgetData getBackGroundImageData() {
		return backGroundImageData;
	}

	public void setBackGroundImageData(CCWidgetData backGroundImageData) {
		this.backGroundImageData = backGroundImageData;
	}

	public boolean isBackGroundScale9Enable() {
		return backGroundScale9Enable;
	}

	public void setBackGroundScale9Enable(boolean backGroundScale9Enable) {
		this.backGroundScale9Enable = backGroundScale9Enable;
	}

	public float getAnchorPointX() {
		return anchorPointX;
	}

	public void setAnchorPointX(float anchorPointX) {
		this.anchorPointX = anchorPointX;
	}

	public float getAnchorPointY() {
		return anchorPointY;
	}

	public void setAnchorPointY(float anchorPointY) {
		this.anchorPointY = anchorPointY;
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
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

	public boolean isBounceEnable() {
		return bounceEnable;
	}

	public void setBounceEnable(boolean bounceEnable) {
		this.bounceEnable = bounceEnable;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public boolean isSelectedState() {
		return selectedState;
	}

	public void setSelectedState(boolean selectedState) {
		this.selectedState = selectedState;
	}

	public CCWidgetData getFrontCrossData() {
		return frontCrossData;
	}

	public void setFrontCrossData(CCWidgetData frontCrossData) {
		this.frontCrossData = frontCrossData;
	}

	public CCWidgetData getFrontCrossDisabledData() {
		return frontCrossDisabledData;
	}

	public void setFrontCrossDisabledData(CCWidgetData frontCrossDisabledData) {
		this.frontCrossDisabledData = frontCrossDisabledData;
	}

	public CCWidgetData getBackGroundBoxSelectedData() {
		return backGroundBoxSelectedData;
	}

	public void setBackGroundBoxSelectedData(
			CCWidgetData backGroundBoxSelectedData) {
		this.backGroundBoxSelectedData = backGroundBoxSelectedData;
	}

	public CCWidgetData getBackGroundBoxDisabledData() {
		return backGroundBoxDisabledData;
	}

	public void setBackGroundBoxDisabledData(
			CCWidgetData backGroundBoxDisabledData) {
		this.backGroundBoxDisabledData = backGroundBoxDisabledData;
	}

	public CCWidgetData getBackGroundBoxData() {
		return backGroundBoxData;
	}

	public void setBackGroundBoxData(CCWidgetData backGroundBoxData) {
		this.backGroundBoxData = backGroundBoxData;
	}

	public CCWidgetData getTextureData() {
		return textureData;
	}

	public void setTextureData(CCWidgetData textureData) {
		this.textureData = textureData;
	}

}
