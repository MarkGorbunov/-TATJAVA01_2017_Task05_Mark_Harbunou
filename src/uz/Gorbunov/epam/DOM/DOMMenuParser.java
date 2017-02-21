package uz.Gorbunov.epam.dom;

import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import uz.Gorbunov.epam.bean.Food;
import uz.Gorbunov.epam.bean.MenuTagName;
import uz.Gorbunov.epam.dom.exception.DOMException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Mark_Harbunou on 2/20/2017.
 */
public class DOMMenuParser {
    public void domParser() throws DOMException {
        HashMap<Category, ArrayList<Food>> foodCategory = new HashMap<Category, ArrayList<Food>>();

        for(Category i : Category.values()) {
            foodCategory.put(i,getfoodList(i));
        }

        for (HashMap.Entry<Category, ArrayList<Food>> category : foodCategory.entrySet()) {
            System.out.println(category.getKey());
            for (Food dish : category.getValue()) {
                System.out.println(dish.toString());
            }
        }
    }


    private ArrayList<Food> getfoodList(Category category) throws DOMException {
        Food food;
        ArrayList<Food> foodList = new ArrayList<Food>();

        DOMParser parser = new DOMParser();
        try {
            parser.parse("menu1.xml");
        } catch (SAXException e) {
           throw  new DOMException("smth wrong with DOM parser",e);
        } catch (IOException e) {
            throw  new DOMException("smth wrong with IOE in DOM parser",e);
        }
        Document document = parser.getDocument();
        Element root = document.getDocumentElement();

        NodeList categoryNode = root.getElementsByTagName(category.toString().toLowerCase());
        Element cn = (Element) categoryNode.item(0);
        NodeList categoryNodeDish = cn.getElementsByTagName(MenuTagName.DISH.toString().toLowerCase());

        for (int i = 0; i < categoryNodeDish.getLength(); i++) {
            Element coldSnacksDishElement = (Element) categoryNodeDish.item(i);
            food = new Food();
            food.setId(Integer.parseInt(coldSnacksDishElement.getAttribute("id")));
            food.setPhoto(getTagValue(coldSnacksDishElement, MenuTagName.PHOTO.toString().toLowerCase()).getTextContent().trim());
            food.setTitle(getTagValue(coldSnacksDishElement, MenuTagName.TITLE.toString().toLowerCase()).getTextContent().trim());
            food.setDescription(getTagValue(coldSnacksDishElement, MenuTagName.DESCRIPTION.toString().toLowerCase()).getTextContent().trim());
            food.setPortion(getTagValue(coldSnacksDishElement, MenuTagName.PORTION.toString().toLowerCase()).getTextContent().trim());
            food.setPrice(getTagValue(coldSnacksDishElement, MenuTagName.PRICE.toString().toLowerCase()).getTextContent().trim());
            foodList.add(food);
        }
        return  foodList;
    }

    private static Element getTagValue(Element element, String tagName) {
        NodeList nlist = element.getElementsByTagName(tagName);
        Element tagValue = (Element) nlist.item(0);
        return tagValue;
    }


}
