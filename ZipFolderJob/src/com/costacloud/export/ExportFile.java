package com.costacloud.export;

import java.io.PrintWriter;
import java.util.Map;

import com.documentum.com.DfClientX;
import com.documentum.com.IDfClientX;
import com.documentum.fc.client.DfSingleDocbaseModule;
import com.documentum.fc.client.IDfSession;
import com.documentum.fc.client.IDfSysObject;
import com.documentum.fc.common.DfId;
import com.documentum.fc.methodserver.IDfMethod;
import com.documentum.operations.IDfExportOperation;

public class ExportFile extends DfSingleDocbaseModule implements IDfMethod {
	public IDfSession dsession=null;
	@Override
	public int execute(Map arg0, PrintWriter arg1) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	public Boolean exportFile(String id,String temp){
		try{
		IDfSysObject obj = (IDfSysObject)dsession.getObject(new DfId(id));	
		IDfClientX clientx = new DfClientX();
		IDfExportOperation exportdoc = clientx.getExportOperation();
		exportdoc.setDestinationDirectory(temp);
		exportdoc.add(obj);
		if(exportdoc.execute())
		return true;
		else
			return false;
	}catch(Exception e){e.printStackTrace();}
		return null;
}
}
