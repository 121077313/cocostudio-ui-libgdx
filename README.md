cocostudio-ui-libgdx
====================

Let CocoStudio become libgdx the ui editor



首先,这个想法不是我原创.我所知道的原作者是:https://github.com/bigstupidx/libgdx-cocostudio
他实现了 ui编辑器和动作编辑器的解析.完成度有多少我还不清楚,没细看代码.
我只是觉得他的实现方式不是很好,所以重写ui编辑器的解析部分.
我对cocos2d不熟悉,CocoStudio是为cocos2d开发的编辑器.所以会对一些控件属性理解有误导致bug产生,也希望各位能多多的支出错误.


使用的版本(不表示只支持该版本,而是我的使用版本):

libgdx:0.9.9
CocoStudio:v1.2.0.1  http://www.cocostudio.org

工作原理:CocoStudio 编辑器生成json,通过解析json创建libgdx的原生控件.


目前支持的CocoStudio 控件与实现:
ImageView :Image
Button     :ImageButton
LabelBMFont :Label
TextField    :TextField
Label       :Label
Panel       :Table

用得最多的也就这些,其他的后续添加支持.
  
-------------------------------

cocostudio-ui-libgdx的优点:
全部使用的是libgdx的原生控件,actor group image button table 这些.不会产生新学习成本.
使用起来简单易懂.


-------------------------------
从CocoStudio 编辑器迁移到libgdx的注意点:
CocoStudio 是为cocos2d而生,他一些设定需要注意:

1.文字,CocoStudio的控件用到自定义字体的只有LabelBMFont,其他的 TextField Label 和 button 的文本都只支持ttf文件

2.交互属性对应着libgdx 的Touchable 属性.

3.一定要确保一个界面使用到的资源在同一个贴图文件内.或者说是把这个界面使用到的图片打包到一个文件里面.

4.控件名字不要重复

5.导出的时候会有选择是否打包成一张图片,如果选择是.那么在构建CocoStudioUIEditor对象的时候 就要传入对应的TextureAtlas
一个界面=一个json文件+TextureAtlas . 如果不打包,就会根据目录去查找文件. 选择打包方式导出 文件后缀为.ExportJson 只是后缀名称变了.

6.为了能让BitmapFont 使用预加载,所以 BitmapFont 是传入CocoStudioUIEditor 而不是自动创建.

7.CocoStudio 的ttf文件没有记录相对目录,所以无法获取到ttf,因此ttf文件也是由CocoStudioUIEditor传入.已经对使用ttf字体的文本过滤处理.不必担心显示的文字有重复问题.

8.如果没有用到文字显示,可以传入null.当查找不到字体文件的时候会采用libgdx自带字体.new BitmapFont();

9.Button用的libgdx ImageButton实现. CocoStudio中禁用图片 得设置 ImageButton实现 isDisabled = true.

10.最需要注意的就是libgdx 项目中资源目录与CocoStudio 资源目录结构问题了.例如,控件内显示图片的文件路径为:res/img/xx.jpg
到了libgdx这边则是去查找img/xx的纹理.过滤掉了 img的父文件夹与.jpg后缀.


--------------------------------
使用篇

1.创建

		CocoStudioUIEditor editer = new CocoStudioUIEditor(
				Gdx.files.internal("res/login.ExportJson"), Assets.gui, null,
				null);

///因为没有使用到文本,ttf 和 bitmapFont 传入null

		Group group = editer.createGroup();   //创建Group,界面所有元素都已经存在于这个Group里面了
		
		addActor(group);   //添加group 到舞台显示.


2.获取控件
Actor login = editer.findActor("login");//根据控件名字查找

3.添加自己的业务功能

login实际是一个Button,点击跳转到其他场景.所以要添加点击事件.

		login.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {

				System.out.println("click LOGIN");
				super.clicked(event, x, y);
			}
		});


以上则为demo的实际使用情况.和平时开发界面步骤 可能只是把初始化和设置属性的代码变成了 findActor 这一个简单的方法.


