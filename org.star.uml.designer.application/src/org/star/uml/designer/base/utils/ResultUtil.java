package org.star.uml.designer.base.utils;

import java.io.Reader;
import java.sql.Clob;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultUtil {
	public static List<Map<String, Object>> transDatasList(ResultSet rs) throws Exception {
        ResultSetMetaData rsmd = null;
    
        
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        
        try {
            rsmd = rs.getMetaData();
            int aa = 0;
            while(rs.next()) {
                Map<String, Object> m = new HashMap<String, Object>();
                for (int colIdx = 1; colIdx <= rsmd.getColumnCount(); colIdx++){
                    
                    if (rs.getObject(rsmd.getColumnName(colIdx)) instanceof Clob) {
                        StringBuffer output = new StringBuffer();
                        Reader input = rs.getCharacterStream(rsmd.getColumnName(colIdx));
                        char[] buffer = new char[1024];
                        int byteRead;
                        while ((byteRead = input.read(buffer, 0, 1024)) != -1) {
                            output.append(buffer, 0, byteRead);
                        }
                        input.close();
        
                        m.put(rsmd.getColumnName(colIdx), output.toString());
                    } else {
                        m.put(rsmd.getColumnName(colIdx), rs.getObject(rsmd.getColumnName(colIdx)) == null ? "" : rs.getObject(rsmd.getColumnName(colIdx)).toString());
                    }            
                    
                }
                list.add(m);
            }
            return list;
        } catch (SQLException e) {
            throw e;
        } finally {
        }
    }            
    
    public static Map<String, Object> transDataMap(ResultSet rs) throws Exception {
        ResultSetMetaData rsmd = null;
        
        Map<String, Object> data = new HashMap<String, Object>();        
        Map<String, Object> contents = new HashMap<String, Object>();
        
        try {
            rsmd = rs.getMetaData();                            
            
            if(rs.next()){
                for (int colIdx = 1; colIdx <= rsmd.getColumnCount(); colIdx++){                    
                    if (rs.getObject(rsmd.getColumnName(colIdx)) instanceof Clob) {
                        StringBuffer output = new StringBuffer();
                        Reader input = rs.getCharacterStream(rsmd.getColumnName(colIdx));
                        char[] buffer = new char[1024];
                        int byteRead;
                        while ((byteRead = input.read(buffer, 0, 1024)) != -1) {
                            output.append(buffer, 0, byteRead);
                        }
                        input.close();
            
                        contents.put(rsmd.getColumnName(colIdx).toLowerCase(), output.toString());
                    } else {                                                                                        
                        contents.put(rsmd.getColumnName(colIdx), rs.getObject(rsmd.getColumnName(colIdx)) == null ? "" : rs.getObject(rsmd.getColumnName(colIdx)).toString());
                    }
                }                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return contents;
    }
}
