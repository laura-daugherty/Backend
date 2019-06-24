package local.alfonso.kitchen.services;

import local.alfonso.kitchen.models.Item;
import local.alfonso.kitchen.models.User;
import local.alfonso.kitchen.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service(value = "itemService")
public class ItemServiceImpl implements ItemService
{
    @Autowired
    private ItemRepository itemrepo;



    public List<Item> findItemsByCategory(String category)
    {
        List<Item> categorylist = new ArrayList<>();
        categorylist = itemrepo.findByItemcategory(category);
        return categorylist;
    }

    @Override
    public List<Item> findAll()
    {
        List<Item> list = new ArrayList<>();
        itemrepo.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Item findItemById(long id)
    {
        return itemrepo.findById(id).orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));
    }

    @Override
    public void delete(long id)
    {
        if (itemrepo.findById(id).isPresent())
        {
            itemrepo.deleteById(id);
        } else
        {
            throw new EntityNotFoundException(Long.toString(id));
        }
    }

    @Transactional
    @Override
    public Item save(Item item)
    {
        Item newItem = new Item();

        newItem.setItemname(item.getItemname());
        newItem.setItemcategory(item.getItemcategory());
        newItem.setItemquantity(item.getItemquantity());
//        newItem.setItem_user(item.getItem_user());

        return itemrepo.save(newItem);
    }

    @Override
    public Item findByName(String name)
    {
        Item it = itemrepo.findByItemnameIgnoreCase(name);

        if (it != null)
        {
            return it;
        } else
        {
            throw new EntityNotFoundException(name);
        }
    }

    //    @Transactional
//    @Override
//    public Item update(Item item, long id)
//    {
//
//        Item currentItem = itemrepo.findById(id).orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));
//
//        if (currentItem != null && id == currentItem.getItemid())
//        {
//            if (item.getItemname() != null)
//            {
//                currentItem.setItemname(item.getItemname());
//            }
//
//            if (item.getItemcategory() != null)
//            {
//                currentItem.setItemcategory(item.getItemcategory());
//            }
//
//            if (item.getItemquantity() != currentItem.getItemquantity())
//            {
//                currentItem.setItemquantity(item.getItemquantity());
//            }
//
//            if (item.get() != null && item.getItem_user() != currentItem.getItem_user())
//            {
//                currentItem.setItem_user(item.getItem_user());
//            }
//
//            return itemrepo.save(currentItem);
//        } else
//        {
//            throw new EntityNotFoundException(Long.toString(id) + "Not current item.");
//        }
//
//    }


}
