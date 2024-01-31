/**
 * 
 */
package Chuong1;

import java.util.Scanner;

/**
 * 
 */


public class Chuong1_Bai24 {
	public static Scanner scanner = new Scanner(System.in);
	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Diem2D pointB = new Diem2D();
		int choose = -1;
		while(choose !=9)
		{
			System.out.println("\nChọn một lựa chọn:");
		    System.out.println("1. Tạo ra điểm A tọa độ (3,4). Hiển thị tọa độ điểm A ra màn hình.");
		    System.out.println("2. Tạo ra điểm B với giá trị nhập từ bàn phím. Hiển thị tọa độ điểm B ra màn hình.");
		    System.out.println("3. Tạo ra điểm C đối xứng với điểm B qua gốc tọa độ. Hiển thị tọa độ điểm C ra màn hình");
		    System.out.println("4. Hiển thị ra màn hình khoảng cách từ điểm B đến tâm O.");
		    System.out.println("5. Hiển thị ra màn hình khoảng cách từ điểm A đến điểm B.");
		    System.out.print("Mời bạn chọn: ");
		    choose = scanner.nextInt();
		    Diem2D pointA = new Diem2D(3,4);
			switch (choose) {
			  case 1:
				  pointA.hienThi();
			    break;
			  case 2:
				  pointB.nhapDiem();
				  pointB.hienThi();
			    break;
			  case 3:
				  Diem2D pointC =new Diem2D();
				  pointC.doixungB(pointB);
				  pointC.hienThi();
			  case 4:
				  System.out.println("Khoảng cách từ điểm B -> O là: " + pointB.khoangCach());
                  break;
			  case 5:
				  float kcachAB = pointA.khoangCach_A_B(pointB);
				  System.out.println("Khoảng cách từ điểm A -> B là: " +kcachAB);
				  break;
			  case 6:
				  Diem2D point_TEST = new Diem2D(1, 1);
				  DiDoiDiem diDoiDiem = (point) -> {
					  return new Diem2D(point.x + 1, point.y + 1);
			      };
			      Diem2D point_NEW = diDoiDiem.diDoi(point_TEST);
			      System.out.println(point_NEW); 
				  
				  break;
			  default:
			    // Khối lệnh mặc định
			    break;
			}
		}
	}
	


}
