package Tree;

public class SpotData { //景点信息
	public String num; //景点编号
	public String name; //景点名称
	public String intro; //景点简介
	public String price; //门票价格
	public String locat; //所在地

	public SpotData(String num, String name, String intro, String price, String locat) {
		this.num = num;
		this.name = name;
		this.intro = intro;
		this.price = price;
		this.locat = locat;
	}
}