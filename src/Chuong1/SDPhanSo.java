/**
 * 
 */
package Chuong1;

import java.util.Scanner;

/**
 * 
 */
public class SDPhanSo {
	public static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PhanSo[] psArr = new PhanSo[500];
		int choose = -1;
		while(choose !=9)
		{
			System.out.println("\nChọn một lựa chọn:");
		    System.out.println("1. Tạo phân số a = 3/7 , b = 4/9 . Hiển thị giá trị của chúng ra màn hình.");
		    System.out.println("2. Tạo 2 phân số x và y. Nhập giá trị cho x và y từ bàn phím.");
		    System.out.println("3. Hiển thị giá trị nghịch đảo của phân số x ra màn hình (không làm thay đổi giá trị của\r\n"
		    		+ "x).");
		    System.out.println("4. Tính tổng của x + y và in kết quả ra màn hình.");
		    System.out.println("5. Nhập vào 1 danh sách gồm n phân số (n : nhập từ bàn phím ).");
		    System.out.println("6. Tính tổng n phân số đó.");
		    System.out.println("7. Tìm phân số lớn nhất trong danh sách phân số trên.");
		    System.out.println("8. Sắp xếp danh sách phân số theo thứ tự tăng dần.");
		    
		    System.out.print("Mời bạn chọn: ");
		    choose = scanner.nextInt();
			switch (choose) {
			  case 1:
				  PhanSo a = new PhanSo(-1,-2);
				  PhanSo b = new PhanSo(4,9);
				  a.hienthiPS();
				  b.hienthiPS();
			    break;
			  case 2:
				  PhanSo x = new PhanSo();
				  x.nhapPS();
				  x.hienthiPS();
				  PhanSo y = new PhanSo();
				  y.nhapPS();
				  y.hienthiPS();
			    break;
			  case 3:
				  PhanSo C = new PhanSo();
				  C.nhapPS();
				  System.out.println("Phân số ban đầu: " +C.tu + "/"+C.mau);
				  PhanSo psNghichDao = C.giaTriNghichDao();
				  System.out.println("Giá trị nghịch đảo: " + psNghichDao);
			  case 4:
				  PhanSo x1 = new PhanSo();
				  x1.nhapPS();
				  PhanSo y1 = new PhanSo();
				  y1.nhapPS();
				  PhanSo Sum = x1.Sum_PS_PS(y1);
				  Sum.hienthiPS();
				  break;
			  case 5:
				  psArr= NhapArr_PS();
			      Xuat_LIST_PS(psArr);
				  break;
			  case 6:
				  PhanSo psTong = TongN_PS(psArr);
				  System.out.println("Tổng các ps là: "+psTong);
				  break;
			  default:
			    // Khối lệnh mặc định
			    break;
			}
		}
	}
	public static PhanSo[] NhapArr_PS() 
	{
		
		System.out.print("Nhập số lượng phân số: ");
		int n = scanner.nextInt();
		PhanSo[] psArr = new PhanSo[n];
		for (int i = 0; i < n; i++) {
            System.out.print("Nhập phân số thứ " + (i + 1) + ": ");
            psArr[i] = new PhanSo(scanner.nextInt(), scanner.nextInt());
        }
		return psArr;
	}
	public static void Xuat_LIST_PS(PhanSo[] psArr) 
	{
		for (PhanSo ps : psArr) {
            System.out.println(ps);
        }
	}
	public static PhanSo TongN_PS(PhanSo[] psArr)
	{
		PhanSo PSTong = new PhanSo(1,1);
		for (PhanSo ps : psArr) {
			PSTong = PSTong.Sum_PS_PS(ps);
        }
		return PSTong.Tru_PS_SN(1);
	}
	

}
