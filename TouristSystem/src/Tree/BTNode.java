package Tree;

import java.util.ArrayList;

public class BTNode { //������Ϣ���
	BTNode parent; //ָ��˫�׽��
	BTNode lchild; //������
	BTNode rchild; //������
	public SpotData data; //������Ϣ
	public LNode link; //ָ���ο���Ϣ������

	public ArrayList<TouristData> touristList; //���ڴ���þ����ο���Ϣ��ArrayList

	public int i; //�����ж��ڸþ����Ƿ����ظ����� �� �Ƿ�ɾ���ɹ�

	public BTNode(SpotData data, BTNode node) {
		this.parent = node;
		this.lchild = null;
		this.rchild = null;
		this.data = new SpotData(data.num, data.name, data.intro, data.price, data.locat);
		this.link = null;
		i = 1;
		touristList = new ArrayList<TouristData>();
	} //������Ϣ���ĳ�ʼ��

	public int getTouristNum() {
		int n = 0;
		LNode p = this.link;
		while (p != null) {
			n++;
			p = p.next;
		}
		return n;
	} //����þ�����ο�����

	public void clearList() {
		touristList = new ArrayList<TouristData>();
	} //��մ���þ����ο���Ϣ��ArrayList

	public void creatList() {
		LNode p = this.link;
		while (p != null) {
			touristList.add(p.data);
			p = p.next;
		}
	} //����þ����ο���Ϣ��ArrayList�Ĳ���

	public void signUpRepeat(String num) {
		LNode p = this.link;
		while (p != null) {
			if (num.equals(p.data.num)) {
				i = 0;
			}
			p = p.next;
		}
	} //�ж��ڸþ����Ƿ����ظ�����

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
	} //�ο���Ϣ������Ĳ���

	public void deleteLink(String num) {
		if (num.equals(this.link.data.num)) {
			this.link = this.link.next;
		} else {
			LNode p = this.link.next;
			LNode q = this.link;
			while (p != null) {
				if (num.equals(p.data.num)) {
					q.next = p.next;
					i = 0; //��ɾ���ɹ�����i�ó�0
				}
				p = p.next;
				q = q.next;
			}
		}
	} //�ο���Ϣ�������ɾ��
}