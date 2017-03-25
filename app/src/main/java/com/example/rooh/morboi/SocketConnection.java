/*
import android.util.Log;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URI;
import java.net.URISyntaxException;

*/
/**
 * Created by rooh1 on 22-Mar-17.
 *//*


public class SocketConnection {
    private void connectWebSocket() {
        URI uri;
        try {
            uri = new URI("ws://192.168.1.148:8081");
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return;
        }

        mWebSocketClient = new WebSocketClient(uri) {
            @Override
            public void onOpen(ServerHandshake serverHandshake) {
                Log.i("Websocket", "Opened");
                String json = "{type: 'connection'}";

                try {

                    JSONObject obj = new JSONObject(json);
                    mWebSocketClient.send(new JSONObject(json).toString());
                    Log.d("My App", obj.toString());

                } catch (Throwable t) {
                    Log.e("My App", "Could not parse malformed JSON: \"" + json + "\"");
                }
            }

            @Override
            public void onMessage(String s) {
                String message = s;
                try {
                    JSONObject j = new JSONObject(s);
                    message = j.getString("field");

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                final String finalMessage = message;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //TextView textView = (TextView)findViewById(R.id.rez);
                        resp_text.setText(finalMessage);
                    }
                });
            }

            @Override
            public void onClose(int i, String s, boolean b) {
                Log.i("Websocket", "Closed " + s);
            }

            @Override
            public void onError(Exception e) {
                Log.i("Websocket", "Error " + e.getMessage());
            }
        };
        //mWebSocketClient.connect();
    }
}
*/
