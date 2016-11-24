/**
 * 
 */
package ft.chapter2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author yan96in
 *完美数分类的命令式解法
 */
public class ImpNumberClassifierSimple {
	private int _number;//存放待分类的目标数字
	private Map<Integer, Integer> _cache;//内部缓存,防止重复不必要的求和运算

	public ImpNumberClassifierSimple(int targetNumber) {
		_number = targetNumber;
		_cache = new HashMap<>();
	}

	public boolean isFactor(int potential) {
		return _number % potential == 0;
	}

	public Set<Integer> getFactor() {
		Set<Integer> factors = new HashSet<>();
		factors.add(1);
		factors.add(_number);
		for (int i = 2; i < _number; i++) {
			if (isFactor(i))
				factors.add(i);
		}
		return factors;
	}

	public int aliquotSum() {
		if (_cache.get(_number) == null) {
			int sum = 0;
			for (int i : getFactor())
				sum += i;
			_cache.put(_number, sum - _number);
		}
		return _cache.get(_number);
	}

	public boolean isPerfect() {
		return aliquotSum() == _number;
	}

	public boolean isAbudant() {
		return aliquotSum() > _number;
	}

	public boolean isDeficient() {
		return aliquotSum() < _number;
	}
}
