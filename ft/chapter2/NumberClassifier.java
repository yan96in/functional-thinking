/**
 * 
 */
package ft.chapter2;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author yan96in 稍微向函数式靠拢的完美数分类实现
 */
public class NumberClassifier {
	public static boolean isFactor(final int candidate, final int number)
	// 众多方法都必须加上number参数,因为没有可以存放它的内部状态.
	{
		return number % candidate == 0;
	}

	// 所有方法都带public static修饰,因为它们是纯函数,在类外使用就必须加
	public static Set<Integer> factors(final int number) {
		Set<Integer> factors = new HashSet<>();
		factors.add(1);
		factors.add(number);
		for (int i = 2; i < number; i++) {
			if (isFactor(i, number))
				factors.add(i);
		}
		return factors;
	}

	public static int aliquotSum(final Collection<Integer> factors) {
		// 注意上面对参数类型的选取,尽可能宽泛的参数类型可以增加函数重用的机会.
		int sum = 0;
		int targetNumber = Collections.max(factors);
		for (int n : factors) {
			sum += n;
		}
		return sum - targetNumber;
	}

	public static boolean isPerfect(final int number) {
		return aliquotSum(factors(number)) == number;
	}

	// 目前在重复执行分类操作时效率较低,因为没有缓存.
	public static boolean isAbundant(final int number) {
		return aliquotSum(factors(number)) > number;
	}

	public static boolean isDeficient(final int number) {
		return aliquotSum(factors(number)) < number;
	}
}
