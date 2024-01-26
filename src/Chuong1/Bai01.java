package Chuong1;



import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Bai01 {
	public static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bai21();
	}
	
	
	
	public static void Bai1 () {
		System.out.println("Hello WORLD");
	}
	
	public static void Bai2 (int a, int b) {
		int max = a > b ? a : b;
		int min = a < b ? a : b;
		System.out.println("Số nhỏ nhất là: " + min);
		System.out.println("Số lớn nhất là: " + max);
	}
	
	public static void Bai3 (int a, int b, int c) {
		int min = a < b ? b : a;
        min = min < c ? min : c;
        System.out.println("Số nhỏ nhất là: " + min);
		int max = a > b ? a : b;
        max = max > c ? max : c;
        System.out.println("Số lớn nhất là: " + max);
	}
	
	public static void Bai4() {
		float a, b, c;
        System.out.print("Nhập hệ số a: ");
        a = scanner.nextFloat();
        System.out.print("Nhập hệ số b: ");
        b = scanner.nextFloat();
        System.out.print("Nhập hệ số c: ");
        c = scanner.nextFloat();
		
		float delta = b * b - 4 * a * c;

        if (delta > 0) {

            float x1 = (float)(-b + Math.sqrt(delta)) / 2 * a;
            float x2 = (float)(-b - Math.sqrt(delta)) / 2 * a;
            System.out.println("Phương trình có 2 nghiệm phân biệt là x1 = " + x1 + " và x2 = " + x2);
        } else if (delta == 0) {

            float x = -b / 2 * a;
            System.out.println("Phương trình có 1 nghiệm kép là x = " + x);
        } else {

            System.out.println("Phương trình vô nghiệm");
        }
	}
	
	public static void Bai6() {
		int year;
		year = scanner.nextInt();
		if(year %400==0 || year %4 == 0 && year % 100 != 0)
		{
			System.out.println(year+" là năm nhuận");
		}
		else {
			System.out.println(year+" không là năm nhuận");
		}
	}
	
	public static void Bai7() {
		
	}
	
	public static void Bai8() {
		float point;
		System.out.print("Nhập vào số: ");
		point = scanner.nextFloat();
		String rs = (point >= 8.5 && point <= 10) ? "A" :
            (point >= 7.0 && point <= 8.4) ? "B" :
            (point >= 5.5 && point <= 6.9) ? "C" :
            (point >= 4.0 && point <= 5.4) ? "D" : "F";
		System.out.println("Điểm: "+point + " có điểm chữ số là: "+rs );
	}
	

	public static void Bai09()
	{
		int soDienMoi, soDienCu;
		do
		{
			System.out.print("Nhập vào số điện cũ: ");
			soDienCu = scanner.nextInt();
			System.out.print("Nhập vào số điện mới: ");
			soDienMoi = scanner.nextInt();
			
			if(soDienMoi <= soDienCu)
			{
				System.out.println("Số điện mới phải lớn hơn số điện cũ!");
			}
		} while(soDienMoi <= soDienCu);
		
		int B1 = 1480, B2 = 1533, B3 = 1786, B4 = 2422, B5 = 2503;
		
		int soDien = soDienMoi - soDienCu;
		
		float RS =  (soDien <= 50) ? (soDien * B1) : 
			(soDien <= 100) ? (50 * B1 + ((soDien - 50) * B2)) :
			(soDien <= 200) ? (50 * B1 + (50 * B2) + ((soDien - 100) * B3)) :
			(soDien <= 300) ? (50 * B1 + (50 * B2) + (100 * B3) + ((soDien - 200) * B4)) :
			(50 * B1 + (50 * B2) + (100 * B3) + (100 * B4) + ((soDien - 300) * B5));
		
		System.out.println("Số tiền điện phải trả là " + RS);
	}
	
	
	
	private static boolean check_nhuan(int year)
	{
        return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? true : false;
	}
	
	public static int Get_Month_2_In_Year(int month,int year)
	{
		int maxDaysInMonth = 31;
        if (month == 2) {
            if (check_nhuan(year)) {
                maxDaysInMonth = 29;
            } else {
                maxDaysInMonth = 28;
            }
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            maxDaysInMonth = 30;
        }
        return maxDaysInMonth;
	}
	
	
	public static void Bai10()
	{
		boolean isValid = true;
		System.out.print("Nhập ngày: ");
        int day = scanner.nextInt();

        System.out.print("Nhập tháng: ");
        int month = scanner.nextInt();

        System.out.print("Nhập năm: ");
        int year = scanner.nextInt();
        
        if (year < 1) {
            isValid = false;
        } else if (month < 1 || month > 12) {
            isValid = false;
        } else {
            int maxDaysInMonth = Get_Month_2_In_Year(month, year);
            if (day < 1 || day > maxDaysInMonth) {
                isValid = false;
            }
        }

        if (isValid) {
            System.out.println("Ngày " + day + "/" + month + "/" + year + " là ngày hợp lệ");
        } else {
            System.out.println("Ngày " + day + "/" + month + "/" + year + " không phải là ngày hợp lệ");
        }
        
	}
	
	public static boolean checkIsValid_Day(int day, int month, int year)
	{
		boolean isValid = true;
		if (year < 1) {
            isValid = false;
        } else if (month < 1 || month > 12) {
            isValid = false;
        } else {
            int maxDaysInMonth = Get_Month_2_In_Year(month, year);
            if (day < 1 || day > maxDaysInMonth) {
                isValid = false;
            }
        }
		return isValid;
	}
	public static void Bai11() {
		int day, month,year;
		boolean isValid = true;
		System.out.print("Nhập ngày: ");
        day = scanner.nextInt();

        System.out.print("Nhập tháng: ");
        month = scanner.nextInt();

        System.out.print("Nhập năm: ");
        year = scanner.nextInt();
        int prev_day = 0, prev_month = 0, cont_day = 0 , cont_month= 0;
        int year_new=0, prev_year =0;
        System.out.print("Ngày tháng năm vừa nhập là :  "+day + " "+month+" "+year);
        //check 
        try {
        	if(checkIsValid_Day(day,month,year) == false)
        	{
        		throw new IllegalArgumentException("Ngày không hợp lệ");
        	}
        }
        catch(IllegalArgumentException e)
        {
        	System.out.println("\nLỗi: "+e.getMessage());
        	return;
        }
        
        
        
        
        //Check Month = 2
        if(month == 2)
        {
        	// kiểm tra nhuận
            if(check_nhuan(year) == true)
            {
            	if(day ==29)
            	{
            		prev_day = day-1;
            		prev_month = month;
            		cont_day = 1;
            		cont_month+=1;
            		year_new= year;
            		prev_year = year;
            	}
            }
            //không nhuận
            else {
            	if(day ==28)
            	{
            		prev_day = day-1;
            		prev_month = month;
            		cont_day = 1;
            		cont_month+=1;
            		year_new= year;
            		prev_year = year;
            	}
            }
        }
        // ngày 1 -> rev thành 30 hoặc 31
        if (day==1)
        {
        	if(month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
        	{
        		prev_day = 30;
        		prev_month = month-1;
        		cont_day = day+1;
        		cont_month = month;
        		year_new= year;
        		prev_year = year;
        	}
        	else if( month == 2 || month == 4 || month ==6 || month == 9 || month == 11) {
        		prev_day = 31;
        		prev_month = month-1;
        		cont_day = day+1;
        		cont_month = month;
        		year_new= year;
        		prev_year = year;
        	}
        	else if(month == 1)
        	{
        		prev_day = 31;
        		prev_month = 12;
        		prev_year = year -1;
        		cont_day = day+1;
        		cont_month = month;
        		year_new= year;
        	}
        	else {
        		if(check_nhuan(year) == true)
        		{
        			prev_day = 29;
            		prev_month = month-1;
            		cont_day = day+1;
            		cont_month = month;
            		year_new= year;
            		prev_year = year;
        		}
        		else {
        			prev_day = 28;
            		prev_month = month-1;
            		cont_day = 1;
            		cont_month = month+1;
            		year_new= year;
            		prev_year = year;
        		}
        	}
        }
        else if(day == 30 && month == 4 || month ==6 || month == 9 || month == 11 )
        {
        	prev_day = day-1;
    		prev_month = month;
    		cont_day = 1;
    		cont_month = month+1;
    		year_new= year;
    		prev_year = year;
        }
        else if(day == 31 &&  month == 1 || month == 5 || month == 7 || month == 8 || month == 10 )
        {
        	prev_day = day-1;
    		prev_month = month;
    		cont_day = 1;
    		cont_month = month+1;
    		year_new= year;
    		prev_year = year;
        }
        else {
        	if(check_nhuan(year))
        	{
        		prev_day = day-1;
        		prev_month = month;
        		cont_day = 1;
        		cont_month = month+1;
        		year_new= year;
        		prev_year = year;
        	}
        	else {
        		prev_day = day-1;
        		prev_month = month;
        		cont_day = 1;
        		cont_month = month+1;
        		year_new= year;
        		prev_year = year;
        	}
    		
        }
        if(day ==31 && month == 12)
        {
        	prev_day = day-1;
    		prev_month = month;
    		cont_day = 1;
    		cont_month = 1;
    		year_new = year+1;
    		prev_year = year;
        }
        
        System.out.println("\nNgày trước:  "+prev_day+" - "+prev_month+" - "+prev_year);
        System.out.println("Ngày sau:  "+cont_day+" - "+cont_month+" - "+year_new);
	}
	
	public static void Bai12()
	{
		int n;
		System.out.print("Nhập số dương n: ");
        n = scanner.nextInt();
        
        //lambda i <= n  == n+1
		int result = (int)IntStream.range(1,n+1).filter(x -> n % x == 0).count();
		
		System.out.println("Kết quả là: "+ result);
	}
	// Nhập số nguyên dương n. Liệt kê các ước số lẻ của n.
	public static void Bai13()
	{
		int n;
		System.out.print("Nhập số dương n: ");
        n = scanner.nextInt();
        int arr[];
        for(int i = 1 ; i <=n; i++)
        {
        	if(n%i ==0 && i % 2 !=0)
        	{
        		System.out.println(i);
        	}
        }
        
        
	}
	public static void Bai14()
	{
		int n;
		System.out.println("Nhập vào số n: ");
		n= scanner.nextInt();
		boolean isValid =true;
		if(n<=1)
		{
			isValid = false; 
		}
		for(int i = 2; i <= Math.sqrt(n); i++)
		{
			if(n % i == 0)
			{
				isValid = false;
			}
		}
		if(isValid)
		{
			System.out.println(n+" là số nguyên tố.");
		}else {
			System.out.println(n+" không phải là số nguyên tố.");
		}
	}
	
	public static int Bai15() {
		float n ;
		do
		{
			System.out.println("Nhập vào số thực khác 0: ");
			n = scanner.nextFloat();
		}while(n<=0);
		return 0;
	}
	//Nhập số nguyên dương n. Đếm số lượng các chữ số lẻ của n.
	public static void Bai16()
	{
		int n;
		System.out.print("Nhập số dương n: ");
        n = scanner.nextInt();
        String n_new = Integer.toString(n);
        String[] digits = n_new.split("");
        int count =0;
		for (String digit : digits) {
			if(Integer.parseInt(digit) % 2 !=0)
			{
				count++;
			}
		}
		System.out.println("Kết quả có: "+count+" số lẻ");
	}
	// Nhập vào một số nguyên dương n. Tính tổng số lượng các chữ số chẵn n
	public static void Bai17() {
		int n;
		System.out.println("Nhập vào số nguyên dương n: ");
		n = scanner.nextInt();
		String n_new = Integer.toString(n);
		String []digits = n_new.split(n_new);
		int count = 0;
		for(String digit: digits)
		{
			if(Integer.parseInt(digit) % 2 == 0)
			{
				count++;
			}
		}
		System.out.println("Kết quả có: "+count+" số lẻ");
	}
	public static int Bai17_Cach2()
	{
		int n, count =0;
		System.out.println("Nhập vào số nguyên dương n: ");
		n = scanner.nextInt();
		while(n>9)
		{
			int t;
			t=(n%10);
			if(t%2!=0)
			{
				count+=1;
			}
			n = n /10;
		}
		count++;
		return count;
	}
	public static void Bai18()
	{
		int m,n;
		do {
			System.out.print("Nhập số dương m: ");
	        m = scanner.nextInt();
			System.out.print("Nhập số dương n: ");
	        n = scanner.nextInt();
		}while(m<=0 || n <=0);
        for(int i = 1; i <=m; i++)
        {
        	for(int j = 1; j <=n;j++)
        	{
        		
        		System.out.print("*");
        	}
        	System.out.println();
        }
	}
	public static void Bai19()
	{
		int m,n;
		do {
			System.out.print("Nhập số dương m: ");
	        m = scanner.nextInt();
			System.out.print("Nhập số dương n: ");
	        n = scanner.nextInt();
		}while(m<=0 || n <=0);
        for(int i = 1; i <=m; i++)
        {
        	for(int j = 1; j <=n;j++)
        	{
        		
        		if(i == 1|| i==m || j == 1|| j == n)
        		{
        			System.out.print("*");
        		}
        		else {
        			System.out.print(" ");
        		}
        	}
        	System.out.println();
        }
	}
	public static void Bai20()
	{
		int h;
		do {
			System.out.print("Nhập chiều cao h: ");
	        h= scanner.nextInt();
			
		}while(h <=0);
		for(int i = 1 ; i <=h ; i++)
		{
			for(int j = 1 ; j<=h*2-1 ; j++)
			{
				if(j== h|| i ==h || j == h+1-i|| j ==h+i-1)
				{
					System.out.print("*");
				}
				else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
	
	public static void Bai21()
	{
		int h;
		do {
			System.out.print("Nhập chiều cao h: ");
	        h= scanner.nextInt();
			
		}while(h <=0);
		for(int i = 1 ; i <=h ; i++)
		{
			for(int j = 1 ; j<=h*2-1 ; j++)
			{
				if( i ==h ||j == h+1-i|| j ==h+i-1)
				{
					System.out.print("*");
				}
				else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
