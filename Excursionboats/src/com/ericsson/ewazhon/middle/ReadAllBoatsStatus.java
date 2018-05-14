package com.ericsson.ewazhon.middle;

import java.sql.ResultSet;
import java.util.Vector;

import com.ericsson.ewazhon.common.AppException;
import com.ericsson.ewazhon.database.ClientDatabaseHelp;
import com.ericsson.ewazhon.model.LatestStatus;

public class ReadAllBoatsStatus {

	public Vector<LatestStatus> selectLatestStatusRequst() throws Exception {

		Vector<LatestStatus> boatsStatus = new Vector<LatestStatus>();
		
		String sql = "select * from lateststatus";
		
		try {
			ResultSet rs = ClientDatabaseHelp.getInstance().executeQuery(sql);
			while (rs.next()) {
				LatestStatus ls = new LatestStatus(rs.getInt("idboats"),
												   rs.getFloat("longitude"),
												   rs.getFloat("latitude"),
												   rs.getFloat("altitude"),
												   rs.getString("event"));
				boatsStatus.add(ls);
			}
			
			rs.close();
			ClientDatabaseHelp.getInstance().CloseDataBase();
			
		} catch (Exception ex) {
			String error = "execute rs.next in  " + sql + ex.getMessage();
			throw new AppException(error, ex.getCause());
		}

		return boatsStatus;
	}


}
