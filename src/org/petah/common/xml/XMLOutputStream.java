package org.petah.common.xml;

import java.io.IOException;
import org.jdom.Element;
import org.jdom.Document;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 * The <code>Easy</code> class is used to serialize/de-serialize objects to/from XML.
 * It has two static methods. The <code>save</code> method serializes an object to XML
 * and stores it in an XML file; and the <code>load</code> method de-serializes an object
 * from an XML file.
 *
 * @author Simon M. Lucas <br />
 *         Carlos R. Jaimez Gonzalez
 * @version Easy.java - 1.0
 */
public class XMLOutputStream {

    private OutputStream outputStream;

    public XMLOutputStream(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    /**
     * This method saves an object to the specified output stream. Example: <br /><br />
     * <code>
     * ArrayList list = new ArrayList();  <br />
     * list.add(new Product("Beans", 500)); <br />
     * list.add(new Product("Bread", 200)); <br />
     * Easy.save(list, new FileOutputStream("list.xml"));
     * </code>
     * @param ob
     * @param outputStream
     * @throws IOException
     */
    public void writeObject(Object ob) throws IOException {
        ObjectWriter writer = new SimpleWriter();
        Element el = writer.write(ob);
        XMLOutputter out = new XMLOutputter();
        out.output(el, outputStream);
    }

    public void close() throws IOException {
        outputStream.close();
    }
}
