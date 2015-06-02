This is a development Repo for all Linked Data Branches which are meant to be tests with sample enviroCar data
and development of new features before incorporating them into EnviroCar's server

 Packages
 - dummyFusekiWriter
 - Query Processor

 To Run SPARQL endpoint
 - clone the repo into your local developmental branch
 - modify inputFileName in FusekiStore.java to point the "measurements.rdf" included in the repo which is a sample enviroCar rdf data
 - Run fuseki using the start script and run on default http://locahost:3030
 - Once fuseki is running run Fusekistore.java from the the IDE or mvn
 - Now you should see the sample enviroCar data stored in fuseki
