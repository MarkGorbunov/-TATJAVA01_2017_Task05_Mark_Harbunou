package gorbunov.epam.parser;


import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mark_Harbunou on 2/16/2017.
 */
public class MenuSaxHandler extends DefaultHandler {
    private List<Food> foodList = new ArrayList<Food>();
    private Food food;
    private StringBuilder text;

    public List<Food> getFoodList() {
        return foodList;
    }

    public void startDocument() throws SAXException {
        System.out.println("parsing started");
    }

    public void endDocument() throws SAXException {
        System.out.println("parsing ended");
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("Start element->" +
                "uri: " + uri +
                ", local name: " + localName +
                ", qName; " + qName);

        text = new StringBuilder();
        if (qName.equals("dish")) {
            food = new Food();
            food.setId(Integer.parseInt(attributes.getValue("id")));
        }
    }

    public void characters(char[] buffer, int start, int length) {
        text.append(buffer, start, length);
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        MenuTagName menuTagName = MenuTagName.valueOf(qName.toUpperCase());
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
        throw(e);
    }
}
