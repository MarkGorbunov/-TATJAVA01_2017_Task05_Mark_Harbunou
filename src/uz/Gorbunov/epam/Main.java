package uz.Gorbunov.epam;


import org.xml.sax.SAXException;

import uz.Gorbunov.epam.DOM.DOMMenuParser;
import uz.Gorbunov.epam.SAX.SAXParser;
import uz.Gorbunov.epam.StAX.StAXParser;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws SAXException, IOException, XMLStreamException {
        /*SAXParser saxParser = new SAXParser();
        saxParser.saxParser();
        StAXParser stAXParser = new StAXParser();
stAXParser.staxParser();*/
        DOMMenuParser domMenuParser = new DOMMenuParser();
        domMenuParser.domParser();
    }
}
