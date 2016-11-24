/**
 * 
 */
package ft.chapter2;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yan96in
 *
 */
public class TheCompanyProcess {
	//公司业务处理过程
	public String cleanNames(List<String> listOfNames) {
		StringBuilder result=new StringBuilder();
		for(int i=0;i<listOfNames.size();i++) {
			if(listOfNames.get(i).length()>1) {
				result.append(capitalizeString(listOfNames.get(i))).append(",");
			}
		}
		return result.substring(0,result.length()-1).toString();
	}
	//首字母大写
	public String capitalizeString(String s) {
		return s.substring(0,1).toUpperCase()+s.substring(1,s.length());
	}
	
	/*
	 * 伪码表示
	 * listOfEmps
	 * ->filter(x.length>1)
	 * ->transform(x.capitalize)
	 * ->convert(x+","+y)
	 * 
	 * Scala实现
	 * val employee=List("neal","mason")
	 * var result=employee
	 * .filter(_.length()>1)
	 * .map(_.capitalize)
	 * .reduce(_+","+_)
	 * 
	 * java8实现
	 * */
	public String cleanNames8(List<String> names) {
		if(names==null)return "";
		return names.stream()
				.filter(name->name.length()>1)
				.map(name->capitalizeString(name))
				.collect(Collectors.joining(","));//collect取代了reduce
	}
	
	/*
	 * Groovy实现
	 * public static String cleanUpNames(listOfNames){
	 * lsitOfNames
	 * .findAll{it.length()>1}
	 * .collect{it.capitalize()}//相当与map
	 * .join ','
	 * }
	 * 
	 * Lisp家族的Clojure实现//嵌套结构,由内向外执行
	 * (def process [list-of-emps]
	 * 	(reduce str (interpos ","
	 * 		(map s/capitalize(filter #(<1(count %)) list-of-emps)))))
	 * 
	 * 
	 * thread-last宏(即->>符号)
	 * (defn process2 [list-of-emps]
	 * (->> lsit-of-emps
	 * (filter #(<! (count %)))
	 * (map s/capitalize)
	 * (insterpose ",")
	 * (reduce str)))
	 * */
	
	
	/*
	 * Scala的并行化处理过程
	 * var parallelResult= employees
	 * .par
	 * .filter(_.length()>1)
	 * .map(_.capitalize)
	 * .reduce(_+","+_)
	 * 
	 * Java8实现的并行化处理过程:
	 * */
	
	public String cleanNamesP(List<String> names) {
		if(names==null)return "";
		return names
				.parallelStream()
				.filter(name->name.length()>1)
				.map(name->capitalizeString(name))
				.collect(Collectors.joining(","));
	}
}
