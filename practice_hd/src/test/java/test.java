import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
public class test {
    // @Autowired
    RedisTemplate<String,Object> redisTemplate;
    @Test
    public void Test(){
        redisTemplate.opsForValue().set("name","张三",10);
        Object name = redisTemplate.opsForValue().get("name");
        System.out.println(name.toString());
    }
}
