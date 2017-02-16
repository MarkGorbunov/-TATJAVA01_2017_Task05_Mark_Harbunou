package gorbunov.epam;

import gorbunov.epam.parser.Food;
import gorbunov.epam.parser.MenuSaxHandler;
import gorbunov.epam.parser.MenuTagName;
import org.xml.sax.*;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SAXException, IOException {
        XMLReader xmlReader = XMLReaderFactory.createXMLReader();
        MenuSaxHandler handler = new MenuSaxHandler();
        xmlReader.setContentHandler(handler);
        xmlReader.parse(new InputSource("menu1.xml"));

        xmlReader.setFeature("http://www.xml.org/sax/features/validation", true);

        xmlReader.setFeature("http://www.xml.org/sax/features/namespaces", true);

        List<Food> menu = handler.getFoodList();

        for (Food food : menu) {
            System.out.println(food.getId());
        }
    }
}
