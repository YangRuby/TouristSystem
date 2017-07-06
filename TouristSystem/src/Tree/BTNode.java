package Tree;

import java.util.ArrayList;

public class BTNode { //景点信息结点
	BTNode parent; //指向双亲结点
	BTNode lchild; //左子树
	BTNode rchild; //右子树
	public SpotData data; //景点信息
	public LNode link; //指向游客信息单链表

	public ArrayList<TouristData> touristList; //用于储存该景点游客信息的ArrayList

	public int i; //用于判断在该景点是否有重复报名 或 是否删除成功

	public BTNode(SpotData data, BTNode node) {
		this.parent = node;
		this.lchild = null;
		this.rchild = null;
		this.data = new SpotData(data.num, data.name, data.intro, data.price, data.locat);
		this.link = null;
		i = 1;
		touristList = new ArrayList<TouristData>();
	} //景点信息结点的初始化

	public int getTouristNum() {
		int n = 0;
		LNode p = this.link;
		while (p != null) {
			n++;
			p = p.next;
		}
		return n;
	} //计算该景点的游客人数

	public void clearList() {
		touristList = new ArrayList<TouristData>();
	} //清空储存该景点游客信息的ArrayList

	public void creatList() {
		LNode p = this.link;
		while (p != null) {
			touristList.add(p.data);
			p = p.next;
		}
	} //储存该景点游客信息的ArrayList的插入

	public void signUpRepeat(String num) {
		LNode p = this.link;
		while (p != null) {
			if (num.equals(p.data.num)) {
				i = 0;
			}
			p = p.next;
		}
	} //判断在该景点是否有重复报名

	public void insertLink(TouristData data) {
		if (this.link == null) {
			this.link = new LNode(data);
		} else {
			LNode p = this.link;
			while (p.next != null) {
				p = p.next;
			}
			p.next = new LNode(data);
		}
	} //游客信息单链表的插入

	public void deleteLink(String num) {
		if (num.equals(this.link.data.num)) {
			this.link = this.link.next;
		} else {
			LNode p = this.link.next;
			LNode q = this.link;
			while (p != null) {
				if (num.equals(p.data.num)) {
					q.next = p.next;
					i = 0; //若删除成功，把i置成0
				}
				p = p.next;
				q = q.next;
			}
		}
	} //游客信息单链表的删除
}