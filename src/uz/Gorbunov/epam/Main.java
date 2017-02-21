package uz.Gorbunov.epam;


import org.xml.sax.SAXException;

import uz.Gorbunov.epam.dom.DOMMenuParser;
import uz.Gorbunov.epam.dom.exception.DOMException;
import uz.Gorbunov.epam.stax.exception.StAXException;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws SAXException, StAXException, DOMException {
        /*SAXParser saxParser = new SAXParser();
        saxParser.saxParser();
        StAXParser stAXParser = new StAXParser();
stAXParser.staxParser();*/
        DOMMenuParser domMenuParser = new DOMMenuParser();
        domMenuParser.domParser();
    }
}
