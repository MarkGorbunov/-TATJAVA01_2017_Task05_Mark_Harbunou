package uz.Gorbunov.epam.StAX;

import uz.Gorbunov.epam.bean.Food;
import uz.Gorbunov.epam.bean.MenuTagName;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.*;

/**
 * Created by Mark_Harbunou on 2/20/2017.
 */
public class StAXParser {
    public void staxParser() throws FileNotFoundException, XMLStreamException {
        XMLInputFactory factory = XMLInputFactory.newInstance();
        InputStream input = new FileInputStream("menu1.xml");
        XMLStreamReader reader = factory.createXMLStreamReader(input);
        HashMap<MenuTagName, ArrayList<Food>> menu = process(reader);

        for (HashMap.Entry<MenuTagName, ArrayList<Food>> category : menu.entrySet()) {
            System.out.println(category.getKey());
            for (Food dish : category.getValue()) {
                System.out.println(dish.toString());
            }
        }
        // menu.forEach( (k,v) -> System.out.println("Key: " + k + ": Value: " + v));
    }

    private static HashMap<MenuTagName, ArrayList<Food>> process(XMLStreamReader reader) throws XMLStreamException {
        ArrayList<Food> foodList = new ArrayList<Food>();
        HashMap<MenuTagName, ArrayList<Food>> foodCategory = new HashMap<MenuTagName, ArrayList<Food>>();
        Food food = null;
        MenuTagName menuTagName = null;



        while(reader.hasNext()) {
            int type = reader.next();
            switch (type) {


                case XMLStreamConstants.START_ELEMENT:
                    menuTagName = MenuTagName.valueOf(reader.getLocalName().toUpperCase());
                    switch (menuTagName) {
                        case DISH:
                           food = new Food();
                           Integer id = Integer.parseInt(reader.getAttributeValue(null,"id"));
                           food.setId(id);
                            break;
                    }
                    break;


                case XMLStreamConstants.CHARACTERS:
                        String text = reader.getText().trim();
                        if(text.isEmpty()) {
                            break;
                        }
                        switch (menuTagName) {
                            case PHOTO:
                                food.setPhoto(text.toString());
                                break;
                            case TITLE:
                                food.setTitle(text.toString());
                                break;
                            case DESCRIPTION:
                                food.setDescription(text.toString());
                                break;
                            case PORTION:
                                food.setPortion(text.toString());
                                break;
                            case PRICE:
                                food.setPrice(text.toString());
                                break;
                        }
                        break;


                case  XMLStreamConstants.END_ELEMENT:
                        menuTagName = MenuTagName.valueOf(reader.getLocalName().toUpperCase());
                switch (menuTagName) {
                    case DISH:
                        foodList.add(food);
                        break;
                    case ATTACHMENT:
                        ArrayList<Food> att=  new ArrayList<Food>();
                        att.addAll(foodList);
                        foodCategory.put(menuTagName.ATTACHMENT,att);
                        foodList.clear();
                        break;
                    case BREAKFASTS:
                        ArrayList<Food> br =  new ArrayList<Food>();
                        br.addAll(foodList);
                        foodCategory.put(menuTagName.BREAKFASTS,br);
                        foodList.clear();
                        break;
                    case COLDSNACKS:
                        ArrayList<Food> cold =  new ArrayList<Food>();
                        cold.addAll(foodList);
                        foodCategory.put(menuTagName.COLDSNACKS,cold);
                        foodList.clear();
                        break;
                    case HOTSNACKS:
                        ArrayList<Food> hot =  new ArrayList<Food>();
                        hot.addAll(foodList);
                        foodCategory.put(menuTagName.HOTSNACKS,hot);
                        foodList.clear();
                        break;
                    case SALADS:
                        ArrayList<Food> sal =  new ArrayList<Food>();
                        sal.addAll(foodList);
                        foodCategory.put(menuTagName.SALADS,sal);
                        foodList.clear();
                        break;
                    case SOUPS:
                        ArrayList<Food> soup =  new ArrayList<Food>();
                        soup.addAll(foodList);
                        foodCategory.put(menuTagName.SOUPS,soup);
                        foodList.clear();
                        break;
                    case FISHDISHES:
                        ArrayList<Food> fish =  new ArrayList<Food>();
                        fish.addAll(foodList);
                        foodCategory.put(menuTagName.FISHDISHES,fish);
                        foodList.clear();
                        break;
                    case MEATDISHES:
                        ArrayList<Food> meat =  new ArrayList<Food>();
                        meat.addAll(foodList);
                        foodCategory.put(menuTagName.MEATDISHES,meat);
                        foodList.clear();
                        break;
                    case GRILL:
                        ArrayList<Food> grill =  new ArrayList<Food>();
                        grill.addAll(foodList);
                        foodCategory.put(menuTagName.GRILL,grill);
                        foodList.clear();
                        break;
                    case FROMCHEF:
                        ArrayList<Food> chef =  new ArrayList<Food>();
                        chef.addAll(foodList);
                        foodCategory.put(menuTagName.FROMCHEF,chef);
                        foodList.clear();
                        break;
                    case DESERT:
                        ArrayList<Food> des =  new ArrayList<Food>();
                        des.addAll(foodList);
                        foodCategory.put(menuTagName.DESERT,des);
                        foodList.clear();
                        break;
                }
            }
        }
        return foodCategory;
    }
}
