/**
 * 
 */
package Chuong1;

import java.util.Scanner;

/**
 * 
 */
@FunctionalInterface
interface DiDoiDiem{
    Diem2D diDoi(Diem2D point);
}
public class Diem2D {
	public static Scanner scanner = new Scanner(System.in);
	public int x;
	public int y;
	// Overload 3 pthuc khoi tạo
	// khởi tạo không tham số
	public Diem2D()
	{
		
	}
	// khởi tạo có tham số
	public Diem2D(int x, int y)
	{
		this.x=x;
		this.y=y;
	}
	// sao chép 
	public Diem2D(Diem2D point)
	{
		x = point.x;
		y = point.y;
	}
	public void nhapDiem()
	{
		System.out.print("Nhập tọa độ x : ");
	    this.x = scanner.nextInt();//Cập nhật x cho đối tượng hiện tại
	    System.out.print("Nhập tọa độ y : ");
	    this.y= scanner.nextInt(); // Cập nhật y cho đối tượng hiện tại
	}
	@Override
    public String toString() {
        return "Diem2D(x=" + x + ", y=" + y + ")";
    }
	public void hienThi() {
		System.out.println("Tọa độ vừa nhập là: ("+this.x+","+this.y+")");
	}
	
	public void doiDiem(Diem2D point, int dx, int dy)
	{
		point.x += dx;
		point.y +=dy;
	}
	
	public int giatriX() {
        return x;
    }
	
	public int giatriY() {
        return y;
    }
	//d = √(x² + y²)
	public float khoangCach() {
        return (float)Math.sqrt(this.x * this.x + this.y * this.y);
    }
	public float khoangCach1()
	{
		return (float) Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));
	}
	//d = √((x1 - x2)² + (y1 - y2)²)
	public float khoangCach_A_B(Diem2D point) {
		return (float) Math.sqrt((Math.pow((this.x - point.x) ,2) + Math.pow((this.y-point.y), 2)));
	}
	public void doixungB(Diem2D point)
	{
		this.x = point.x*-1;
		this.y = point.y*-1;
	}
	
	
}
