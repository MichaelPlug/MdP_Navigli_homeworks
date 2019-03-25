public class Rettangolo {

	private int x1, x2, y1, y2;
	private Colore colore;
	
	public class TestRettangolo {

		private Rettangolo ret;

		public TestRettangolo () {
			ret = new Rettangolo (10, 20);
		}
		
		public void test () {
			System.out.println(ret.toString());
			ret.trasla(-5, 10);
			System.out.println(ret.toString());
		}
		
		public static void main (String args []) {
			TestRettangolo r = new TestRettangolo();
			r.test();
		}
	}
	
	public class Colore {

		private final int NERO = 0;
		private final int BIANCO = 255;
		private int r;
		private int g;
		private int b;
		
		public Colore (int r, int g, int b) {
		setNero();
		}
		
		public void setBianco() {
		r=BIANCO;
		g=BIANCO;
		b=BIANCO;
		}
		
		public void setNero() {
		r=NERO;
		g=NERO;
		b=NERO;
		}
		
		public void set(int r, int g, int b) {
		this.r=r;
		this.g=g;
		this.b=b;
		}

	}
	
	public Rettangolo(int x, int y) {
		x1 = 0;
		x2 = x;
		y1 = 0;
		y2 = y;
		colore = new Colore (0, 0, 0);
	}
	
	public void trasla (int x, int y) {
		x1 += x;
		x2 += x;
		y1 += y;
		y2 += y;
	}
	
	public String toString () {
		return ("("+x2+","+y1+")->("+x1+","+ y2 +")");
	}
}
	
