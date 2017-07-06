package Tree;

import java.util.ArrayList;

public class BinaryTree { // ����������
	public BTNode root; // �����

	public ArrayList<SpotData> preList; // ���ڴ�������������ݵ�ArrayList
	public ArrayList<SpotData> inList; // ���ڴ������������ArrayList

	public ArrayList<SpotData> signUpList; // ���ڴ����ѱ���������Ϣ��ArrayList

	public int i; // �����жϾ����ź;��������Ƿ����ظ�
	public int o; // �����ж�������οͺ��������ο����Ƿ����ظ�
	public int sNum; // ��������
	public int tNum; // �ο�����

	public BinaryTree() {
		root = null;
		i = 1;
		o = 1;
		sNum = 0;
		tNum = 0;
		preList = new ArrayList<SpotData>();
		inList = new ArrayList<SpotData>();
		signUpList = new ArrayList<SpotData>();
	} // ������������ʼ��

	public void clearList() {
		preList = new ArrayList<SpotData>();
		inList = new ArrayList<SpotData>();
		signUpList = new ArrayList<SpotData>();
	} // ���ArrayList

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
	} // ���㾰���������ο�����

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
	} // �����о����в���ĳ���ο�

	public BTNode creatTree() {
		BinaryTree BT = new BinaryTree();
		SpotData spot1 = new SpotData("050", "�Ϻ���ʿ��", "���Ϻ���ʿ��ļ�飩", "370.0", "�Ϻ�");
		SpotData spot2 = new SpotData("030", "�ʹ�", "���ʹ��ļ�飩", "40.0", "����");
		SpotData spot3 = new SpotData("060", "����֮��", "������֮���ļ�飩", "200.0", "����");
		SpotData spot4 = new SpotData("020", "����", "�������ļ�飩", "0.0", "����");
		SpotData spot5 = new SpotData("035", "�ú�԰", "���ú�԰�ļ�飩", "20.0", "����");
		SpotData spot6 = new SpotData("055", "����������", "�������������ļ�飩", "170.0", "�Ϻ�");
		SpotData spot7 = new SpotData("070", "Բ��԰", "��Բ��԰�ļ�飩", "25.0", "����");
		BT.insertNode(BT.root, spot1);
		BT.insertNode(BT.root, spot2);
		BT.insertNode(BT.root, spot3);
		BT.insertNode(BT.root, spot4);
		BT.insertNode(BT.root, spot5);
		BT.insertNode(BT.root, spot6);
		BT.insertNode(BT.root, spot7);
		return BT.root;
	} // �����������Ĵ���

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
	} // �����������Ĳ���

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
	} // ���ݾ������ڶ����������в���

	public void repeat(BTNode node, SpotData data) {
		if (node != null) {
			if (data.num.equals(node.data.num) || data.name.equals(node.data.name)) {
				i = 0;
			} else {
				repeat(node.lchild, data);
				repeat(node.rchild, data);
			}
		}
	} // �ж�����ľ����ź;��������Ƿ����ظ�

	public void nameRepeat(BTNode node, String name) {
		if (node != null) {
			if (name.equals(node.data.name)) {
				i = 0;
			} else {
				nameRepeat(node.lchild, name);
				nameRepeat(node.rchild, name);
			}
		}
	} // �ж�����ľ��������Ƿ����ظ��������޸ľ��㣩

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
	} // �ж�������οͺ��������ο����Ƿ����ظ�

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
	} // ������������ɾ��

	public void setName(BTNode node, String name) {
		node.data.name = name;
	} // �޸ľ�������

	public void setIntro(BTNode node, String intro) {
		node.data.intro = intro;
	} // �޸ľ�����

	public void setPrice(BTNode node, String price) {
		node.data.price = price;
	} // �޸���Ʊ�۸�

	public void setLocat(BTNode node, String locat) {
		node.data.locat = locat;
	} // �޸����ڵ�

	public void preOrder(BTNode node) {
		if (node != null) {
			preList.add(node.data);
			preOrder(node.lchild);
			preOrder(node.rchild);
		}
	} // �������

	public void inOrder(BTNode node) {
		if (node != null) {
			inOrder(node.lchild);
			inList.add(node.data);
			inOrder(node.rchild);
		}
	} // �������
}