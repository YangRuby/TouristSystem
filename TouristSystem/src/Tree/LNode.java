package Tree;

public class LNode { //�ο���Ϣ���
	public TouristData data; //�ο���Ϣ
	public LNode next; //ָ����һ���ο���Ϣ���

	public LNode(TouristData data) {
		this.data = new TouristData(data.num, data.name, data.sex, data.age, data.origin);
		this.next = null;
	}
}