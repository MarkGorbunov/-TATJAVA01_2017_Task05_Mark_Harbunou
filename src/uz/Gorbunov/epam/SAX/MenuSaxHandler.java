package uz.Gorbunov.epam.sax;


import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import uz.Gorbunov.epam.bean.Food;
import uz.Gorbunov.epam.bean.MenuTagName;

import java.util.*;

/**
 * Created by Mark_Harbunou on 2/16/2017.
 */
public class MenuSaxHandler extends DefaultHandler {
    private ArrayList<Food> foodList = new ArrayList<Food>();
    private Map<MenuTagName, ArrayList<Food>> foodCategory = new HashMap<MenuTagName, ArrayList<Food>>();
    private Food food;
    private StringBuilder text;

    public Map<MenuTagName, ArrayList<Food>> getFoodList() {
        return foodCategory;
    }

    public void startDocument() throws SAXException {
        System.out.println("parsing started");
    }

    public void endDocument() throws SAXException {
        System.out.println("parsing ended");
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        text = new StringBuilder();
        if (qName.equals("dish")) {
            food = new Food();
            food.setId(Integer.parseInt(attributes.getValue("id")));
        }
    }

    public void characters(char[] buffer, int start, int length) {
        text.append(buffer,start,length);

    }


    public void endElement(String uri, String localName, String qName) throws SAXException {
        MenuTagName menuTagName = MenuTagName.valueOf(qName.toUpperCase());
        try {
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
                case DISH:
                    foodList.add(food);
                    food = null;
                    break;
                case ATTACHMENT:
                    ArrayList<Food> att = new ArrayList<Food>();
                    att.addAll(foodList);
                    foodCategory.put(menuTagName.ATTACHMENT, att);
                    foodList.clear();
                    break;
                case BREAKFASTS:
                    ArrayList<Food> br = new ArrayList<Food>();
                    br.addAll(foodList);
                    foodCategory.put(menuTagName.BREAKFASTS, br);
                    foodList.clear();
                    break;
                case COLDSNACKS:
                    ArrayList<Food> cold = new ArrayList<Food>();
                    cold.addAll(foodList);
                    foodCategory.put(menuTagName.COLDSNACKS, cold);
                    foodList.clear();
                    break;
                case HOTSNACKS:
                    ArrayList<Food> hot = new ArrayList<Food>();
                    hot.addAll(foodList);
                    foodCategory.put(menuTagName.HOTSNACKS, hot);
                    foodList.clear();
                    break;
                case SALADS:
                    ArrayList<Food> sal = new ArrayList<Food>();
                    sal.addAll(foodList);
                    foodCategory.put(menuTagName.SALADS, sal);
                    foodList.clear();
                    break;
                case SOUPS:
                    ArrayList<Food> soup = new ArrayList<Food>();
                    soup.addAll(foodList);
                    foodCategory.put(menuTagName.SOUPS, soup);
                    foodList.clear();
                    break;
                case FISHDISHES:
                    ArrayList<Food> fish = new ArrayList<Food>();
                    fish.addAll(foodList);
                    foodCategory.put(menuTagName.FISHDISHES, fish);
                    foodList.clear();
                    break;
                case MEATDISHES:
                    ArrayList<Food> meat = new ArrayList<Food>();
                    meat.addAll(foodList);
                    foodCategory.put(menuTagName.MEATDISHES, meat);
                    foodList.clear();
                    break;
                case GRILL:
                    ArrayList<Food> grill = new ArrayList<Food>();
                    grill.addAll(foodList);
                    foodCategory.put(menuTagName.GRILL, grill);
                    foodList.clear();
                    break;
                case FROMCHEF:
                    ArrayList<Food> chef = new ArrayList<Food>();
                    chef.addAll(foodList);
                    foodCategory.put(menuTagName.FROMCHEF, chef);
                    foodList.clear();
                    break;
                case DESERT:
                    ArrayList<Food> des = new ArrayList<Food>();
                    des.addAll(foodList);
                    foodCategory.put(menuTagName.DESERT, des);
                    foodList.clear();
                    break;
                default:
                    break;
            }
        } catch (NullPointerException e) {
            throw new SAXException("error in tag",e);
        }
    }


    public void warning(SAXParseException e) throws SAXException {
        System.err.println("WARNING: line" + e.getLineNumber() + ":" + e.getMessage());
    }

    public void error(SAXParseException e) throws SAXException {
        System.err.println("ERROR: line" + e.getLineNumber() + ":" + e.getMessage());
    }

    public void fatalError(SAXParseException e) throws SAXException {
        System.err.println("FATAL: line" + e.getLineNumber() + ":" + e.getMessage());
        throw (e);
    }
}
