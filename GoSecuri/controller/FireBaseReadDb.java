package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Semaphore;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import util.FirebaseUtil;
import util.exception.TechnicalException;

public class FireBaseReadDb {

	public List<Object> getElements() throws TechnicalException{
		FirebaseUtil firebaseUtil = new FirebaseUtil();
		Firestore database = firebaseUtil.getInstance().firebaseDatabase();

		final List<Object> result = new ArrayList<Object>();

		
		Iterable<CollectionReference> collections = database.getCollections();
		for (CollectionReference col:collections) {
			System.out.println("col "+col.getId()+" "+col.getPath());
		}
		
		// Pour chaque collection de la base de donné il faut utiliser ce blocque 
		CollectionReference data_faces =database.collection("data_faces");
		ApiFuture<QuerySnapshot> apiFuturedf = data_faces.get();
		try {
			QuerySnapshot querySnapshot = apiFuturedf.get();
			 List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();
			 
			 for (QueryDocumentSnapshot doc:documents) {
				  System.out.println("Document data: " + doc.getData());
				  result.add(doc.get("id"));
			 }
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		CollectionReference equipement = database.collection("equipement");
		ApiFuture<QuerySnapshot> apiFuture = equipement.get();
		try {
			QuerySnapshot querySnapshot = apiFuture.get();
			 List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();
			 
			 for (QueryDocumentSnapshot doc:documents) {
				  System.out.println("Document data: " + doc.getData());
				  result.add(doc.get("id"));
			 }
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		CollectionReference loans = database.collection("loans");
		ApiFuture<QuerySnapshot> apiFutureloans = loans.get();
		try {
			QuerySnapshot querySnapshot = apiFutureloans.get();
			 List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();
			 
			 for (QueryDocumentSnapshot doc:documents) {
				  System.out.println("Document data: " + doc.getData());
				  result.add(doc.get("id"));
			 }
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	
		
		
		CollectionReference photo =database.collection("photo");
		ApiFuture<QuerySnapshot> apiFuturephoto = photo.get();
		try {
			QuerySnapshot querySnapshot = apiFuturephoto.get();
			 List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();
			 
			 for (QueryDocumentSnapshot doc:documents) {
				  System.out.println("Document data: " + doc.getData());
				  result.add(doc.get("id"));
			 }
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		CollectionReference rights =database.collection("rights");
		ApiFuture<QuerySnapshot> apiFuturerights = rights.get();
		try {
			QuerySnapshot querySnapshot = apiFuturerights.get();
			 List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();
			 
			 for (QueryDocumentSnapshot doc:documents) {
				  System.out.println("Document data: " + doc.getData());
				  result.add(doc.get("id"));
			 }
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		CollectionReference user =database.collection("user");
		ApiFuture<QuerySnapshot> apiFutureuser = user.get();
		try {
			QuerySnapshot querySnapshot = apiFutureuser.get();
			 List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();
			 
			 for (QueryDocumentSnapshot doc:documents) {
				  System.out.println("Document data: " + doc.getData());
				  result.add(doc.get("id"));
			 }
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		

		return result;
		
		
		
		
		
	}
}