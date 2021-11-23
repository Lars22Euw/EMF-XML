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
				
        InputStream is; /* some input file */
        SAXBuilder saxBuilder = new SAXBuilder();
        
        var file = new File("test.txt");
		final Document document = saxBuilder.build(file);
        
        Document parsedFile = null;

        try {
        parsedFile = saxBuilder.build(is);

        } catch (JDOMException | IOException e) {
        throw new IOException(e.getMessage(), e.getCause());
        }
        
        final Element rootElement = document.getRootElement();
        
		ResourceSet rs = new ResourceSetImpl();

		Resource r = rs.createResource(URI.createFileURI("misc/model.xmi"));


		// ---- parse xml
		
		var children = rootElement.getChildren();
		

		Container c = TrianglesFactory.eINSTANCE.createContainer();

		Container c1 = TrianglesFactory.eINSTANCE.createContainer();

		            

		r.getContents().add(c);

		r.getContents().add(c1);

		            

		A_Class a = TrianglesFactory.eINSTANCE.createA_Class();

		c.getA().add(a);

		c1.getA().add(a);

		            

		try {

		r.save(null);

		} catch (IOException e) {

		       // TODO Auto-generated catch block

		       e.printStackTrace();

		}
	}
}
