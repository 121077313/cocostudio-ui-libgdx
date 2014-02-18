# 让CocoStudio变成libgdx的UI编辑器


### WIKI : https://github.com/121077313/cocostudio-ui-libgdx/wiki
### 问答 : https://github.com/121077313/cocostudio-ui-libgdx/wiki/疑难解答



###作者推荐的开发方式
就像demo项目中的out文件夹是外部工程文件.为了方便管理就放在项目目录中.ui编辑器的工程文件也在里面.
开发的时候建议不使用压缩方式处理资源图片.因为最终发布前一定会有多次修改,使用打包的方式会让你来回的打包资源并且调试.
CocoStudioUIEditor 可以很方便的切换使用小图方式还是使用大图方式来处理资源CocoStudioUIEditor的构造函数 TextureAtlas 如果不传入则会以小图方式处理图片资源.
可以在最终完成再去打包图片,并传入TextureAtlas.然后从assets目录中删除小图即可.


###目前已知还存在的问题
* 只支持绝对布局,其他布局也不打算支持.
* 对ScrollPane的属性不是很了解,所以回弹属性存在问题,如果设置不回弹则无法拖拽.滚动区域的设置也无效
* 部分控件的裁剪属性无效,例如ScrollPane
* LoadingBar的实现只是个Image
* Panel的渐变色不了解.目前不支持
* 很诡异,Label的size在libgdx里面和在编辑器里面不一样,例如一个LabelBMFont在编辑器里面的高度看起来是20,但是在libgdx实际运行起来后高度可能为22.这个问题导致了文本显示看起来和编辑器里面有偏差.
目前还无法解决这个问题.
* 编辑器里面的文本有的会显示宋体或者微软雅黑这些东西.但是你得知道.所有的字体文件必须出现在资源文件夹里面.所以当日志打印出类似于找不到宋体字体的时候不要对这点感到奇怪.
* 复选框在cocostudio里面最起码得有2个属性,底图资源和选中资源.是控制选中资源是否显示.但是在libgdx里面则是选中和未选中2个图片.是控制两个图片显示哪个.
* 滑动条,数字标签,列表容器,翻动页面 这4个控件还未支持.
* 动作编辑器编辑出来的效果比编辑器里面看到的效果运行得慢,不清楚是否正常?还没去确定这事.动作编辑器的功能还没去具体测试各项功能.
* 当一个非Panel下面出现子控件的时候,情况会变得复杂点.这个时候设置控件的可见属性为不可见的时候.得注意:真正开启可见属性的方法为 findActor().getParent().setVisible(true); 也就是说 得设置该控件的父控件属性!!


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