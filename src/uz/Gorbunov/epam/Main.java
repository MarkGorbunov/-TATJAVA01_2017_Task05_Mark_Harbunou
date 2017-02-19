package uz.Gorbunov.epam;


import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import uz.Gorbunov.epam.parser.Food;
import uz.Gorbunov.epam.parser.MenuSaxHandler;
import uz.Gorbunov.epam.parser.MenuTagName;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws SAXException, IOException {
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
