package datamanagement;

import java.io.FileWriter;
import java.io.IOException;

import org.jdom.Document;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

/**
 * Handles creating and saving XML files
 */
public class XmlManager
{
  private static XmlManager self_ = null;
  private Document document_;



  /**
   * Getter for the current XmlManager object.
   * Initialises a new XmlManager object if
   * one has not already been initialised.
   * Singleton pattern.
   *
   * @return XmlManager object instance
   */
  public static XmlManager getInstance()
  {
    if (self_ == null )
      self_ = new XmlManager();
    return self_;
  }



  /**
   * Constructor.
   * calls initialize().
   */
  private XmlManager()
  {
    initialize();
  }



  /**
   * Initialises the document_ variable
   *
   * @throws RuntimeException
   */
  public void initialize()
  {
    String string = AppProperties.getInstance().getProperties().getProperty("XMLFILE");
    try {
      SAXBuilder builder = new SAXBuilder();
      builder.setExpandEntities(true);
      document_ = builder.build(string);
    }
    catch (JDOMException exception) {
      System.err.printf( "%s", "DBMD: XmlManager : initialize : caught JDOMException\n" );
      throw new RuntimeException("DBMD: XmlManager : initialize : JDOMException");
    }
    catch (IOException exception) {
      System.err.printf( "%s", "DBMD: XmlManager : initialize : caught IOException\n" );
      throw new RuntimeException("DBMD: XmlManager : initialize : IOException");
    }
  }



  /**
   * Getter for the current Document
   *
   * @return Document object
   */
  public Document getDocument()
  {
    return document_;
  }



  /**
   * Saves the current Document
   *
   * @throws RuntimeException
   */
  public void saveDocument()
  {
    String xmlfile = AppProperties.getInstance().getProperties().getProperty("XMLFILE");
    try (FileWriter fout = new FileWriter(xmlfile)) {
      XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());
      outputter.output(document_, fout);
      fout.close();
    }
    catch (IOException exception) {
      System.err.printf( "%s\n", "DBMD : XmlManager : saveDocument : Error saving XML to " + xmlfile);
      throw new RuntimeException("DBMD: XmlManager : saveDocument : error writing to file");
    }
  }

}
