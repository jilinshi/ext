package com.mingda.util;

import java.math.BigDecimal;

public class Counts {

	static long a(long n) {
		if (n == 1) {
			return 1;
		} else {
			return n * a(n - 1);
		}
	}

	public static void main(String[] args) {
		
		System.out.println(Counts.a(11));
		System.out.println(Counts.factorial1(new BigDecimal(11)));
		System.out.println(Counts.factorial2(new BigDecimal(11)));
		System.out.println(Counts.factorial3(new BigDecimal(11)));

	}

	static BigDecimal factorial1(BigDecimal n) {
		BigDecimal bd1 = new BigDecimal(1);// 1
		if (n.equals(new BigDecimal(1))) {
			return bd1;
		} else
			return n.multiply(factorial1(n.subtract(bd1)));// n*f(n-1)
	}

	static BigDecimal factorial2(BigDecimal n) {
		BigDecimal bd1 = new BigDecimal(1);// BigDecimal类型的1
		BigDecimal bd2 = new BigDecimal(2);// BigDecimal类型的2</span><span>
		BigDecimal result = bd1;// 结果集，初值取1
		while (n.compareTo(bd1) > 0) {// 参数大于1，进入循环
			result = result.multiply(n.multiply(n.subtract(bd1)));// 实现result*（n*（n-1））
			n = n.subtract(bd2);// n-2后继续
		}
		return result;
	}
	/*
	 * public static void main(String[] arguments){ Scanner sc = new
	 * Scanner(System.in); BigDecimal n = sc.nextBigDecimal();
	 * 
	 * System.out.print(n + "!=" + factorial(n)); } }
	 */

	public static BigDecimal factorial3(BigDecimal n) {
		BigDecimal bd1 = new BigDecimal(1);// BigDecimal类型的1
		BigDecimal bd2 = new BigDecimal(2);// BigDecimal类型的2</span><span>
		BigDecimal result = bd1;// 结果集，初值取1
		while (n.compareTo(bd1) > 0) {// 参数大于1，进入循环
			result = result.multiply(n.multiply(n.subtract(bd1)));// 实现result*（n*（n-1））
			n = n.subtract(bd2);// n-2后继续
		}
		return result;
	}

}
