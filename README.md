# 让CocoStudio变成libgdx的UI编辑器

##交流Q群:341972448

### WIKI : https://github.com/121077313/cocostudio-ui-libgdx/wiki
### 问答 : https://github.com/121077313/cocostudio-ui-libgdx/wiki/疑难解答


###移植案例,更多请看WIKI!
![](http://dl2.iteye.com/upload/attachment/0093/8165/c3a16900-e85e-3cc4-b57f-690c5cb3ec75.jpg)


###目前已知还存在的问题
* 只支持绝对布局,其他布局也不打算支持.
* 对ScrollPane的属性不是很了解,所以回弹属性存在问题,如果设置不回弹则无法拖拽.滚动区域的设置也无效
* 部分控件的裁剪属性无效,例如ScrollPane
* LoadingBar的实现只是个Image
* Panel的渐变色不了解.目前不支持
* 复选框在cocostudio里面最起码得有2个属性,底图资源和选中资源.是控制选中资源是否显示.但是在libgdx里面则是选中和未选中2个图片.是控制两个图片显示哪个.
* 滑动条,数字标签,列表容器,翻动页面 这4个控件还未支持.
* 动作编辑器编辑出来的效果比编辑器里面看到的效果运行得慢,不清楚是否正常?还没去确定这事.动作编辑器的功能还没去具体测试各项功能.
* TextField使用ttf 还存在一些问题,另外如果设置了锚点大于0 位置会产生偏差,还未确定原因.

###更新记录

2014.2.12 
* 更新demo.zip,展示了如何使用CocoStudioUIEditor 创建一个界面,如何获取控件 添加事件.

2014.2.13 
* 整合的Demo项目,内有多种使用场景和案例,后续也会继续更新demo. 
* 处理了UIEditor 的一些BUG.
* 添加了ScrollPane 支持
* 添加问答wiki
* 添加CheckBox支持,CheckBox只有选中和未选中2个图片.
* 修复了锚点问题,现在坐标已经能完全对齐
* 修复渲染层级问题,能正常的根据渲染层级进行zindex排序
* 暂时去掉了Touchable属性,还没能很好解决不同控件覆盖事件传递等问题
* 修改了demo项目,按任意键来切换查看不同场景
* 移植了 UI编辑器示例项目:DemoHead_UI,DemoLogin,DemoMap,DemoShop,SampleChangeEquip. 部分项目还未完全移植成功
* 修复了TextField的MessageText属性 

2014.2.14
* 添加了动画模式的解析,增加了对应demo  SampleUIAnimation,但是还不清楚为什么实际动作比编辑器里面看到的动作慢半拍.
* 重构了代码
* 添加了LoadingBar控件,暂时使用Image代替实现...也就是说LoadingBar就是一个图片.仅此而已.
* CocoStuido的全部Demo移植完毕.一共6个.

2014.2.15
* 修复Touchable属性
* 修复渲染层级问题
* 修复字体颜色问题
* Panel添加填充颜色属性,不支持渐变色

2014.2.18
* 修改WidgetParser 下父控件与子控件的属性关系

2014.3.2
* 修复Label位置问题 以及使用ttf字体 修改Text 显示不了文字问题.TextField也是使用ttf字体 也会同样的这种问题,还未修复
* 添加默认字体参数,当找不到字体.例如微软雅黑,就去尝试使用默认字体创建文本.
* CCLabel的实现采用TTFLabel继承了libgdx的Label,只是添加了字体大小等属性
* CCPanel的背景图片图纸恢复成为剧中显示而不是平铺,与编辑器显示保持一致,避免因为图片大小和Panel大小不一致产生错误的错觉.

2014.3.3
* @爆发的妞 提供.9图片支持

2014.3.4
* 修复CheckBox显示问题

2014.3.4
* wiki添加重写/添加控件实现的方法
* 添加数字标签控件的实现,目前只支持0-9的数字,首字符设置也无效.
* 包重命名

2014.3.14
* 修正Label标签文本对齐错误

2014.6.27
* @xiaozc 提供读取资源文件兼容方式.