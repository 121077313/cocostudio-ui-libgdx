package org.freyja.libgdx.cocostudio.ui.model;

import java.util.List;

/**
 * 控件
 * 
 * @author i see
 * 
 */
public class ObjectData {

	int FontSize;

	String ButtonText;

	CColor TextColor;

	String PlaceHolderText;

	boolean IsCustomSize;

	CColor SingleColor;

	int ComboBoxIndex;

	FileData FileData;

	FileData ImageFileData;

	FileData DisabledFileData;

	FileData PressedFileData;

	FileData NormalFileData;

	int ProgressInfo;

	int PercentInfo;

	boolean VisibleForFrame = true;

	int Alpha;

	int ZOrder;

	boolean FlipX;

	boolean FlipY;

	boolean Scale9Enable;

	float Scale9Width;

	float Scale9Height;

	boolean TouchEnable = false;

	FileData FontResource;

	int Tag;

	Size PrePosition;

	float Rotation;

	Size PreSize;

	float LeftMargin;

	float RightMargin;

	float TopMargin;

	float BottomMargin;

	List<ObjectData> Children;

	int ActionTag;

	Size Position;

	Scale Scale;

	Scale AnchorPoint;

	CColor CColor;

	Size Size;

	String FrameEvent;

	String Name;

	String ctype;

	boolean ClipAble;

	int BackColorAlpha;

	String LabelText;
	FileData LabelBMFontFile_CNB;

	boolean MaxLengthEnable;
	int MaxLengthText;
	boolean PasswordEnable;

	char PasswordStyleText;

	String HorizontalAlignmentType;

	String VerticalAlignmentType;

	FileData NormalBackFileData;
	FileData PressedBackFileData;
	FileData DisableBackFileData;
	FileData NodeNormalFileData;
	FileData NodeDisableFileData;

	boolean DisplayState = false;

	boolean IsBounceEnabled;

	Size InnerNodeSize;

	String ScrollDirectionType;

	//
	FileData BackGroundData;

	FileData ProgressBarData;

	FileData BallNormalData;

	FileData BallPressedData;

	FileData BallDisabledData;

	String CallBackType;
	
	String CallBackName;

	
	
	public String getCallBackType() {
		return CallBackType;
	}

	public void setCallBackType(String callBackType) {
		CallBackType = callBackType;
	}

	public String getCallBackName() {
		return CallBackName;
	}

	public void setCallBackName(String callBackName) {
		CallBackName = callBackName;
	}

	public int getPercentInfo() {
		return PercentInfo;
	}

	public void setPercentInfo(int percentInfo) {
		PercentInfo = percentInfo;
	}

	public FileData getBackGroundData() {
		return BackGroundData;
	}

	public void setBackGroundData(FileData backGroundData) {
		BackGroundData = backGroundData;
	}

	public FileData getProgressBarData() {
		return ProgressBarData;
	}

	public void setProgressBarData(FileData progressBarData) {
		ProgressBarData = progressBarData;
	}

	public FileData getBallNormalData() {
		return BallNormalData;
	}

	public void setBallNormalData(FileData ballNormalData) {
		BallNormalData = ballNormalData;
	}

	public FileData getBallPressedData() {
		return BallPressedData;
	}

	public void setBallPressedData(FileData ballPressedData) {
		BallPressedData = ballPressedData;
	}

	public FileData getBallDisabledData() {
		return BallDisabledData;
	}

	public void setBallDisabledData(FileData ballDisabledData) {
		BallDisabledData = ballDisabledData;
	}

	public boolean isIsBounceEnabled() {
		return IsBounceEnabled;
	}

	public void setIsBounceEnabled(boolean isBounceEnabled) {
		IsBounceEnabled = isBounceEnabled;
	}

	public Size getInnerNodeSize() {
		return InnerNodeSize;
	}

	public void setInnerNodeSize(Size innerNodeSize) {
		InnerNodeSize = innerNodeSize;
	}

	public String getScrollDirectionType() {
		return ScrollDirectionType;
	}

	public void setScrollDirectionType(String scrollDirectionType) {
		ScrollDirectionType = scrollDirectionType;
	}

	public boolean isDisplayState() {
		return DisplayState;
	}

	public void setDisplayState(boolean displayState) {
		DisplayState = displayState;
	}

	public FileData getNormalBackFileData() {
		return NormalBackFileData;
	}

	public void setNormalBackFileData(FileData normalBackFileData) {
		NormalBackFileData = normalBackFileData;
	}

