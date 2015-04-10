package pt.tecnico.sd.store;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import javax.jws.*;

import pt.ulisboa.tecnico.sdis.store.ws.*;
import example.ws.*; // classes generated from WSDL

@WebService(
    endpointInterface="pt.ulisboa.tecnico.sdis.store.ws.SDStore", 
    wsdlLocation="SD-STORE.1_1.wsdl",
    name="SdStore",
    portName="SDStoreImplPort",
    targetNamespace="urn:pt:ulisboa:tecnico:sdis:store:ws",
    serviceName="SDStore"
)
public class StoreImpl implements SDStore {
	
	List<Doc> documentos = new ArrayList<Doc>();
	
	HashMap<String, List<Doc>> utilizador = new HashMap<String, List<Doc>>();

	private Scanner util;
	private Scanner doc;

    /**
     * 
     * @param docUserPair
     * @throws DocAlreadyExists_Exception
     */

    public void createDoc(DocUserPair docUserPair) throws DocAlreadyExists_Exception {
    	System.out.println("Indique o utilizador: /n");
    	util = new Scanner(System.in);
    
    	while (!utilizador.containsKey(util)){
    		System.out.println("Utilizador nao existe");
    		util = new Scanner(System.in);
    	}
    	
    	System.out.println("Indique o nome do docmento a criar: /n");
    	doc = new Scanner(System.in);
    	
    	utilizador.put(util+"", documentos);
    
    	while (utilizador.containsValue(documentos.contains(doc))){
    		System.out.println("Documento ja existe");
    		doc = new Scanner(System.in);
    	}
    	
    	
    	docUserPair.setUserId("" + util);
		docUserPair.setDocumentId("");
	}


    /**
     * 
     * @param userId
     * @return
     *     returns java.util.List<java.lang.String>
     * @throws UserDoesNotExist_Exception
     */

    public List<String> listDocs(
        @WebParam(name = "userId", targetNamespace = "")
        String userId)
        throws UserDoesNotExist_Exception
    ;

    /**
     * 
     * @param contents
     * @param docUserPair
     * @throws UserDoesNotExist_Exception
     * @throws DocDoesNotExist_Exception
     * @throws CapacityExceeded_Exception
     */
    @WebMethod
    @RequestWrapper(localName = "store", targetNamespace = "urn:pt:ulisboa:tecnico:sdis:store:ws", className = "pt.ulisboa.tecnico.sdis.store.ws.Store")
    @ResponseWrapper(localName = "storeResponse", targetNamespace = "urn:pt:ulisboa:tecnico:sdis:store:ws", className = "pt.ulisboa.tecnico.sdis.store.ws.StoreResponse")
    public void store(@WebParam(name = "docUserPair", targetNamespace = "") DocUserPair docUserPair, @WebParam(name = "contents", targetNamespace = "")
        byte[] contents)
        throws CapacityExceeded_Exception, DocDoesNotExist_Exception, UserDoesNotExist_Exception
    ;

    /**
     * 
     * @param docUserPair
     * @return
     *     returns byte[]
     * @throws UserDoesNotExist_Exception
     * @throws DocDoesNotExist_Exception
     */
    @WebMethod
    @WebResult(name = "contents", targetNamespace = "")
    @RequestWrapper(localName = "load", targetNamespace = "urn:pt:ulisboa:tecnico:sdis:store:ws", className = "pt.ulisboa.tecnico.sdis.store.ws.Load")
    @ResponseWrapper(localName = "loadResponse", targetNamespace = "urn:pt:ulisboa:tecnico:sdis:store:ws", className = "pt.ulisboa.tecnico.sdis.store.ws.LoadResponse")
    public byte[] load( @WebParam(name = "docUserPair", targetNamespace = "") DocUserPair docUserPair) 
    throws DocDoesNotExist_Exception, UserDoesNotExist_Exception{
    	

    }

}
