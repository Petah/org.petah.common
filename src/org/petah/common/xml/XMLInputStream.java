/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.petah.common.xml;

import java.io.IOException;
import java.io.InputStream;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

/**
 *
 * @author Petah
 */
public class XMLInputStream {

    private InputStream inputStream;

    public XMLInputStream(InputStream in) throws IOException {
        this.inputStream = in;
    }

    /**
     * This method loads an object from the specified XML file. Example: <br /><br />
     * <code>
     * ArrayList list = (ArrayList)Easy.load(new FileInputStream("list.xml"));
     * </code>
     * @param inputStream The XML input stream where the object is stored.
     * @return The object read from the XML file
     * @throws JDOMException
     * @throws IOException
     */
    public Object readObject() throws JDOMException, IOException {
        SAXBuilder builder = new SAXBuilder();
        Document doc = builder.build(inputStream);
        Element el = doc.getRootElement();
        ObjectReader reader = new SimpleReader();
        return reader.read(el);
    }
}