	public FileData getPressedBackFileData() {
		return PressedBackFileData;
	}

	public void setPressedBackFileData(FileData pressedBackFileData) {
		PressedBackFileData = pressedBackFileData;
	}

	public FileData getDisableBackFileData() {
		return DisableBackFileData;
	}

	public void setDisableBackFileData(FileData disableBackFileData) {
		DisableBackFileData = disableBackFileData;
	}

	public FileData getNodeNormalFileData() {
		return NodeNormalFileData;
	}

	public void setNodeNormalFileData(FileData nodeNormalFileData) {
		NodeNormalFileData = nodeNormalFileData;
	}

	public FileData getNodeDisableFileData() {
		return NodeDisableFileData;
	}

	public void setNodeDisableFileData(FileData nodeDisableFileData) {
		NodeDisableFileData = nodeDisableFileData;
	}

	public String getHorizontalAlignmentType() {
		return HorizontalAlignmentType;
	}

	public void setHorizontalAlignmentType(String horizontalAlignmentType) {
		HorizontalAlignmentType = horizontalAlignmentType;
	}

	public String getVerticalAlignmentType() {
		return VerticalAlignmentType;
	}

	public void setVerticalAlignmentType(String verticalAlignmentType) {
		VerticalAlignmentType = verticalAlignmentType;
	}

	public int getFontSize() {
		return FontSize;
	}

	public void setFontSize(int fontSize) {
		FontSize = fontSize;
	}

	public CColor getSingleColor() {
		return SingleColor;
	}

	public void setSingleColor(CColor singleColor) {
		SingleColor = singleColor;
	}

	public FileData getImageFileData() {
		return ImageFileData;
	}

	public void setImageFileData(FileData imageFileData) {
		ImageFileData = imageFileData;
	}

	public FileData getFileData() {
		return FileData;
	}

	public void setFileData(FileData fileData) {
		FileData = fileData;
	}

	public int getZOrder() {
		return ZOrder;
	}

	public void setZOrder(int zOrder) {
		ZOrder = zOrder;
	}

	public String getPlaceHolderText() {
		return PlaceHolderText;
	}

	public void setPlaceHolderText(String placeHolderText) {
		PlaceHolderText = placeHolderText;
	}

	public boolean isIsCustomSize() {
		return IsCustomSize;
	}

	public void setIsCustomSize(boolean isCustomSize) {
		IsCustomSize = isCustomSize;
	}

	public int getMaxLengthText() {
		return MaxLengthText;
	}

	public void setMaxLengthText(int maxLengthText) {
		MaxLengthText = maxLengthText;
	}

	public String getButtonText() {
		return ButtonText;
	}

	public void setButtonText(String buttonText) {
		ButtonText = buttonText;
	}

	public CColor getTextColor() {
		return TextColor;
	}

	public void setTextColor(CColor textColor) {
		TextColor = textColor;
	}

	public FileData getDisabledFileData() {
		return DisabledFileData;
	}

	public void setDisabledFileData(FileData disabledFileData) {
		DisabledFileData = disabledFileData;
	}

	public boolean isFlipX() {
		return FlipX;
	}

	public void setFlipX(boolean flipX) {
		FlipX = flipX;
	}

	public boolean isMaxLengthEnable() {
		return MaxLengthEnable;
	}

	public void setMaxLengthEnable(boolean maxLengthEnable) {
		MaxLengthEnable = maxLengthEnable;
	}

	public boolean isPasswordEnable() {
		return PasswordEnable;
	}

	public void setPasswordEnable(boolean passwordEnable) {
		PasswordEnable = passwordEnable;
	}

	public char getPasswordStyleText() {
		return PasswordStyleText;
	}

	public void setPasswordStyleText(char passwordStyleText) {
		PasswordStyleText = passwordStyleText;
	}

	public boolean isFlipY() {
		return FlipY;
	}

	public void setFlipY(boolean flipY) {
		FlipY = flipY;
	}

	public int getAlpha() {
		return Alpha;
	}

	public void setAlpha(int alpha) {
		Alpha = alpha;
	}

	public FileData getPressedFileData() {
		return PressedFileData;
	}

	public void setPressedFileData(FileData pressedFileData) {
		PressedFileData = pressedFileData;
	}

	public FileData getNormalFileData() {
		return NormalFileData;
	}

	public void setNormalFileData(FileData normalFileData) {
		NormalFileData = normalFileData;
	}

