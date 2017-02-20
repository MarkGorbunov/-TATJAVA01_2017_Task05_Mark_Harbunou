package uz.Gorbunov.epam.DOM;

import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import uz.Gorbunov.epam.bean.Food;
import uz.Gorbunov.epam.bean.MenuTagName;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Mark_Harbunou on 2/20/2017.
 */
public class DOMMenuParser {
    public void domParser() throws IOException, SAXException {
        Food food = null;
        ArrayList<Food> foodList = new ArrayList<Food>();
        HashMap<MenuTagName, ArrayList<Food>> foodCategory = new HashMap<MenuTagName, ArrayList<Food>>();

        DOMParser parser = new DOMParser();
        parser.parse("menu1.xml");
        Document document = parser.getDocument();
        Element root = document.getDocumentElement();


        NodeList coldSnacks = root.getElementsByTagName(MenuTagName.COLDSNACKS.toString().toLowerCase());
        Element cl = (Element) coldSnacks.item(0);
        NodeList coldSnacksDish = cl.getElementsByTagName(MenuTagName.DISH.toString().toLowerCase());


        for (int i = 0; i < coldSnacksDish.getLength(); i++) {
            Element coldSnacksDishElement = (Element) coldSnacksDish.item(i);
            HashMap<MenuTagName, ArrayList<Food>> coldSnack = new HashMap<MenuTagName, ArrayList<Food>>();
            food = new Food();
            food.setId(Integer.parseInt(coldSnacksDishElement.getAttribute("id")));
            food.setPhoto(getTagValue(coldSnacksDishElement, MenuTagName.PHOTO.toString().toLowerCase()).getTextContent().trim());
            food.setTitle(getTagValue(coldSnacksDishElement, MenuTagName.TITLE.toString().toLowerCase()).getTextContent().trim());
            food.setDescription(getTagValue(coldSnacksDishElement, MenuTagName.DESCRIPTION.toString().toLowerCase()).getTextContent().trim());
            food.setPortion(getTagValue(coldSnacksDishElement, MenuTagName.PORTION.toString().toLowerCase()).getTextContent().trim());
            food.setPrice(getTagValue(coldSnacksDishElement, MenuTagName.PRICE.toString().toLowerCase()).getTextContent().trim());
            foodList.add(food);
            if (i == coldSnacksDish.getLength() - 1) {
                ArrayList<Food> cold = new ArrayList<Food>();
                cold.addAll(foodList);
                foodCategory.put(MenuTagName.COLDSNACKS, cold);
                foodList.clear();
            }
        }


        for (HashMap.Entry<MenuTagName, ArrayList<Food>> category : foodCategory.entrySet()) {
            System.out.println(category.getKey());
            for (Food dish : category.getValue()) {
                System.out.println(dish.toString());
            }
        }
    }


    private static Element getTagValue(Element element, String tagName) {
        NodeList nlist = element.getElementsByTagName(tagName);
        Element tagValue = (Element) nlist.item(0);
        return tagValue;
    }


}
