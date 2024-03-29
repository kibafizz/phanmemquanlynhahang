/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vn.edu.vttu.data;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Statement;

/**
 *
 * @author nhphuoc
 */
public class ServiceCost {
    private int ID_SERVICE;
    private String beginDate;
    private int COST;

    public int getID_SERVICE() {
        return ID_SERVICE;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public int getCOST() {
        return COST;
    }
    
    public static boolean insert(int sv_id, int cost, Connection conn) {
        boolean flag = false;
        try {            
            String sql = "CALL service_cost_insert(?,?)";
            CallableStatement callstate = conn.prepareCall(sql);
            callstate.setInt(1, sv_id);
            callstate.setInt(2, cost);            
            int x = callstate.executeUpdate();
            if (x == 1) {
                flag = true;
            } else {
                flag = false;
            }
        } catch (Exception e) {
            flag = false;
            e.printStackTrace();
        }

        return flag;
    }
    
    
}
