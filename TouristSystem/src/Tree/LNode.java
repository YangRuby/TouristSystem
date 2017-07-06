package Tree;

public class LNode { //游客信息结点
	public TouristData data; //游客信息
	public LNode next; //指向下一个游客信息结点

	public LNode(TouristData data) {
		this.data = new TouristData(data.num, data.name, data.sex, data.age, data.origin);
		this.next = null;
	}
}