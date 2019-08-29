package time.SpringBootElasticsearch;

import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.elasticsearch.index.query.QueryBuilders;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.*;
import org.springframework.test.context.junit4.SpringRunner;
import time.SpringBootElasticsearch.bean.Article;
import time.SpringBootElasticsearch.bean.Book;
import time.SpringBootElasticsearch.bean.User;
import time.SpringBootElasticsearch.repository.BookRepository;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ElasticsearchApplicationTests {
   // jestClient用法
    @Autowired
    JestClient jestClient;

    // 给ES中保存一个文档
    @Test
    public void contextLoads() {
        Article article = new Article();
        article.setId(1);
        article.setTitle("好消息");
        article.setAuthor("lei");
        article.setContent("Hello World");

        // 构建一个index索引
        Index index = new Index.Builder(article).index("words").type("news").build();
        try {
            // 执行
            jestClient.execute(index);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 搜索ES
    @Test
    public void test01(){
        String json = "{\n" +
                "    \"query\" : {\n" +
                "        \"match\" : {\n" +
                "            \"content\" : \"hello\"\n" +
                "        }\n" +
                "    }\n" +
                "}";
        Search search = new Search.Builder(json).addIndex("words").addType("news").build();
        try {
            SearchResult result = jestClient.execute(search);
            System.out.println(result.getJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // SpringData Elasticsearch用法
    // 用法1：编写接口进行测试
    // 注入BookRepository
    @Autowired
    BookRepository bookRepository;
    @Test
    public void test2(){
        Book book = new Book();
        book.setId(1);
        book.setAuthor("兰德尔-布莱恩特");
        book.setBookName("深入理解计算机系统");
        bookRepository.index(book);
    }
    @Test
    public void test3(){
        // 根据ID进行查找
        Optional<Book> boot = bookRepository.findById(1);
        System.out.println(boot);
    }

    // 用法2：elasticTemplate
    @Autowired
    ElasticsearchTemplate elasticsearchTemplate;
    // 插入数据
    @Test
    public void test4(){
        User user = new User();
        user.setId(01);
        user.setAge(15);
        user.setName("张三");
        IndexQuery indexQuery = new IndexQueryBuilder().withId("2").withObject(user).build();
        elasticsearchTemplate.index(indexQuery);

    }
    // 查询数据
    @Test
    public void test5(){
        SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(QueryBuilders.matchQuery("name","张三"))
                .build();
        List<User> users = elasticsearchTemplate.queryForList(searchQuery, User.class);
        System.out.println(users);
    }
}