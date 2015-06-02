package QueryProcessor;

import com.hp.hpl.jena.rdf.model.*;
import com.hp.hpl.jena.vocabulary.VCARD;

/**
 * Created by deepaknair on 4/3/15.
 */
public class ArqEngine {

    public static void main(String[] args) {
         String URI = "http://www.deepaknair.com";
         String fulname = "Deepak Nair";
        // Creating empty an resource
        Model model = ModelFactory.createDefaultModel();
        Resource johnSmith = model.createResource(URI);
        johnSmith.addProperty(VCARD.FN, fulname);

        johnSmith.addProperty(VCARD.N,model.createResource().addProperty(VCARD.Given,"john").addProperty(VCARD.Family,"smith").addProperty(VCARD.Country,"India"));
        StmtIterator iterator = model.listStatements();
        int i=1;
        while(iterator.hasNext())
        {
            System.out.println(i++);
            Statement stmt = iterator.nextStatement();

            Resource subject = stmt.getSubject();
            Property predicate = stmt.getPredicate();
            RDFNode object = stmt.getObject();

            System.out.println("subject =" + subject);
            System.out.println("predicate =" + predicate);

            if( object instanceof Resource)
            {
                System.out.println("object="+object);
            }
            else
            {
                System.out.println("//" + object + "//");
            }

            System.out.println("------------------------------------------------------------");
        }


model.write(System.out);

    }


}
