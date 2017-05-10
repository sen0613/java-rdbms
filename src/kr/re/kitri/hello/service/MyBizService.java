package kr.re.kitri.hello.service;

import java.util.List;
import java.util.OptionalDouble;

/**
 * Created by danawacomputer on 2017-05-08.
 */
public class MyBizService {
    public static int sumIntList(List<Integer> intList) {
//        int sum = 0;
//        for(Integer e : intList) {
//            sum += e;
//        }
//        return sum;

        int result =
                intList.stream()
                        .mapToInt(x -> x.intValue()) // .mapToInt(Integer::intValue)
                        .sum();
        return result;
    }


    public static double averageIntList(List<Integer> intList) throws Exception {
//        double sum = 0;
//        for (Integer e : intList) {
//            sum += e;
//        }
//        return sum / intList.size();

        OptionalDouble result = intList.stream()
                .mapToInt(Integer::intValue)
                .average();
        if (result.isPresent()) {
            return result.getAsDouble();
        } else {
            throw new Exception("데이터가 없어서 평균을 구할 수 없습니다.");
        }
    }

}
