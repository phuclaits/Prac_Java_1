/**
 * 
 */
package Chuong1;

import java.util.Scanner;

/**
 * 
 */
public class PhanSo {
	public static Scanner scanner = new Scanner(System.in);
	public int tu;
	public int mau;
	
	public PhanSo() {};
	
	public PhanSo(int tu, int mau)
	{
		this.tu = tu;
		this.mau = mau;
	}
	
	public PhanSo(PhanSo a)
	{
		a.tu = tu;
		a.mau = mau;
	}
	public void nhapPS()
	{
		do {
			System.out.print("Nhập vào tử số : ");
		    this.tu = scanner.nextInt();//Cập nhật tử số cho đối tượng hiện tại
		    System.out.print("Nhập vào mẫu số : ");
		    this.mau= scanner.nextInt(); // Cập nhật mẫu số cho đối tượng hiện tại
		    if(this.mau==0)
		    {
		    	System.out.println("Mẫu không được bằng 0 vui lòng nhập lại!");
		    }
		}while(this.mau==0);
	}
	public void hienthiPS()
	{
		if(this.mau <0 && this.tu <0)
		{
			this.tu *=-1;
			this.mau *=-1;
			System.out.println("Phân số: "+this.tu+"/"+this.mau);
		}
		else if(this.mau <0)
		{
			Math.abs(this.mau);
			this.tu *=-1;
			System.out.println("Phân số: "+this.tu+"/"+this.mau);
		}
		else if(this.tu == 0)
		{
			this.tu =0;
			this.mau =0;
			System.out.println("Phân số: "+this.tu);
		}
		else if(this.mau == 1)
		{
			System.out.println("Phân số: "+this.tu);
		}
		else
		{
			System.out.println("Phân số: "+this.tu+"/"+this.mau);
		}
	}
	// nghịch đảo
	public PhanSo NghichDao(PhanSo a)
	{
		this.tu = a.mau;
		this.mau = a.tu;
		return a;
	}
	@Override
    public String toString() {
        return " " + tu + "/" + mau;
    }
	//Hàm tính ra phân số nghịch đảo của 1 phân số (phân số sẽ giữ nguyên nhưng hàm trả
	//về giá trị là phân số nghịch đảo của nó). PhanSo giaTriNghichDao();
	public PhanSo giaTriNghichDao() {
        return new PhanSo(mau, tu);
    }
	//Hàm tính ra giá trị thực của phân số. Chẳng hạn phân số 1/2 có giá trị là 0.5.
	public float GiatriThuc()
	{
		return this.tu/this.mau;
	}
	//Hàm so sánh lớn hơn với phân số a. boolean lonHon(PhanSo a);
	public boolean LonHon(PhanSo a)
	{
		float rs_PS1 = this.tu/this.mau;
		float rs_PS2 = a.tu/a.mau;
		if(rs_PS1 < rs_PS2)
			return false;
		return true;
	}
	//Hàm cộng, trừ, nhân, chia phân số với 1 phân số a. Kết quả của hàm là 1 phân số.
	// tạo ra phân số a b 
	// phân số c = psa.sum->psb
	public PhanSo Sum_PS_PS(PhanSo a) {
        return new PhanSo(this.tu * a.mau + a.tu * this.mau, this.mau * a.mau);
    }
	
	public PhanSo Tru_PS_PS(PhanSo a) {
        return new PhanSo(this.tu * a.mau - a.tu * this.mau, this.mau * a.mau);
    }

    public PhanSo Nhan_PS_PS(PhanSo a) {
        return new PhanSo(this.tu * a.tu, this.mau * a.mau);
    }

    public PhanSo Chia_PS_PS(PhanSo a) {
        return new PhanSo(this.tu * a.mau, this.mau * a.tu);
    }
    
    //Hàm cộng, trừ, nhân, chia phân số với 1 số nguyên. Kết quả của hàm là 1 phân số.
    public PhanSo Sum_PS_SN(int number) {
        return new PhanSo(this.tu + number * this.mau, this.mau);
    }
	
	public PhanSo Tru_PS_SN(int number) {
        return new PhanSo(this.tu - number * this.mau, this.mau );
    }

    public PhanSo Nhan_PS_SN(int number) {
        return new PhanSo(this.tu * number, this.mau);
    }

    public PhanSo Chia_PS_SN(int number) {
        return new PhanSo(this.tu , this.mau * number);
    }
}
