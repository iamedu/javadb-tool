package javadb.tool;

import java.util.*;
import java.sql.*;
import javadb.tool.dto.*;
import com.beust.jcommander.*;

public class App
{
	public static void main(String[] args) throws Exception
	{
		Params params = new Params();
		JCommander commander = new JCommander(params, args);

		if(params.getHelp()) {
			commander.usage();
			return;
		}

		//Register class
		Class.forName(params.getDriver());

		Properties p = new Properties();
		for (Map.Entry<String,String> entry : params.getParams().entrySet()) {
			p.put(entry.getKey(), entry.getValue());
		}
		Connection conn = DriverManager.getConnection(params.getUrl(), p);

		try {
			String content = params.getQuery();
			if(content == null) {
				content = new Scanner(System.in).useDelimiter("\\Z").next();
			}
			Statement st = conn.createStatement();
			st.execute(content);
		} finally {
			conn.close();
		}

	}
}
