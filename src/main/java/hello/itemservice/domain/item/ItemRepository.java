package hello.itemservice.domain.item;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository //@ComponentScan 의 대상이 됨
public class ItemRepository {

    private static final Map<Long, Item> store = new HashMap<>(); //static
    private static long sequence = 0L; //static

    //저장 기능
    public Item save(Item item){
        item.setId(++sequence);
        store.put(item.getId(), item);
        return item;
    }

    //조회 기능
    public Item findById(Long id){
        return store.get(id);
    }

    //전체 조회 기능
    public List<Item> findAll(){
        return new ArrayList<>(store.values());
    }

    //업데이트 기능
    public void update(Long itemId, Item updateParam){
        Item findItem = findById(itemId);
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());
    }

    //테스트용
    public void clearStore(){
        store.clear();
    }
}
