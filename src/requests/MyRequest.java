/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package requests;

/**
 *
 * @author Piedra Fernandez Gabriel (236557)
 */
import configuration.MyConfiguration;
import encrypted.MyEncrypt;
import gui.App;
import java.awt.Component;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.swing.JOptionPane;
import org.json.JSONObject;

public class MyRequest extends Thread {

    private String line;

    public MyRequest(String line) {
        this.line = line;
    }

    public void run() {
        this.requestAPI(this.line);
    }

    public void requestAPI(String str) {
        try {
            URL endpoint = new URL(MyEncrypt.Decrypt("aHR0cDovL2FwcDkuc3VzYWx1ZC5nb2IucGU6ODA4MC9ycy1zZXJ2aWNpby1jaXVkYWRhbm8vc2VydmVyL2dldEFmZmlsaWF0aW9ucw=="));
            HttpURLConnection conn = (HttpURLConnection) endpoint.openConnection();
            conn.setConnectTimeout(860);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            Throwable var4 = null;
            StringBuffer response = null;

            try {
                OutputStream OS = conn.getOutputStream();

                try {
                    byte[] exit = MyConfiguration.bodyPost(str).getBytes("UTF-8");
                    OS.write(exit, 0, exit.length);
                } finally {
                    if (OS != null) {
                        OS.close();
                    }

                }
            } catch (Throwable var18) {
                if (var4 == null) {
                    var4 = var18;
                } else if (var4 != var18) {
                    var4.addSuppressed(var18);
                }
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            response = new StringBuffer();

            String line;
            while ((line = br.readLine()) != null) {
                response.append(line);
            }

            br.close();
            int status_code = conn.getResponseCode();
            JSONObject myResponse = new JSONObject(response.toString());
            if (status_code == 200) {
                if (myResponse.getJSONArray("listaCiudadano").length() == 1) {
                    String fec_nac = myResponse.getJSONArray("listaCiudadano").getJSONObject(0).getString("p_per_fecnac");
                    String[] pwd = fec_nac.split("/");
                    App.txtOK.append(str + "|" + pwd[0] + pwd[1] + "|" + pwd[2] + "\n");
                } else {
                    App.txtFailed.append(str + " - Sin resultados.\n");
                }
            } else {
                JOptionPane.showMessageDialog((Component) null, "Ocurrio un error en la peticion, cod : " + status_code);
            }
        } catch (Exception var19) {
            var19.printStackTrace();
            Thread.interrupted();
        }

    }
}
