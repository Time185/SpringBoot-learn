package time.SpringBootElasticsearch.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import time.SpringBootElasticsearch.bean.Book;

/**
 * @author Time
 * @created 2019/8/29
 */
public interface BookRepository extends ElasticsearchRepository<Book,Integer> {
}
