package homework;

public class LineSlope {
	double xFirst, xSecond, yFirst, ySecond, slope;
	public void set_coordinates(double x1, double y1, double x2, double y2) {
		xFirst=x1;
		xSecond=x2;
		yFirst=y1;
		ySecond=y2;
	}
	public void calculate_slope() {
		slope=(ySecond-yFirst)/(xSecond-xFirst);
	}
	public void display_slope() {
		System.out.println(slope);
	}
	public static void main(String[]args) {
		LineSlope runner = new LineSlope();
		runner.set_coordinates(3, 3, 7, 11);
		runner.calculate_slope();
		runner.display_slope();
		
		runner.set_coordinates(0, -2, -4, 1);
		runner.calculate_slope();
		runner.display_slope();
	}
}
