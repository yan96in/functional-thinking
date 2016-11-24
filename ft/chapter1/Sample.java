/**
 * 
 */
package ft.chapter1;

import org.apache.commons.lang.StringUtils;

/**
 * @author yan96in
 *
 */
public class Sample {
	public static void sample1() {
		int tmp1=StringUtils.indexOfAny("zzabyycdxx",new char[]{'z','a'});//0
		int tmp2=StringUtils.indexOfAny("zzabyycdxx",new char[]{'b','y'});//3
		int tmp3=StringUtils.indexOfAny("aba",new char[]{'z'});//-1
		System.out.println(tmp1+" "+tmp2+" "+tmp3);
	}
	public static void main(String[] args) {
		sample1();
	}
}
