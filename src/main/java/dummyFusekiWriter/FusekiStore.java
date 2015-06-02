package dummyFusekiWriter;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.query.DatasetAccessor;
import com.hp.hpl.jena.query.DatasetAccessorFactory;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.util.FileManager;
import com.hp.hpl.jena.vocabulary.VCARD;

import java.io.InputStream;

/**
 * @author Deepak Nair
 */
public class FusekiStore {

    /**
     * Takes in a model as an input and writes it into Fueski
     * @param model
     */
    static void putIntoFuseki(Model model)
    {
        String serviceURI = "http://localhost:3030/envirocar/data";
        DatasetAccessorFactory factory= new DatasetAccessorFactory() ;
        DatasetAccessor accessor;
        accessor = factory.createHTTP(serviceURI);
        accessor.putModel(model);

    }


    public static void main(String[] args)
    {
        String inputFileName="/Users/deepaknair/Documents/responce.rdf";
        Model model = ModelFactory.createDefaultModel();

        Model model1=ModelFactory.createDefaultModel();
        String URI = "http://www.deepaknair.com";
        String fulname = "Deepak Nair";
        // Creating empty an resource
        Resource johnSmith = model.createResource(URI);
        johnSmith.addProperty(VCARD.FN, fulname);
        johnSmith.addProperty(VCARD.N,model.createResource().addProperty(VCARD.Given,"john").addProperty(VCARD.Family,"smith").addProperty(VCARD.Country,"India"));
        // use the FileManager to find the input file
        InputStream in = FileManager.get().open( inputFileName );
        if (in == null) {
            throw new IllegalArgumentException(
                    "File: " + inputFileName + " not found");
        }
        model1.read(in,"http://envirocar/endpoint#","RDF/XML");
        model1.write(System.out,"N-TRIPLES");
        putIntoFuseki(model1);

    }

}
