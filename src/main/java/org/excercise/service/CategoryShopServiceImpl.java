package org.excercise.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import org.excercise.domain.Location;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CategoryShopServiceImpl implements CategoryShopService {
    
    private static final Logger log = LoggerFactory.getLogger(CategoryShopServiceImpl.class);
    public static HashMap<Integer, Category> CategoryShopMap = loadCategoryAddress();
    static int index = 1;

    
    public CategoryShopServiceImpl(@Value("${csvfile}") String csvfile){
        if(csvfile == null){
            return;
        }

        if(CategoryShopMap == null){
            CategoryShopMap = new HashMap<Integer, Category>();
            loadCsv(csvfile);
            log.into("CSV File uploaded ...");
        }
    }

    static HashMap<Integer, Category> loadCategoryShop(){
        return CategoryShopMap;
    }

    public int createCategoryShop(Category cat){
        cat.setId(++index);
        CategoryShopMap.put(index, cat);
        return index;
    }

    public Category getCategoryShop(int _id){
        if(!CategoryShopMap.containsKey(_id)){
            return null;
        }
        return CategoryShopMap.get(_id);
    }

    public Category updateCategoryShop(int _id, Category cat){
        if(!CategoryShopMap.containsKey(_id)){
            return null;
        }
        cat.setId(_id);
        CategoryShopMap.put(_id, cat);
        return cat;
    }

    public String deleteCategoryShop(int _id){
        if(!CategoryShopMap.containsKey(_id)){
            return null;
        }
        CategoryShopMap.remove(_id);
        return "Success";
    }

    public void loadCsv(String _filename){
        BufferedReader br = null;
        String line = null;
        int count = 0;

        try{
            br = new BufferedReader(new FileReader(_filename));
            while((line = br.readLine()) != null){
                // use comma as separator
                String[] cat = line.split(",");
                index=Integer.valueOf(cat[0].trim());
                Category cat = new Category(index, cat[1].trim(), cat[2].trim(), Double.valueOf(cat[3].trim()), Double.valueOf(cat[4].trim()));
                CategoryShopMap.put(index, category);
                count++;
            }
            log.info("Total records uploaded:"+ count);
        }catch(FileNotFoundException e){
            e.printStackTrack();
        }catch(IOException e){
            e.printStackTrack();
        } finally {
            if(br != null){
                try{
                    br.close();
                }catch(IOException e){
                    e.printStackTrack();
                }
            }
        }
    }
    
}