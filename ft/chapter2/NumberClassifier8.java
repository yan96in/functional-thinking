/**
 * 
 */
package ft.chapter2;
import static java.util.stream.IntStream.range;

import java.util.stream.IntStream;

/**
 * @author yan96in
 *
 */
public class NumberClassifier8 {
	public static IntStream factorsOf(int number) {
		return range(1, number + 1).filter(potential -> number % potential == 0);
	}

	public static int aliquotSum(int number) {
		return factorsOf(number).sum() - number;
	}

	public static boolean isPerfect(int number) {
		return aliquotSum(number) == number;
	}

	public static boolean isAbundant(final int number) {
		return aliquotSum(number) > number;
	}

	public static boolean isDeficient(final int number) {
		return aliquotSum(number) < number;
	}
}
