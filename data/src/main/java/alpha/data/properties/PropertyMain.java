package alpha.data.properties;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import alpha.data.constans.ConstansGlobal;

public class PropertyMain {
	public static void main(String[] args)  {

		Properties proper = new Properties();
		InputStream in = null;
		
		try {
			in = new FileInputStream(ConstansGlobal.URL_PROPERTIES);
			proper.load(in);
			
			System.out.println(proper.getProperty("db.username"));
			proper.setProperty("nombre", "paco");
			proper.store(new FileWriter(ConstansGlobal.URL_PROPERTIES),"esto es un comentario");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		PropertyImpl proper2 = new PropertyImpl();
		System.out.println(proper2.getProperty("db.username"));
		proper2.setKeyValueRepository("paseo.bimba","value123");
		
		HashMap<String, String> mapa = new HashMap<String, String>();
		mapa.put("key1", "value1");
		mapa.put("key2", "value2");
		mapa.put("key3", "value3");
		mapa.put("key4", "value4");
		mapa.put("key5", "value5");
		
		proper2.setKeyValueRepository(mapa);
		
	}
	

	
}
