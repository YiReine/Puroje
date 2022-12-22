package Puroje.service;

import Puroje.entity.Category;
import Puroje.entity.Orderdetail;
import Puroje.entity.Vegetable;
import Puroje.repository.VegetableRepository;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

@Service
public class VegetableServiceImpl implements VegetableService {

    @Autowired
    private VegetableRepository vegetableRepository;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private OrderService orderService;
    
    @Override
    public Iterable<Vegetable> findAll() {
        
        return vegetableRepository.findAll();     
    }

    @Override
    public List<Vegetable> search(String term) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
    @Override
    public Optional<Category> findCateById(int id) {
        
        return categoryService.findById(id);     
    }
    
    @Override
    public Iterable<Category> findCate() {
        
        return categoryService.findAll();     
    }
    
    @Override
    public Iterable<Vegetable> findByPrice(String price) {
        
        Iterable<Vegetable> list = vegetableRepository.findAll();
        Iterator<Vegetable> list2 = list.iterator();
        char[] p = price.toCharArray();

        for(int i=0; i<p.length; i++){
            while(list2.hasNext()){
            Vegetable vege = list2.next();
            if(vege.getPrice()<=20000 && p[i]=='0'){
                break;
            }
            if(vege.getPrice()>20000 && vege.getPrice()<=60000 && p[i]=='1'){
                break;
            }
            if(vege.getPrice()>60000 && vege.getPrice()<=100000 && p[i]=='2'){
                break;
            }
            if(vege.getPrice()>100000 && p[i]=='3'){
                break;
            }
            list2.remove();
        }
            list = (Iterable<Vegetable>) list2;
            list2 = list.iterator();
        }
        return list;
            
    }
    
    @Override
    public Iterable<Vegetable> sort(String s) {
        
        Iterable<Vegetable> list = vegetableRepository.findAll();
        List<Vegetable> list2 = new ArrayList<Vegetable>(Streamable.of(list).toList());
        
        if(s.equals("cheap")){
            Collections.sort(list2, (v1, v2) -> {
                return (int)-(v2.getPrice()- v1.getPrice());
            });
        }
        else{
            Iterable<Orderdetail> odlist = orderService.findOrderdetailOnMonth();
            List<Orderdetail> odlist2 = new ArrayList<Orderdetail>
                                        (Streamable.of(odlist).toList());
            List<Orderdetail> odlist3 = new ArrayList<Orderdetail>();
            List listIDP = new ArrayList();
            
            for(int i=0;i<odlist2.size();i++){
            Orderdetail od = odlist2.get(i);
            if(listIDP.contains(od.getVegetableID())){
                int index = listIDP.indexOf(od.getVegetableID());
                Orderdetail od2 = odlist3.remove(index);
                od2.setPrice(od2.getQuantity()+od.getQuantity());
                odlist3.add(index,od2);
            }
            else{
                odlist3.add(od);
                listIDP.add(od.getVegetableID());
            }
            }
            Collections.sort(odlist3, (o1, o2) -> {
                return o2.getQuantity()- o1.getQuantity();
            });
            listIDP.removeAll(listIDP);
            for(int j=0; j<5; j++){
                if(j>=odlist3.size())
                    break;
                listIDP.add(odlist3.get(j).getVegetableID());
            }
            
                return vegetableRepository.findAllById(listIDP);
        }
        
        return list2;     
    }
}
