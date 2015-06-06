package dummyFusekiWriter;

import com.hp.hpl.jena.query.DatasetAccessor;
import com.hp.hpl.jena.query.DatasetAccessorFactory;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.util.FileManager;

import java.io.InputStream;

/**
 * @author Deepak Nair
 */
public class FusekiStore {

    /**
     * Takes in a model as an input and writes it into Fueski
     *
     * @param model
     */
    static void putIntoFuseki(Model model) {
        String serviceURI = "http://localhost:3030/envirocar/data";
        DatasetAccessorFactory factory = new DatasetAccessorFactory();
        DatasetAccessor accessor;
        accessor = factory.createHTTP(serviceURI);
        accessor.putModel(model);

    }


    public static void main(String[] args) {
        //initializing input strings,log4j and creating an empty model
        String inputFileName = "/Users/deepaknair/Downloads/capitals.rdf";
        Model model = ModelFactory.createDefaultModel();

        // use the FileManager to find the input file
        InputStream in = FileManager.get().open(inputFileName);
        if (in == null) {
            throw new IllegalArgumentException(
                    "File: " + inputFileName + " not found");
        }
        model.read(in, "http://envirocar/endpoint#", "RDF/XML");
        model.write(System.out, "N-TRIPLES");
        putIntoFuseki(model);

    }

}
