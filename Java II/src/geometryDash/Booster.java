package geometryDash;

public class Booster extends GeometryObject{

	public Booster(int x, int y, int w, int h, String imgName) {
		super(x, y, w, h, imgName);
	}
	public int getType() {
		return 2;
	}
}
