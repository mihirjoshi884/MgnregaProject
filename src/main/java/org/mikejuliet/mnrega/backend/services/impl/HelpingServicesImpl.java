package org.mikejuliet.mnrega.backend.services.impl;

import org.mikejuliet.mnrega.backend.services.helpingServices;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;


public class HelpingServicesImpl implements helpingServices {

    private static String protectedPassword;
    public String BDOuser_code(int id) {
        String BDO_code = "BDO"+id;
        return BDO_code;
    }

    public String GPMuser_code(int id) {
        String GPM_code = "GPM"+id;
        return GPM_code;
    }

    public String project_code(Integer id,String projectName) {
        String proj = projectName.substring(0,2)+ id.toString();
        return proj;
    }

    public String employeeCode(int id ) {

        String emp_code = "EMP"+id;
        return emp_code;
    }

    public int idForProject_allocation() {
        //generating random project_allocation value
        Random random = new Random();
        int projAllocId = random.nextInt(9000)+1000;
        return projAllocId;
    }

    public String employeeCode(String emp_code , String project) {
        String proj = project.substring(0,2);
        emp_code = emp_code.concat(proj);
        return emp_code;
    }

    public String passwordProtection(String password) {
        try {
            // Create a MessageDigest instance with SHA-256 algorithm
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            // Convert the input string to bytes
            byte[] inputBytes = password.getBytes("UTF-8");

            // Generate the hash value
            byte[] hashBytes = digest.digest(inputBytes);

            // Convert the hash bytes to a hexadecimal string representation
            StringBuilder hexBuilder = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = String.format("%02x", b);
                hexBuilder.append(hex);
            }
            protectedPassword = hexBuilder.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        return protectedPassword;
    }
}
