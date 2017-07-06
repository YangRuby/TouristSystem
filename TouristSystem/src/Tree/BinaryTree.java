package Tree;

import java.util.ArrayList;

public class BinaryTree { // 二叉排序树
	public BTNode root; // 根结点

	public ArrayList<SpotData> preList; // 用于储存先序遍历数据的ArrayList
	public ArrayList<SpotData> inList; // 用于储存中序遍历的ArrayList

	public ArrayList<SpotData> signUpList; // 用于储存已报名景点信息的ArrayList

	public int i; // 用于判断景点编号和景点名称是否有重复
	public int o; // 用于判断输入的游客号在所有游客中是否有重复
	public int sNum; // 景点总数
	public int tNum; // 游客总数

	public BinaryTree() {
		root = null;
		i = 1;
		o = 1;
		sNum = 0;
		tNum = 0;
		preList = new ArrayList<SpotData>();
		inList = new ArrayList<SpotData>();
		signUpList = new ArrayList<SpotData>();
	} // 二叉排序树初始化

	public void clearList() {
		preList = new ArrayList<SpotData>();
		inList = new ArrayList<SpotData>();
		signUpList = new ArrayList<SpotData>();
	} // 清空ArrayList

	public void getNum(BTNode node) {
		if (node != null) {
			sNum++;
			LNode p = node.link;
			while (p != null) {
				tNum++;
				p = p.next;
			}
			getNum(node.lchild);
			getNum(node.rchild);
		}
	} // 计算景点总数和游客总数

	public void findInAllSpot(BTNode node, String num) {
		if (node != null) {
			findInAllSpot(node.lchild, num);
			LNode p = node.link;
			while (p != null) {
				if (num.equals(p.data.num)) {
					signUpList.add(node.data);
				}
				p = p.next;
			}
			findInAllSpot(node.rchild, num);
		}
	} // 在所有景点中查找某个游客

	public BTNode creatTree() {
		BinaryTree BT = new BinaryTree();
		SpotData spot1 = new SpotData("050", "上海迪士尼", "（上海迪士尼的简介）", "370.0", "上海");
		SpotData spot2 = new SpotData("030", "故宫", "（故宫的简介）", "40.0", "北京");
		SpotData spot3 = new SpotData("060", "世界之窗", "（世界之窗的简介）", "200.0", "深圳");
		SpotData spot4 = new SpotData("020", "西湖", "（西湖的简介）", "0.0", "杭州");
		SpotData spot5 = new SpotData("035", "颐和园", "（颐和园的简介）", "20.0", "北京");
		SpotData spot6 = new SpotData("055", "东方明珠塔", "（东方明珠塔的简介）", "170.0", "上海");
		SpotData spot7 = new SpotData("070", "圆明园", "（圆明园的简介）", "25.0", "北京");
		BT.insertNode(BT.root, spot1);
		BT.insertNode(BT.root, spot2);
		BT.insertNode(BT.root, spot3);
		BT.insertNode(BT.root, spot4);
		BT.insertNode(BT.root, spot5);
		BT.insertNode(BT.root, spot6);
		BT.insertNode(BT.root, spot7);
		return BT.root;
	} // 二叉排序树的创建

	public void insertNode(BTNode node, SpotData data) {
		if (root == null) {
			root = new BTNode(data, root);
		} else {
			if (data.num.compareTo(node.data.num) < 0) {
				if (node.lchild == null) {
					node.lchild = new BTNode(data, node);
				} else {
					insertNode(node.lchild, data);
				}
			} else {
				if (node.rchild == null) {
					node.rchild = new BTNode(data, node);
				} else {
					insertNode(node.rchild, data);
				}
			}
		}
	} // 二叉排序树的插入

	public BTNode findNodeByNum(BTNode node, String num) {
		while (node != null) {
			if (num.equals(node.data.num)) {
				return node;
			} else {
				if (num.compareTo(node.data.num) < 0) {
					node = node.lchild;
				} else {
					node = node.rchild;
				}
			}
		}
		return null;
	} // 根据景点编号在二叉排序树中查找

	public void repeat(BTNode node, SpotData data) {
		if (node != null) {
			if (data.num.equals(node.data.num) || data.name.equals(node.data.name)) {
				i = 0;
			} else {
				repeat(node.lchild, data);
				repeat(node.rchild, data);
			}
		}
	} // 判断输入的景点编号和景点名称是否有重复

	public void nameRepeat(BTNode node, String name) {
		if (node != null) {
			if (name.equals(node.data.name)) {
				i = 0;
			} else {
				nameRepeat(node.lchild, name);
				nameRepeat(node.rchild, name);
			}
		}
	} // 判断输入的景点名称是否有重复（用于修改景点）

	public void touristNumRepeat(BTNode node, String num, String name) {
		if (node != null) {
			LNode p = node.link;
			while (p != null) {
				if ((num.equals(p.data.num)) && (!(name.equals(p.data.name)))) {
					o = 0;
				}
				p = p.next;
			}
			touristNumRepeat(node.lchild, num, name);
			touristNumRepeat(node.rchild, num, name);
		}
	} // 判断输入的游客号在所有游客中是否有重复

	public void deleteNode(BTNode node) {
		if (node.lchild == null) {
			if (node.rchild == null) {
				if (node.parent != null) {
					if (node.parent.lchild == node) {
						node.parent.lchild = null;
					} else {
						node.parent.rchild = null;
					}
				} else {
					root = null;
				}
			} else {
				if (node.parent != null) {
					if (node.parent.lchild == node) {
						node.parent.lchild = node.rchild;
					} else {
						node.parent.rchild = node.rchild;
					}
				} else {
					root = node.rchild;
				}
			}
		} else {
			if (node.rchild == null) {
				if (node.parent != null) {
					if (node.parent.lchild == node) {
						node.parent.lchild = node.lchild;
					} else {
						node.parent.rchild = node.lchild;
					}
				} else {
					root = node.lchild;
				}
			} else {
				if (node.parent != null) {
					BTNode p = node.lchild;
					if (p.lchild == null && p.rchild == null) {
						node.data = p.data;
						node.link = p.link;
						node.lchild = null;
						System.out.println("1");
					} else {
						while (p.rchild != null) {
							p = p.rchild;
						}
						node.data = p.data;
						node.link = p.link;
						p.parent.rchild = p.lchild;
					}
				} else {
					BTNode p = node.lchild;
					if (p.lchild == null && p.rchild == null) {
						root.data = p.data;
						root.link = p.link;
						root.lchild = null;
					} else {
						while (p.rchild != null) {
							p = p.rchild;
						}
						root.data = p.data;
						root.link = p.link;
						p.parent.rchild = p.lchild;
					}
				}
			}
		}
	} // 二叉排序树的删除

	public void setName(BTNode node, String name) {
		node.data.name = name;
	} // 修改景点名称

	public void setIntro(BTNode node, String intro) {
		node.data.intro = intro;
	} // 修改景点简介

	public void setPrice(BTNode node, String price) {
		node.data.price = price;
	} // 修改门票价格

	public void setLocat(BTNode node, String locat) {
		node.data.locat = locat;
	} // 修改所在地

	public void preOrder(BTNode node) {
		if (node != null) {
			preList.add(node.data);
			preOrder(node.lchild);
			preOrder(node.rchild);
		}
	} // 先序遍历

	public void inOrder(BTNode node) {
		if (node != null) {
			inOrder(node.lchild);
			inList.add(node.data);
			inOrder(node.rchild);
		}
	} // 中序遍历
}