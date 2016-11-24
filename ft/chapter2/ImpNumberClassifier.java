/**
 * 
 */
package ft.chapter2;

import java.util.HashMap;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import static java.lang.Math.sqrt;

/**
 * @author yan96in 优化了的完美数分类的命令式解法
 */
public class ImpNumberClassifier {
	private int _number;// 存放待分类的目标数字
	private Map<Integer, Integer> _cache;// 内部缓存,防止重复不必要的求和运算

	public ImpNumberClassifier(int targetNumber) {
		_number = targetNumber;
		_cache = new HashMap<>();
	}

	public boolean isFactor(int condidate) {
		return _number % condidate == 0;
	}

	public Set<Integer> getFactor() {
		Set<Integer> factors = new HashSet<>();
		factors.add(1);
		factors.add(_number);
		for (int i = 2; i < sqrt(_number); i++) {
			if (isFactor(i))
				factors.add(_number / i);
		}
		return factors;
	}

	public int aliquotSum() {
		int sum = 0;
		for (int i : getFactor())
			sum += i;
		return sum - _number;
	}

	private int cachedAliquotSum() {
		if (_cache.containsKey(_number))//优先返回缓存的真约数和.
			return _cache.get(_number);
		else {
			int sum = aliquotSum();
			_cache.put(_number, sum);
			return sum;
		}
	}

	public boolean isPerfect() {
		return cachedAliquotSum() == _number;
	}

	public boolean isAbudant() {
		return cachedAliquotSum() > _number;
	}

	public boolean isDeficient() {
		return cachedAliquotSum() < _number;
	}
}
