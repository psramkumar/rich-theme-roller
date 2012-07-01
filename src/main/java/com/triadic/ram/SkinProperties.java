package com.triadic.ram;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@ViewScoped
public class SkinProperties implements java.io.Serializable{
	private static final long serialVersionUID = 5349176686421710106L;
	private Properties env = new Properties();
	public SkinProperties(){init();	}
	
	public List<ValuePair> getValuePair(){
		List<ValuePair> list = new ArrayList<ValuePair>();
		for(Entry<Object, Object> e: env.entrySet()){
			list.add(new ValuePair(e.getKey().toString(), e.getValue().toString()));
		}
		return list;
	}
	
	public void init(){
		try {
			String url = "META-INF/skins/verizon.skin.properties";
			URL path = this.getClass().getResource("SkinProperties.class");
			String dPath= path.toString().replace("com/triadic/ram/SkinProperties.class", url).replace("file:/", "").replace("vfs:/", "");
			System.out.println("Derived Path : "+dPath);
			InputStream is = new FileInputStream(dPath);
			env.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@PostConstruct 
	void initialiseSession() { 
	    FacesContext.getCurrentInstance().getExternalContext().getSession(true); 
	    /** inorder to avoid an Error Caused by: java.lang.IllegalStateException: 
	     * Cannot create a session after the response has been committed
	     <context-param> 
		    <param-name>javax.faces.STATE_SAVING_METHOD</param-name> 
		    <param-value>client</param-value> 
		 </context-param> 
	     
	     */
	} 
}
