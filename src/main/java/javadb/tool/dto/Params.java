package javadb.tool.dto;

import com.beust.jcommander.*;
import java.util.*;

public class Params
{
	@Parameter(names = "--url", required = true)
	private String url;

	@Parameter(names = "--driver", required = true)
	private String driver;

	@Parameter(names = "--query")
	private String query;

	@Parameter(names = "--help", help = true)
	private boolean help = false;

	@DynamicParameter(names = "-D", description = "Java db params")
	private Map<String, String> params = new HashMap<String, String>();

	public String getUrl(){
		return this.url;
	}

	public String getDriver(){
		return this.driver;
	}

	public String getQuery(){
		return this.query;
	}

	public boolean getHelp(){
		return this.help;
	}

	public Map<String, String> getParams(){
		return this.params;
	}

}

