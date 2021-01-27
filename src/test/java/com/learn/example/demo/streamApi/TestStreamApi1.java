package com.learn.example.demo.streamApi;

import com.learn.example.entity.User;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * @author: csl
 * @description:. stream操作的三个步骤
 * 1.创建stream
 * 2.中间操作
 * 3.终止操作
 * @date: 2021-01-27 00:40
 */

public class TestStreamApi1 {
    List<User> userList = Arrays.asList(
            new User("张三", 18, 2000, User.Status.FREE),
            new User("李四", 38, 2000, User.Status.BUSY),
            new User("王五", 50, 3000, User.Status.VOCATION),
            new User("赵柳", 16, 4000, User.Status.BUSY),
            new User("田七", 8, 10000, User.Status.FREE)
    );

    /**
     * 创建流
     */
    @Test
    void name() {
        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();
//        stream.
        Stream<String> stringStream = list.parallelStream();
//        stringStream.forEach();


        User[] users = new User[10];
//        users.
        Stream<User> stream1 = Arrays.stream(users);

        Stream<User> users1 = Stream.of(users);
//        users1.
    }


    /**
     * 终止流
     */
    @Test
    void name1() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        Stream<Integer> stream = list.stream();
        //   stream.forEach(System.out::println);   下面的和这句话等同，方法引用
        stream.forEach(System.out::println);

    }


    /**
     * 筛选切片
     */
    @Test
    void name3() {
        Stream<User> userStream = userList.stream()
                .filter(e -> {
                    System.out.println("中间操作执行了");
                    return e.getAge() >= 18;
                })
                .limit(12);
        userStream.forEach(System.out::println);


    }

    @Test
    void test5() {
        List<String> list = Arrays.asList("aaa", "bbb", "ccc");
        list.stream()
                .map(str -> str.toUpperCase())
                .forEach(str -> System.out.println(str));


        userList.stream()
                .map(user -> user.getUsername() + " -- " + user.getSalary())
                .forEach(x -> System.out.println(x));
    }


    /**
     * 排序
     */
    @Test
    void testSort() {
        /**
         * 先按照年龄排序，再按照薪资排序
         */
        userList.stream()
                .sorted((e1, e2) -> {
                    if (e1.getAge().equals(e2.getAge())) {
                        return e1.getSalary().compareTo(e2.getSalary());
                    } else {
                        return -e1.getAge().compareTo(e2.getAge());  //加了个-表示倒叙
                    }
                })
                .forEach(System.out::println);
        ;
    }

    /**
     * 终止操作--------
     */
    @Test
    void test6() {
        /**
         * 是否匹配所有元素
         */
        boolean b = userList.stream()
                .allMatch(e -> e.getStatus().equals(User.Status.FREE));
        System.out.println(b);

        /**
         * 是否至少匹配一个元素
         */
        boolean b1 = userList.stream()
                .anyMatch(e -> e.getStatus().equals(User.Status.FREE));
        System.out.println(b1);

        /**
         * 返回第一个元素，是optional类型的
         */
        Optional<User> op = userList.stream()
                .sorted((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()))
                .findFirst();
        System.out.println(op.get());

        /**
         * 返回当前流中的任意一个 空闲的 元素
         */
        Optional<User> any = userList.parallelStream()   //获取并行流，如果是上面的串行的流，一个个来的话，每次都是第一个，定死了
                .filter(e -> e.getStatus().equals(User.Status.FREE))   //过滤所有是空闲的才去取
                .findAny();    //获取任意一个
        System.out.println("任意一个空闲的     " + any.get());

        /**
         * 返回流中元素的总个数
         */
        long count = userList.stream()
                .count();
        System.out.println(count);


        /**
         * 查找最大的值
         */
        Optional<User> max = userList.stream()
                .max((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println(max.get());

        /**
         * 查看工资最小的  值！！！
         */
        Integer salary = userList.stream()
                .min((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()))
                .get()
                .getSalary();
        System.out.println(salary);

        Optional<Integer> minOp = userList.stream()
                .map(u -> u.getSalary())
//                .min(Double::compare);
                .min((e1, e2) -> Double.compare(e1, e2));   //这个恶心，因为上面一行返回的是Integer
        System.out.println(minOp.get());

    }

    @Test
    void test7() {
        /**
         * 规约：反复进行操作   这里实现求和
         */
        Optional<Integer> sumOp = userList.stream()
                .map(u -> u.getSalary())
                .reduce((x, y) -> Integer.sum(x, y));
        System.out.println(sumOp.get());
    }

    @Test
    void tseet8() {
        /**
         * 收集   案例：将所有的名字收集到一个数组里面
         */
        List<String> names = userList.stream()
                .map(u -> u.getUsername())   //先提取所有的名字
                .collect(Collectors.toList());  //调用Collectors提供的静态方法
        System.out.println(names);


        HashSet<String> set = userList.stream()
                .map(u -> u.getUsername())   //先提取所有的名字
                .collect(Collectors.toCollection(HashSet::new));//调用Collectors提供的静态方法
        System.out.println(set);   //放到了hashset中

        LinkedHashSet<String> linkedHashSet = userList.stream()
                .map(u -> u.getUsername())   //先提取所有的名字
                .collect(Collectors.toCollection(LinkedHashSet::new));//调用Collectors提供的静态方法
        System.out.println(linkedHashSet);

        Double ave = userList.stream()
                .collect(Collectors.averagingInt(u -> u.getSalary()));
        System.out.println(ave);


        /**
         * 分组
         */
        Map<User.Status, List<User>> val1 = userList.stream()
                .collect(Collectors.groupingBy(u -> u.getStatus()));
        System.out.println(val1);


        /**
         * 分区
         *
         */
        Map<Boolean, List<User>> collect = userList.stream()
                .collect(Collectors.partitioningBy(u -> u.getSalary() > 5000));
        System.out.println(collect);
    }


    @Test
    void testForkJoin() {
        /**
         * 测试并行流 forkjoin
         */
        Instant start = Instant.now();

        long sum = LongStream.rangeClosed(0, 100000000000L)
                .parallel()
                .reduce(0, Long::sum);
        System.out.println(sum);    //932356074711512064
        Instant end = Instant.now();
        System.out.println("耗时：  " + Duration.between(start, end).toMillis());   //4565

    }

    private String naaa;

    @Test
    void fname() {
//        Optional<Object> o = Optional.of(null);
//        private
        System.out.println(naaa);

    }
}