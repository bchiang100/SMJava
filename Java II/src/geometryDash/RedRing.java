package geometryDash;

public class RedRing extends GeometryObject{

	public RedRing(int x, int y, int w, int h, String imgName) {
		super(x, y, w, h, imgName);
	}
	public int getType() {
		return 5;
	}
}