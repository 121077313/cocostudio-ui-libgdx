package org.freyja.libgdx.cocos.creator.ui.model;

import java.util.List;
import java.util.Map;

import org.freyja.libgdx.cocostudio.ui.model.Size;

public class AANode extends BaseNode {

	public int __id__;

	public	String _name;

	AANode scene;

	AANode _parent;

	Vec2 _anchorPoint;

	Size _contentSize;

	int _rotationX;
	int _rotationY;
	float _scaleX;
	float _scaleY;
	// 父节点
	public AANode node;

	public List<AANode> _children;

	public List<AANode> _components;
	
	public Map<String,AANode> componentMaps;

	public int get__id__() {
		return __id__;
	}

	public void set__id__(int __id__) {
		this.__id__ = __id__;
	}

	public String get_name() {
		return _name;
	}

	public void set_name(String _name) {
		this._name = _name;
	}

	public AANode getScene() {
		return scene;
	}

	public void setScene(AANode scene) {
		this.scene = scene;
	}

	public AANode get_parent() {
		return _parent;
	}

	public void set_parent(AANode _parent) {
		this._parent = _parent;
	}

	public Vec2 get_anchorPoint() {
		return _anchorPoint;
	}

	public void set_anchorPoint(Vec2 _anchorPoint) {
		this._anchorPoint = _anchorPoint;
	}

	public Size get_contentSize() {
		return _contentSize;
	}

	public void set_contentSize(Size _contentSize) {
		this._contentSize = _contentSize;
	}

	public int get_rotationX() {
		return _rotationX;
	}

	public void set_rotationX(int _rotationX) {
		this._rotationX = _rotationX;
	}

	public int get_rotationY() {
		return _rotationY;
	}

	public void set_rotationY(int _rotationY) {
		this._rotationY = _rotationY;
	}

	public float get_scaleX() {
		return _scaleX;
	}

	public void set_scaleX(float _scaleX) {
		this._scaleX = _scaleX;
	}

	public float get_scaleY() {
		return _scaleY;
	}

	public void set_scaleY(float _scaleY) {
		this._scaleY = _scaleY;
	}

	public AANode getNode() {
		return node;
	}

	public void setNode(AANode node) {
		this.node = node;
	}

	public List<AANode> get_children() {
		return _children;
	}

	public void set_children(List<AANode> _children) {
		this._children = _children;
	}

	public List<AANode> get_components() {
		return _components;
	}

	public void set_components(List<AANode> _components) {
		this._components = _components;
	}
	
	
	

}