	public float getScale9Width() {
		return Scale9Width;
	}

	public void setScale9Width(float scale9Width) {
		Scale9Width = scale9Width;
	}

	public float getScale9Height() {
		return Scale9Height;
	}

	public void setScale9Height(float scale9Height) {
		Scale9Height = scale9Height;
	}

	public boolean isTouchEnable() {
		return TouchEnable;
	}

	public void setTouchEnable(boolean touchEnable) {
		TouchEnable = touchEnable;
	}

	public boolean isClipAble() {
		return ClipAble;
	}

	public void setClipAble(boolean clipAble) {
		ClipAble = clipAble;
	}

	public boolean isVisibleForFrame() {
		return VisibleForFrame;
	}

	public void setVisibleForFrame(boolean visibleForFrame) {
		VisibleForFrame = visibleForFrame;
	}

	public int getTag() {
		return Tag;
	}

	public void setTag(int tag) {
		Tag = tag;
	}

	public int getProgressInfo() {
		return ProgressInfo;
	}

	public void setProgressInfo(int progressInfo) {
		ProgressInfo = progressInfo;
	}

	public Size getPrePosition() {
		return PrePosition;
	}

	public void setPrePosition(Size prePosition) {
		PrePosition = prePosition;
	}

	public Size getPreSize() {
		return PreSize;
	}

	public void setPreSize(Size preSize) {
		PreSize = preSize;
	}

	public float getLeftMargin() {
		return LeftMargin;
	}

	public void setLeftMargin(float leftMargin) {
		LeftMargin = leftMargin;
	}

	public float getRightMargin() {
		return RightMargin;
	}

	public void setRightMargin(float rightMargin) {
		RightMargin = rightMargin;
	}

	public float getTopMargin() {
		return TopMargin;
	}

	public void setTopMargin(float topMargin) {
		TopMargin = topMargin;
	}

	public float getBottomMargin() {
		return BottomMargin;
	}

	public void setBottomMargin(float bottomMargin) {
		BottomMargin = bottomMargin;
	}

	public List<ObjectData> getChildren() {
		return Children;
	}

	public void setChildren(List<ObjectData> children) {
		Children = children;
	}

	public int getActionTag() {
		return ActionTag;
	}

	public void setActionTag(int actionTag) {
		ActionTag = actionTag;
	}

	public Size getPosition() {
		return Position;
	}

	public void setPosition(Size position) {
		Position = position;
	}

	public Scale getScale() {
		return Scale;
	}

	public void setScale(Scale scale) {
		Scale = scale;
	}

	public Scale getAnchorPoint() {
		return AnchorPoint;
	}

	public void setAnchorPoint(Scale anchorPoint) {
		AnchorPoint = anchorPoint;
	}

	public CColor getCColor() {
		return CColor;
	}

	public void setCColor(CColor cColor) {
		CColor = cColor;
	}

	public Size getSize() {
		return Size;
	}

	public void setSize(Size size) {
		Size = size;
	}

	public String getFrameEvent() {
		return FrameEvent;
	}

	public void setFrameEvent(String frameEvent) {
		FrameEvent = frameEvent;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getCtype() {
		return ctype;
	}

	public void setCtype(String ctype) {
		this.ctype = ctype;
	}

	public int getBackColorAlpha() {
		return BackColorAlpha;
	}

	public void setBackColorAlpha(int backColorAlpha) {
		BackColorAlpha = backColorAlpha;
	}

	public boolean isScale9Enable() {
		return Scale9Enable;
	}

	public void setScale9Enable(boolean scale9Enable) {
		Scale9Enable = scale9Enable;
	}

	public float getRotation() {
		return Rotation;
	}

	public void setRotation(float rotation) {
		Rotation = rotation;
	}

	public String getLabelText() {
		return LabelText;
	}

	public void setLabelText(String labelText) {
		LabelText = labelText;
	}

	public FileData getLabelBMFontFile_CNB() {
		return LabelBMFontFile_CNB;
	}

	public void setLabelBMFontFile_CNB(FileData labelBMFontFile_CNB) {
		LabelBMFontFile_CNB = labelBMFontFile_CNB;
	}

	public FileData getFontResource() {
		return FontResource;
	}

	public void setFontResource(FileData fontResource) {
		FontResource = fontResource;
	}

	public int getComboBoxIndex() {
		return ComboBoxIndex;
	}

	public void setComboBoxIndex(int comboBoxIndex) {
		ComboBoxIndex = comboBoxIndex;
	}

}
