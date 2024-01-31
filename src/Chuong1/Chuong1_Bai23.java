/**
 * 
 */
package Chuong1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 
 */
public class Chuong1_Bai23 {
	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int choose = -1;
		int [][]arr = new int [500][1000]; 
		// TODO Auto-generated method stub
		while(choose !=9)
		{
			System.out.println("\nChọn một lựa chọn:");
		    System.out.println("1. Nhập giá trị cho n phần tử mảng từ bàn phím (n <= 500).");
		    System.out.println("2. Phát sinh giá trị ngẫu nhiên từ -99 đến 99 cho mxn phần tử của mảng (n <= 100);");
		    System.out.println("3. Xuất Mảng.");
		    System.out.println("4. Tính tổng giá trị các số lẻ");
		    System.out.println("5. Tính tổng các giá trị dương trên dòng k cho trước");
		    System.out.println("6. Đếm số lượng số dương");
		    System.out.println("7. Đếm số lượng số nguyên tố trên một dòng của ma trận ");
		    System.out.println("8. Kiểm tra ma trận có tồn tại số âm hay không ");
		    System.out.println("9. Kiểm tra các phần tử trên dòng k cho trước có tăng dần từ trái qua phải hay không ");
		    System.out.println("10. Liệt kê dòng có chứa số nguyên tố ");
		    System.out.println("11.Liệt kê dòng có chứa số nguyên tố ");

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
				  System.out.println("Kết quả là: "+SumODD(arr));
				  break;
			  case 5:
				  System.out.println("Kết quả là: "+SumPos_Row(arr));
				  break;
			  case 6:
				  System.out.println("Kết quả là: "+Count_6(arr));
				  break;
			  case 7:
				  System.out.println("Số lượng số nguyên tố trong mảng là: "+Count_SNT(arr));
				  break;
			  case 8:
				  System.out.println("Kết quả: "+Check_Am(arr));
				  if(Check_Am(arr))
				  {
					  System.out.println("Ma trận có chứa giá trị âm");
				  }
				  else {
					  System.out.println("Ma trận không tồn tại giá trị âm");
				  }
				  break;
			  case 9:
				  
				  if(Check_Sort(arr))
				  {
					  System.out.println("Dòng K có tăng dần");
				  }
				  else {
					  System.out.println("Dòng K không có tăng dần");
				  }
				  break;
			  case 10:
				  Lietke_Rows_SNT(arr);
				  break;
			  case 11:
				  Rows_Even(arr);
				  break;

			  default:
			    // Khối lệnh mặc định
			    break;
			}
		}
	}
	public static int[][] InputArr()
	{
		int m,n;
		System.out.print("Nhâp vào số lượng dòng m:  ");
		m = scanner.nextInt();
		System.out.print("Nhâp vào số lượng n cột:  ");
		n = scanner.nextInt();
		int [][]arr= new int [m][n];
		for(int i = 0 ; i < m ; i++)
		{
			for(int j = 0; j < n; j++)
			{
				System.out.print("Nhập vào giá trị phần tử a["+i+"]"+"["+j+"] "+"= ");
				arr[i][j] = scanner.nextInt();
			}
		}
		return arr;
	}
	
	public static int[][] Input_Random_Arr()
	{
		int m,n;
		System.out.print("Nhâp vào số lượng dòng m:  ");
		m = scanner.nextInt();
		System.out.print("Nhâp vào số lượng n cột:  ");
		n = scanner.nextInt();
		int [][]arr= new int [m][n];
		
		for(int i = 0 ; i < m ; i++)
		{
			for(int j = 0; j < n; j++)
			{
				arr[i][j] = -99 +(int)(Math.random()*198);
			}
		}
		return arr;
	}
	
	public static void xuatmang(int [][]arr)
	{
		System.out.println("========Xuất Mảng==========");
		Arrays.stream(arr).map(Arrays::toString).forEach(System.out::println);
	}
	//4. Tính tổng giá trị các số lẻ;
	public static int SumODD(int [][]arr)
	{
		return Arrays.stream(arr).reduce(0,(acc,row)->{
			int sumRows = Arrays.stream(row).filter(x->x%2!=0).sum();
			return acc+sumRows;
		},Integer::sum);
	}
	//5. Tính tổng các giá trị dương trên dòng k cho trước;
	public static int SumPos_Row(int [][]arr)
	{
		int k;
		System.out.println("Nhập vào số k(dòng): ");
		k = scanner.nextInt();
		return Arrays.stream(arr).reduce(0,(acc,row)->{
			if(row.length <= k)
				return acc;
			int sumRow = Arrays.stream(row).filter(x->x>0).sum();
			return sumRow+acc;
		},Integer::sum);
	}
	//6. Đếm số lượng số dương;
	// phương thức count trả về kiểu dữ liệu là long do "int nhỏ hơn long" 
	public static long Count_6(int [][]arr)
	{
		return  Arrays.stream(arr).reduce(0L,(acc,row)->
											  acc + Arrays.stream(row)
											  .filter(x -> x >0)
											  .count()
											  ,Long::sum);
		
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
	//7. Đếm số lượng số nguyên tố trên một dòng của ma trận;
	public static long Count_SNT(int [][]arr)
	{
		return Arrays.stream(arr).reduce(0L, (acc,row)-> 
											  acc + Arrays.stream(row)
											  .filter(x->check_snt(x))
											  .count()
											  ,Long::sum);
	}
	//8. Kiểm tra ma trận có tồn tại số âm hay không;
	public static Boolean Check_Am(int [][]arr)
	{
		return Arrays.stream(arr)
	            .flatMapToInt(Arrays::stream)  // Chuyển đổi thành IntStream 
	            .anyMatch(x -> x < 0); //  Tìm kiếm số âm và trả về booleann
	}
	// 9. Kiểm tra các phần tử trên dòng k cho trước có tăng dần từ trái qua phải hay không;
	public static boolean Check_Sort(int [][]arr)
	{
		int k;
		System.out.println("Nhập vào số k(dòng): ");
		k = scanner.nextInt();
		if(k < arr.length)
		{
			return false;
		}
		for(int j = 0 ; j < arr.length-1 ; j++)
		{
			if(arr[k][j] < arr[k][j+1])
				return false;
		}
		return true;
	}
	//10. Liệt kê dòng có chứa số nguyên tố;
	public static void Lietke_Rows_SNT(int [][]arr)
	{
		for(int i = 0; i <arr.length ; i++)
		{
			for(int j = 0 ; j < arr[i].length ; j++)
			{
				if(check_snt(arr[i][j]))
				{
					System.out.println("Dòng "+i+": "+arr[i][j]);
				}
			}
		}
	}
	
	public static boolean check_Even(int num)
	{
		return num % 2 == 0;
	}
	public static void Rows_Even(int [][]arr)
	{
		for(int i = 0; i <arr.length ; i++)
		{
			boolean isEven = true;
			for(int j = 0 ; j < arr[i].length ; j++)
			{
				if(!check_Even(arr[i][j]))
				{
					isEven = false;
					break;
				}
			}
			if(isEven)
			{
				System.out.println("Dòng "+i+" toàn giá trị chẵn");
			}
		}
		//
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
