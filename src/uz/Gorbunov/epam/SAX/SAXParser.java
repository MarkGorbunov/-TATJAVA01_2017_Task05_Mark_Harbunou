package uz.Gorbunov.epam.SAX;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import uz.Gorbunov.epam.bean.Food;
import uz.Gorbunov.epam.bean.MenuTagName;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mark_Harbunou on 2/20/2017.
 */
public class SAXParser {
    public void saxParser() throws SAXException, IOException {
        XMLReader xmlReader = XMLReaderFactory.createXMLReader();
        MenuSaxHandler handler = new MenuSaxHandler();
        xmlReader.setContentHandler(handler);
        xmlReader.parse(new InputSource("menu1.xml"));


        Map<MenuTagName, ArrayList<Food>> menu = handler.getFoodList();

        for (HashMap.Entry<MenuTagName, ArrayList<Food>> category : menu.entrySet()) {
            System.out.println(category.getKey());
            for (Food dish : category.getValue()) {
                System.out.println(dish.toString());
            }
        }

        // menu.forEach( (k,v) -> System.out.println("Key: " + k + ": Value: " + v));

    }
}
