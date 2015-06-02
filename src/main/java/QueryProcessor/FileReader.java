package QueryProcessor;

import com.hp.hpl.jena.rdf.model.*;
import com.hp.hpl.jena.util.FileManager;

import javax.swing.plaf.nimbus.State;
import java.io.InputStream;
import java.util.Iterator;

/**
 * Created by deepaknair on 4/4/15.
 */
public class FileReader {

    public static void main(String[] args) {
        Model telegraphisCapitals = ModelFactory.createDefaultModel();
        InputStream fileInputStream = FileManager.get().open("capitals.rdf");
        if (fileInputStream == null) {
            throw new IllegalArgumentException("File naming error");
        }
        telegraphisCapitals.read(fileInputStream, null);
        StmtIterator iterator = telegraphisCapitals.listStatements();
        int i = 1;
        while (iterator.hasNext()) {

            System.out.println(i++);
            Statement statement = iterator.nextStatement();
            Resource subject = statement.getSubject();
            Property predicate = statement.getPredicate();
            RDFNode object = statement.getObject();

            System.out.println("subject =" + subject);
            System.out.println("predicate =" + predicate);

            if (object instanceof Resource) {
                System.out.println("object=" + object);
            } else {
                System.out.println("//" + object + "//");
            }

            System.out.println("---------------------------------------------");
        }


    }


}


