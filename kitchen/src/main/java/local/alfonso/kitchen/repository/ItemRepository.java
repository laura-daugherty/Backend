package local.alfonso.kitchen.repository;

import local.alfonso.kitchen.models.Item;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemRepository extends CrudRepository<Item, Long>
{
    List<Item> findByItemcategory(String category);

    List<Item> findByUserUserid(Long id);
}
