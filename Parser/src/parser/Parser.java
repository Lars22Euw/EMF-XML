package parser;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl.Container;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.Namespace;
import org.jdom2.input.SAXBuilder;


public class Parser {

	
	public static void main(String[] args) {
				
        SAXBuilder saxBuilder = new SAXBuilder();
        
        var file = new File("map.osm");
		final Document document = saxBuilder.build(file);

        /*try {
        parsedFile = saxBuilder.build(is);

        } catch (JDOMException | IOException e) {
        throw new IOException(e.getMessage(), e.getCause());
        }*/
        
        final Element rootElement = document.getRootElement();
        
		ResourceSet rs = new ResourceSetImpl();
		Resource r = rs.createResource(URI.createFileURI("misc/model.xmi"));


		// ---- parse xml
		
		var children = rootElement.getChildren();
		for (var child : children) {
			if (child.getClass().equals(r)) {
				
			}
		}

		Container c = XMLFactory.eINSTANCE.createContainer();
		r.getContents().add(c);

		            
		Element e = XMLFactory.eINSTANCE.createElement();
		c.getE().add(e);

		            

		try {
		r.save(null);
		} catch (IOException er) {
		       // TODO Auto-generated catch block
		       er.printStackTrace();

		}
	}
}
