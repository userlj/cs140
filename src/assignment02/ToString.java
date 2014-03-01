package assignment02;

public class ToString {
	int inputNum;
	private int one;
	private int ten;
	private int hundred;
	private int thousand;
	
	public ToString(int inputNum) {
		this.inputNum = inputNum;
    	one = inputNum % 10;
    	ten = ((inputNum - one) / 10) % 10;
    	hundred = ((inputNum - 10 * ten - one) / 100) % 10;
    	thousand = ((inputNum - 100 * hundred - 10 * ten - one) / 1000) % 10;
	}
	
	public String toString() {
		StringBuilder out = new StringBuilder();                

		if(thousand==0) out.append("");
		else if(thousand==1) out.append("M");
		else if(thousand==2) out.append("MM");
		else if(thousand==3) out.append("MMM");
		
		if(hundred==0) out.append("");
		else if(hundred==1) out.append("C");
		else if(hundred==2) out.append("CC");
		else if(hundred==3) out.append("CCC");
		else if(hundred==4) out.append("CD");
		else if(hundred==5) out.append("D");                	
		else if(hundred==6) out.append("DC");
		else if(hundred==7) out.append("DCC");
		else if(hundred==8) out.append("DCCC");
		else if(hundred==9) out.append("CM");
	
		if(ten==0) out.append("");
		else if(ten==1) out.append("X");
		else if(ten==2) out.append("XX");
		else if(ten==3) out.append("XXX");
		else if(ten==4) out.append("XL");
		else if(ten==5) out.append("L");                	
		else if(ten==6) out.append("LX");
		else if(ten==7) out.append("LXX");
		else if(ten==8) out.append("LXXX");
		else if(ten==9) out.append("XC");
	
		if(one==0) out.append("");
		else if(one==1) out.append("I");
		else if(one==2) out.append("II");
		else if(one==3) out.append("III");
		else if(one==4) out.append("IV");
		else if(one==5) out.append("V");                	
		else if(one==6) out.append("VI");
		else if(one==7) out.append("VII");
		else if(one==8) out.append("VIII");
		else if(one==9) out.append("IX");
	
		return out.toString();
	}
}
