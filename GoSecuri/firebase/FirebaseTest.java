import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

import org.junit.Test;

import com.boc.gosecuri.controller.dao.FireBaseDao;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import junit.framework.Assert;
import util.ConnectionFirebase;


public class FirebaseTest {

	
	@Test
	public void firebaseTest() {
		FireBaseDao dao = new FireBaseDao();
		List<Object> trucs;
		try {
			trucs = dao.getTrucs();
			Assert.assertTrue(trucs.size()>0);

		} catch (TechnicalException e) {
			
			e.printStackTrace();
			Assert.fail();
		}
	}
}