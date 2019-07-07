package util;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;


import util.exception.TechnicalException;

public class FirebaseUtil {

	

		
		//Méthode alternative mais peu recommandable car on push sur git.
		//Input Stream service Account =  new FileinputStream('path/AccountJavaEpsiB3.json')
		//Clé json firebase 
		String KEY_FILE="nMIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDck8OkjI4ayf4G\\nQ9nuhJM8tf6CjpXrJhEYPitZPD/dzk6sl8owmBS5xyx2pqEjjqukBeWrjElCkuph\\nMMxkwFdriAk3KBH7LHiG3LQ5WgvfmLALV3+sxRQU7p2JmimsptP8NBMALtPh9ZDD\\nTzk8t6YZIJ2YaPphEb30D//RG8vNyl5smtTN+wx1sfQJIge83yGKkwRkrVdr4mtp\\nSRCeSH8vFL5Im8POBwSkMkCg+SF22/GH4VapOMkbLYGw3H5tgo8FsfM8BD2EUZjr\\ndg2gNrIKMaIDJdLMjQrSkMR6T7O9b1coZwdI2SzrGjMRqxev9w0fgueKXXXt5R6p\\nVIVIQc2VAgMBAAECggEAXllEH3/RjurkochnEQubMSZFkZGs1bLoL/7zqs1HIjiL\\nVW7t2MBMaTSlM7FNjriJeXTeSvUMJxJRd7YYT2YoXoIHMxUML+xTN5hy7G80UfVt\\nI8TPA1cfIl74erG67rNDTIb3s6XUErxnqesat/pz7R6S2mzY4ClnH1yylz60+7Yv\\nMO0wojy4D0h7vSCx4xWK6tIQ4RiNZjHgRWFsRO/kt9LQIBvzgC80SCQFaZUsDvlx\\nTYPRwNrK0yWVybpIZpYEJFRw9Uo8q4TasNUSqKDguKK9CxctKNaMM5CB1wkJsqZH\\nrCHgU3h62Md3TPdTqDAKlZ6rzs7z4qDc+0B6JLollwKBgQD06szrE1WN9xGdd/xQ\\nN04XvVy2zNMztxpbUEkt/YjWel97zcnTDiXjEBIIUokUwtKID0ndjlzKNKaZgqus\\nB+U6U6ITb1L8y11f7xzS9M5et17IMYqXmunDP+hKDCHptlaEu4/wdnoQM0asFier\\n/O2bJ/D5hIREBTTCLQx2JOYG/wKBgQDmjwBlRDBQvx9bx83zgSIsND4N954+4H/p\\n7n3fXUqxD1dB3AcW00LBW6Yy5QOe/KuP07GoSP6/MvEkohQShTCrKUKRvnsW+y0k\\nXQeDid+gR+uK98XLXV2go4YDlAdTmCY9J5b/1Swei/YQkwHYty5edYdnz5GHHeHN\\nZB4vIrwfawKBgGDCsxrclJx11DvGP6ThdLTkV1DRM0/nMz6IRaEp3Xn+9uJOt0Hv\\nAQDoRHeNRCMzpUGj6Kbjq70nd/qGKZTZubKFgC71eG/vWICiU1z04uOAxq2JBRxI\\nU7qT8Q3wJSXUp/HguElkRW1JFM7AIgRM9QKrkQTDWg4VkHZ2ncm/YjG5AoGAV6hk\\n+Rt81yZjMMz9k6g0KuRN95d+ld9bIsDnIIZiwIDZpxOVqmr2BXfn74+82bStMcjF\\n0fq2yFEA9/GbehMjlt/gDHOEbw9ecWXhVnSUDmdpuXNMw24jC9FAQZoFUxYU68li\\nkrAkzxRdoJ2T5SZ4PbennKOBbALDeAippTgqmDMCgYEAptdK+7Qxt0H151rs1Kn+\\nwg0JTpdP0mHN9w0BGFUJZG50SevgvMAzOt4RNP8waJH0h8NNvxTHArjKgLGkzXca\\n1e37Mi3ps3lc6wHEgzfSiJfrfygifgPcg8/N2Jo4YH6WSk8z77cZsY/XvvXkpp8V\\nXawdBHmCCd8gGYQG7cX9Lno";
		
	

		private FirebaseUtil instance;
		//Creation instance fire base.
		public FirebaseUtil getInstance() {
			if (instance == null) {
				instance = new FirebaseUtil();
				try {
					instance.init();
				} catch (TechnicalException e) {
					// FAIL
					e.printStackTrace();
				}
			}
			return instance;
		}
		
		
		
		//il y' a deux types de "bases" sur firebase ceux en temps réel et firestore, Dans le projet on utilise firestore
		public Firestore firebaseDatabase() {
			Firestore database = FirestoreClient.getFirestore();
			return database;
		
		}
		
		@PostConstruct
		void init() throws TechnicalException {
			try {

				FirebaseOptions options = new FirebaseOptions.Builder()
						.setCredentials(
								GoogleCredentials.fromStream(firebaseKey()))
						.setDatabaseUrl("(\"https://java-un-epsi-b3.firebaseio.com\"").build();
				    if(FirebaseApp.getApps().isEmpty()) { 
						FirebaseApp.initializeApp(options);
		            }
			} catch (FileNotFoundException e) {

				TechnicalException.throwTechnicalException("key file not found", e);
			} catch (IOException e) {
				TechnicalException.throwTechnicalException("io exception", e);
			}
		}
		
		
		// encodage de la clé 
		@Bean
		public InputStream firebaseKey ( ) throws IOException {
			byte[] decode = Base64.getDecoder().decode(KEY_FILE);
			return  new ByteArrayInputStream(decode);
			
		}
		
	

	}
	
