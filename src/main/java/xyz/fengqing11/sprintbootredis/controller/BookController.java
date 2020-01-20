package xyz.fengqing11.sprintbootredis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.fengqing11.sprintbootredis.pojo.Book;

@RestController
public class BookController {
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @GetMapping("/test")
    public void test() {
        ValueOperations<String, String> ops1 = stringRedisTemplate.opsForValue();
        ops1.set("name", "阿斯毒害");
        String name = ops1.get("name");
        System.out.println(name);

        ValueOperations ops2 = redisTemplate.opsForValue();
        Book b = new Book();
        b.setId(1);
        b.setName("你貌似懊悔");
        b.setAuthor("按实际就");
        ops2.set("b", b);
        Book book = (Book)ops2.get("b");
        System.out.println(book);
    }

}
