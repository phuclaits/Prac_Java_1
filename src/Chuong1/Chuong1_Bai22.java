package Chuong1;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.regex.Pattern;
public class Chuong1_Bai22 {
	public static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		int choose = -1;
		int []arr = new int [500]; 
		// TODO Auto-generated method stub
		while(choose !=9)
		{
			System.out.println("\nChọn một lựa chọn:");
		    System.out.println("1. Nhập giá trị cho n phần tử mảng từ bàn phím (n <= 500).");
		    System.out.println("2. Sinh số ngẫu nhiên.");
		    System.out.println("3. Xuất Mảng.");
		    System.out.println("4. Xuất giá trị âm.");
		    System.out.println("5. Xuất Số Nguyên Tố");
		    System.out.println("6. Liệt kê các phần tử có giá trị nằm trong đoạn [a, b] cho trước.");
		    System.out.println("7. Tổng các số nguyên tố trong mảng. ");
		    System.out.println("8. Tính trung bình cộng của các phần tử dương có trong mảng. ");
		    System.out.println("9. Đếm số phần tử có giá trị lớn hơn x cho trước. ");
		    System.out.println("10. Đếm số phần tử có giá trị là số nguyên tố trong mảng. ");
		    System.out.println("11.Kiểm tra mảng có phải là mảng chứa toàn số nguyên tố. ");
		    System.out.println("12.Kiểm tra mảng có phải là mảng tăng dần. ");
		    System.out.println("13.Tìm giá trị lớn nhất trong mảng. ");
		    System.out.println("14.Tìm giá trị nhỏ nhất trong mảng. ");
		    System.out.println("15. Tìm số âm lớn nhất trong mảng. ");
		    System.out.println("16. Đảo ngược mảng. ");
		    System.out.println("Lựa chọn của bạn: ");
		    choose = scanner.nextInt();
			
			switch (choose) {
			  case 1:
				  arr  = InputArr();
			    break;
			  case 2:
				  arr = Input_Random_Arr();
			    break;
			  case 3:
				  xuatmang(arr);
				  break;
			  case 4:
				  GiaTriAm(arr);
				  break;
			  case 5:
				  xuat_snt(arr);
				  break;
			  case 6:
				  paragraph_A_B(arr);
				  break;
			  case 7:
				  System.out.println("Tổng các số nguyên tố trong mảng là: "+sum_snt(arr));
				  break;
			  case 8:
				  System.out.println("Trung bình cộng của các phần tử dương có trong mảng: "+avg_positive_in_arr(arr));
				  break;
			  case 9:
				  System.out.println("Đếm số phần tử lớn hơn X ");
				  count_large_x(arr);
				  break;
			  case 10:
				  System.out.println("Đếm số phần tử có giá trị số nguyên tố "+count_snt_in_arr(arr));
				  break;
			  case 11:
				  int rs = check_all_ele_snt(arr);
				  if(rs >0)
				  {
					  System.out.println("Mảng không chứa toàn bộ số nguyên tố");
				  }
				  else{
					  System.out.println("Mảng chứa toàn bộ số nguyên tố");
				  }
				  break;
			  case 12:
				  
				  if(check_ascending_arr(arr))
				  {
					  System.out.println("Mảng tăng dần");
				  }
				  else System.out.println("Mảng không tăng dần");
				  break;
			  case 13:
				  // regex
				  //String output = rs1.replaceAll("\\[\\s*\\]", rs1);
				  OptionalInt rs1 = find_ele_max(arr);
				  System.out.println(rs1);
				  String output1 = Integer.toString(rs1.getAsInt());
				  System.out.println("Giá trị lớn nhất trong mảng là: "+output1);
				  break;
				  
			  case 14:
				  OptionalInt rs2 = find_ele_min(arr);
				  String output2 = Integer.toString(rs2.getAsInt());
				  System.out.println("Giá trị nhỏ nhất trong mảng là: "+output2);
				  break;
				  
			  case 15:
				  OptionalInt rs3 = find_ele_max_am(arr);
				  String output3 = Integer.toString(rs3.getAsInt());
				  System.out.println("Giá trị âm lớn nhất trong mảng là: "+output3);
				  break;
			  case 16:
				  xuatmang(arr);
				  System.out.println("Đảo ngược mảng thành như sau ");
				  reverse_arr(arr);
				  xuatmang(arr);
				  break;
			  default:
			    // Khối lệnh mặc định
			    break;
			}
		}
		  
	}
	public static int[] InputArr()
	{
		int n;
		System.out.print("Nhâp vào số lượng phần tử:  ");
		n = scanner.nextInt();
		int []arr= new int [n];
		for(int i = 0 ; i < n ; i++)
		{
			System.out.print("Nhập vào giá trị phần tử a["+i+"] = ");
			arr[i] = scanner.nextInt();
		}
		return arr;
	}
	
	public static int[] Input_Random_Arr()
	{
		int n;
		System.out.print("Nhâp vào số lượng phần tử:  ");
		n = scanner.nextInt();
		int []arr= new int [n];
		for(int i = 0 ; i < n ; i++)
		{
			arr[i] = -199 +(int)(Math.random()*398);
		}
		return arr;
	}
	
	public static void xuatmang(int []arr)
	{
		System.out.println("========Xuất Mảng==========");
		Arrays.stream(arr, 0, arr.length).forEach(i -> System.out.print(i+" "));
	}
	public static void GiaTriAm(int []arr)
	{
		//(arr, 0, arr.length).forEach(i -> arr.length-1 if(arr[i] < 0) System.out.print(i+" "));
		Arrays.stream(arr, 0, arr.length).filter(i -> i<0).forEach(i ->{
				System.out.println(i);
		});
	}
	public static boolean check_snt(int n)
	{
		if(n<=1)
		{
			return false;
		}
		for(int i = 2; i <= Math.sqrt(n); i++)
		{
			if(n % i == 0)
			{
				return false;
			}
		}
		return true;
	}
	public static void xuat_snt(int arr[])
	{
		System.out.print("Các số nguyên tố là: ");
		Arrays.stream(arr, 0, arr.length).filter(i -> check_snt(i)).forEach(i ->{
			System.out.print(i+ " " );
		});
	}
	//6. Liệt kê các phần tử có giá trị nằm trong đoạn [a, b] cho trước;
	public static void paragraph_A_B(int arr[])
	{
		int a,b;
		System.out.print("Nhập vào điểm A = ");
		a = scanner.nextInt();
		System.out.print("Nhập vào điểm B = ");
		b = scanner.nextInt();
		
		if(a>b || a<0  || b<0 || b > arr.length || a > arr.length)
		{
			System.out.println("Lỗi ĐOẠN A B. Vui lòng chọn điểm phù hợp!");
		}
		else {
			Arrays.stream(arr,a,b+1).forEach(i->System.out.print(i+" "));
		}
	}
	//7. Tính tổng giá trị các phần tử là số nguyên tố;
	public static int sum_snt(int arr[])
	{
		return Arrays.stream(arr,0,arr.length).filter(i->check_snt(i)).sum();
	}
	//8. Tính trung bình cộng của các phần tử dương có trong mảng;
	public static OptionalDouble avg_positive_in_arr(int arr[])
	{
		return Arrays.stream(arr,0,arr.length).filter(i -> i>0).average();
	}
	// 9. Đếm số phần tử có giá trị lớn hơn x cho trước;
	public static int count_large_x(int arr[])
	{
		System.out.println("Nhập vào số x tương ứng: ");
		int x = scanner.nextInt();
		return (int)Arrays.stream(arr,0,arr.length).filter(i -> i>x).count();
	}
	//10. Đếm số phần tử có giá trị là số nguyên tố trong mảng;
	public static int count_snt_in_arr(int arr[])
	{
		return (int)Arrays.stream(arr,0,arr.length).filter(i-> check_snt(i)).count();
	}
	//11.Kiểm tra mảng có phải là mảng chứa toàn số nguyên tố;
	public static int check_all_ele_snt(int arr[])
	{
		// trả về số lượng không phải số nguyên tố
		return (int) Arrays.stream(arr,0,arr.length).filter(i->check_snt(i)==false).count();
	}
	//12. Kiểm tra mảng có phải là mảng tăng dần
	public static boolean check_ascending_arr(int arr[])
	{
		// chạy tới phần từ nhì cuối.
		return (boolean)Arrays.stream(arr,0,arr.length-2).allMatch(i -> i <= arr[i + 1]);
	}

//	13. Tìm giá trị lớn nhất trong mảng;
	public static OptionalInt find_ele_max(int arr[])
	{
		return Arrays.stream(arr,0,arr.length).max();
	}
//	14. Tìm giá trị nhỏ nhất trong mảng;
	public static OptionalInt find_ele_min(int arr[])
	{
		return Arrays.stream(arr,0,arr.length).min();
	}
//	15. Tìm số âm lớn nhất trong mảng;
	public static OptionalInt find_ele_max_am(int arr[])
	{
		return Arrays.stream(arr,0,arr.length).filter(i->i<0).max();
	}
//	16. Đảo ngược mảng.
	public static void reverse_arr(int arr[])
	{
		Arrays.stream(arr,0,(arr.length)/2).forEach(i->{
			int t = arr[i];
			arr[i] =arr[arr.length-i-1];
			arr[arr.length-i-1] = t;
		});
	}
}
