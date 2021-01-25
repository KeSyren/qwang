package leetcode.datastructure;

public class Outter {

	private Inner inner = null;

	public Outter() {}

	public Inner getInnerInstance() {
		if (inner == null)
			inner = new Inner();
		return inner;
	}

	class Inner {
		public Inner() {
			System.out.print("Inner ");
		}
	}

	public static void main(String[] args) {
		Outter outter  = new Outter();
		Outter.Inner inner = outter.new Inner();
		
		
		Outter.Inner inner1 = outter.getInnerInstance();
	}

}
